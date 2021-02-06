package com.apolis.corutinedaggerrick.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.apolis.corutinedaggerrick.R
import com.apolis.corutinedaggerrick.databinding.ActivityMainBinding
import com.apolis.corutinedaggerrick.ui.character.CharacterFragment
import com.apolis.corutinedaggerrick.utils.MyApplication

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main)
        init()
    }
    private fun init(){

        supportFragmentManager.beginTransaction()
            .add(R.id.character_container,CharacterFragment())
            .commit()
    }
}