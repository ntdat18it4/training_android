package thanhdat.sict.project.roomdatabase.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [UserEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase(){

    abstract fun getDAO(): AppDao

    companion object {
        private var db_instance: AppDatabase? = null

        fun getAppDB(context: Context): AppDatabase {

            if(db_instance == null) {
                db_instance = Room.databaseBuilder<AppDatabase>(
                    context.applicationContext, AppDatabase::class.java, "app_db"
                )
                    .allowMainThreadQueries()
                    .build()
            }

            return db_instance!!
        }
    }
}