package com.apolis.corutinedaggerrick.data.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.apolis.corutinedaggerrick.app.di.DaggerAppComponent

import com.apolis.corutinedaggerrick.app.di.RickNMortyService
import com.apolis.corutinedaggerrick.data.database.instance.MyDatabase
import com.apolis.corutinedaggerrick.data.models.Character
import com.apolis.corutinedaggerrick.data.models.GetCharacterResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.security.PrivateKey
import javax.inject.Inject

class AppRepository @Inject constructor(
    val appDatabase: MyDatabase,
    val rickNMortyService: RickNMortyService
) {
    init {
        var component = DaggerAppComponent.create().inject(this)
    }

    var characterList = MutableLiveData<ArrayList<Character>>()

     fun getCharacterFromApi() {
        Log.d("abc", "getCharacterFromApi")


    }

     fun saveUserToLocal() {
        CoroutineScope(Dispatchers.Default).launch {

            Log.d("abc", "save to local")
//          appDatabase.getCharacterDao().addCharacterAll(rickNMortyService.getBasicCharacter().results)
            rickNMortyService.getBasicCharacter().enqueue(object : Callback<GetCharacterResponse> {
                override fun onFailure(call: Call<GetCharacterResponse>, t: Throwable) {
                    Log.d("abc", "onFailure getbasicCharacter")
                }

                override fun onResponse(
                    call: Call<GetCharacterResponse>,
                    response: Response<GetCharacterResponse>
                ) {
                    Log.d("thread", "response thread:${Thread.currentThread().name}")
                    Log.d("abc", "onSucess")
                    if(response.body()==null)
                    {
                        Log.d("abc","body is null")
                    }
                    appDatabase.getCharacterDao().addCharacterAll(response.body()!!.results)
                    var page = response.body()!!.info.pages
                    Log.d("abc",page.toString())
                    for (i in 2..page) {
                        getCharacterByPage(i)
//          }
                    }

                }
            })
        }
    }

    suspend fun getCharacterByPage(page: Int) {
        Log.d("abc", "getCharacterByPage")
        saveUserToLocal(page)
    }

    //overload method when have page
   suspend  fun saveUserToLocal(page: Int) {
        Log.d("abc", "save to local ByPage")
//        CoroutineScope(Dispatchers.IO).launch {
//            appDatabase.getCharacterDao()
//                .addCharacterAll(rickNMortyService.getCharacterByPage(page).enqueue(object :Call))


//        }
    }

    fun getCharacterFromDatabase() {
        CoroutineScope(Dispatchers.IO).launch {
            Log.d("abc", "getCharacterFromDatabase")
            getCharacterFromApi()
            saveUserToLocal()
            var res = ArrayList<Character>()
            res.addAll(
                appDatabase.getCharacterDao().getCharacter()
            )

            characterList.postValue(res)
        }
    }


}