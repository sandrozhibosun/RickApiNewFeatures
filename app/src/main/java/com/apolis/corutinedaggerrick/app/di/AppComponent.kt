package com.apolis.corutinedaggerrick.app.di

import com.apolis.corutinedaggerrick.data.repository.AppRepository
import com.apolis.corutinedaggerrick.ui.MainActivity
import com.apolis.corutinedaggerrick.ui.character.CharacterFragment
import com.apolis.corutinedaggerrick.ui.character.CharacterViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(RickNMortyServiceModule::class,DatabaseHelperModule::class))
interface AppComponent{
    fun inject(characterFragment: CharacterFragment)
    fun inject(appRepository: AppRepository)
    fun inject(characterViewModel: CharacterViewModel)

}
