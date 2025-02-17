package com.example.slotbook.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.slotbook.model.Slot

@Dao
interface SlotDao {
    @Query("SELECT * FROM slots WHERE trackId = :trackId AND isBooked = 0")
    suspend fun getAvailableSlots(trackId: Int): List<Slot>

    suspend fun getHardcodedSlots(trackId: Int): List<Slot> {
        return when (trackId) {
            1 -> listOf(
                Slot(1, 1, "2025-02-16", "11:00 AM", false),
                Slot(2, 1, "2025-02-16", "1:00 PM", false),
                Slot(3, 1, "2025-02-17", "02:00 PM", false),
                Slot(4, 1, "2025-02-17", "03:00 PM", false)
            )
            2 -> listOf(
                Slot(5, 2, "2025-02-17", "02:00 PM", false),
                Slot(6, 2, "2025-02-17", "03:00 PM", false)
            )
            3 -> listOf(
                Slot(7, 3, "2025-02-17", "11:00 AM", false),
                Slot(8, 3, "2025-02-17", "03:00 PM", false),
                Slot(9, 3, "2025-02-17", "04:00 PM", false),
                Slot(10, 3, "2025-02-17", "03:00 PM", false)
            )
            4 -> listOf(
                Slot(11, 4, "2025-02-17", "02:00 PM", false),
                Slot(12, 4, "2025-02-17", "03:00 PM", false)
            )

            else -> emptyList()
        }
    }
}

