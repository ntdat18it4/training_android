package thanhdat.sict.project.roomdatabase.db

import javax.inject.Inject

class RoomRepository @Inject constructor(private val appDao: AppDao) {

    fun getRecords(): List<UserEntity>{
        return appDao.getAllRecordsFromDB()
    }

    fun insertRecords(userEntity: UserEntity){
        appDao.insertRecord(userEntity)
    }
}