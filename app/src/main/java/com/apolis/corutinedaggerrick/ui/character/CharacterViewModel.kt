package com.apolis.corutinedaggerrick.ui.character

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.apolis.corutinedaggerrick.app.di.DaggerAppComponent
import com.apolis.corutinedaggerrick.data.models.Character
import com.apolis.corutinedaggerrick.data.repository.AppRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class CharacterViewModel @Inject constructor( val appRepository: AppRepository):ViewModel() {
    var characterList=MutableLiveData<ArrayList<Character>>()
    var characterGetListener:CharacterGetListener?=null
init {
    var componet=DaggerAppComponent.create().inject(this)
}
    fun getCharacterListFromRepo():MutableLiveData<ArrayList<Character>>{
        appRepository.characterList=characterList
        CoroutineScope(Dispatchers.IO).launch {
            appRepository.getCharacterFromDatabase()
        }
        characterGetListener!!.onGet(characterList)
        return characterList

    }

}