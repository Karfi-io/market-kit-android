package io.horizontalsystems.marketkit.storage

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.horizontalsystems.marketkit.models.Exchange
import io.horizontalsystems.marketkit.models.VerifiedExchange

@Dao
interface ExchangeDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(items: List<Exchange>)

    @Query("SELECT * FROM Exchange")
    fun getAll(): List<Exchange>

    @Query("DELETE FROM Exchange")
    fun deleteAll()

    @Query("SELECT * FROM Exchange WHERE id IN (:ids)")
    fun getItems(ids: List<String>): List<Exchange>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertVerifiedExchanges(items: List<VerifiedExchange>)

    @Query("SELECT * FROM VerifiedExchange")
    fun getVerifiedExchanges(): List<VerifiedExchange>

    @Query("DELETE FROM VerifiedExchange")
    fun deleteVerifiedExchanges()

}
