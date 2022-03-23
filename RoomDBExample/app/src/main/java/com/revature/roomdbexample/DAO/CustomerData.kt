package com.revature.roomdbexample.DAO

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.revature.roomdbexample.datamodels.Customer

@Dao
interface CustomerData {
    @Query("SELECT * FROM customer")
    fun fetchAllCustomer(): LiveData<List<Customer>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCustomer(customer: Customer)

    @Query("DELETE FROM customer WHERE id=:id")
    suspend fun deleteCustomerById(id: Int)
}