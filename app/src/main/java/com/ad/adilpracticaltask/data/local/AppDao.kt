package com.ad.adilpracticaltask.data.local

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE
import com.ad.adilpracticaltask.data.local.model.DataModel


@Dao
interface AppDao {
    @Insert(onConflict = REPLACE)
    suspend fun insertData(dataModel: DataModel)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateAllData(list: ArrayList<DataModel?>)

    @Update
    fun updateSingleData(model: DataModel?)

    @Query("SELECT * from Tasks")
    fun getData(): LiveData<DataModel?>
}
