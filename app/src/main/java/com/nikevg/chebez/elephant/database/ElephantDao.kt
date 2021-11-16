package com.nikevg.chebez.elephant.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ElephantDao {

    @Query("SELECT * FROM elephants")
    fun getAll(): Flow<List<Elephant>>

    //TODO 12: insert query
}
