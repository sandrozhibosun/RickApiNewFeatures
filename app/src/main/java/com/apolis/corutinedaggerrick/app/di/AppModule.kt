package com.apolis.corutinedaggerrick.app.di

import com.apolis.corutinedaggerrick.app.Config
import com.apolis.corutinedaggerrick.data.database.instance.MyDBInstance
import com.apolis.corutinedaggerrick.data.database.instance.MyDatabase
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class RickNMortyServiceModule {
    private var baseURL: String = Config.BASE_URL
    private var builder: Retrofit.Builder

    init {
        builder = Retrofit.Builder()
            .baseUrl(baseURL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
//            .addCallAdapterFactory(RxJava2CallAdapterFactory.create()) //this is for rxjava

    }

    @Provides
    @Singleton
    fun createService(): RickNMortyService {
        val retrofit=builder.build()
        return retrofit.create(RickNMortyService::class.java)

    }


}
@Module
class DatabaseHelperModule{
    @Provides
    @Singleton
    fun createDatabaseHelper():MyDatabase{
        return MyDBInstance.getInstance()
    }
}