package thanhdat.sict.project.roomdatabase

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import thanhdat.sict.project.roomdatabase.db.RoomRepository
import thanhdat.sict.project.roomdatabase.db.UserEntity
import javax.inject.Inject

class MainActivityViewModel @Inject constructor(private val repository: RoomRepository): ViewModel(){


    lateinit var userData: MutableLiveData<List<UserEntity>>

    init {
        userData = MutableLiveData()
        loadRecords()

    }


    fun getRecordsObserver(): MutableLiveData<List<UserEntity>> {
        return userData
    }

    fun loadRecords(){
        val list = repository.getRecords()

        userData.postValue(list)
    }


    fun insertRecord(userEntity: UserEntity) {
        repository.insertRecords(userEntity)
        loadRecords()
    }
}