package com.apolis.corutinedaggerrick.data.database.instance


import androidx.room.Room
import com.apolis.corutinedaggerrick.utils.MyApplication

class MyDBInstance {
    companion object{
        const val DBName="Rick_cache"
        var myDatabase: MyDatabase?=null
        fun getInstance(): MyDatabase {
            if (myDatabase==null)
            {
                synchronized(MyDBInstance::class){
                    if(myDatabase==null)
                    {
                        myDatabase= Room.databaseBuilder(MyApplication.getAppContext(), MyDatabase::class.java, DBName)
                            .allowMainThreadQueries()
                            .fallbackToDestructiveMigration()
                            .build()
                    }
                }

            }



            return myDatabase!!
        }
    }
}