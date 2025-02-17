package com.example.slotbook.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.slotbook.model.TechTrack

@Dao
interface TechTrackDao {

    @Query("SELECT * FROM tech_tracks")
    suspend fun getTracks(): List<TechTrack>

    suspend fun getHardcodedTracks(): List<TechTrack> {
        return listOf(
            TechTrack(1, "JAVA"),
            TechTrack(2, "iOS Development"),
            TechTrack(3, "J2EE"),
            TechTrack(4, "TESTING")
        )
    }
}

