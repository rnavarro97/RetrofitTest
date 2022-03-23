package com.revature.roomdbexample.datamodels

import android.content.Context
import androidx.room.*
import androidx.room.Room.databaseBuilder
import androidx.sqlite.db.SupportSQLiteOpenHelper
import com.revature.roomdbexample.DAO.CustomerData

@Database(entities = [Customer::class],
                        version = 1,
                        exportSchema = false)
abstract class AppDatabase: RoomDatabase() {

    abstract fun customerDao(): CustomerData

    companion object{

        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase{

            val tempInstance = INSTANCE

            if(tempInstance != null)
            {
                return tempInstance
            }

            synchronized(this)
            {
                var instance = Room.databaseBuilder(context.applicationContext,
                AppDatabase::class.java, "Richard").build()

                INSTANCE = instance

                return instance
            }

        }
    }

//    override fun createOpenHelper(config: DatabaseConfiguration?): SupportSQLiteOpenHelper {
//        TODO("Not yet implemented")
//    }
//
//    override fun createInvalidationTracker(): InvalidationTracker {
//        TODO("Not yet implemented")
//    }
//
//    override fun clearAllTables() {
//        TODO("Not yet implemented")
//    }

}