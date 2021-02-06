package com.apolis.corutinedaggerrick.ui.character

import androidx.lifecycle.LiveData
import com.apolis.corutinedaggerrick.data.models.Character

interface CharacterGetListener {
    fun onGet(mList:LiveData<ArrayList<Character>>)
}