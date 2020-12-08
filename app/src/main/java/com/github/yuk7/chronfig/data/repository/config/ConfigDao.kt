package com.github.yuk7.chronfig.data.repository.config

import androidx.room.*

@Dao
interface ConfigDao {
    @Query("SELECT * FROM config")
    fun getAll(): List<Config>

    @Query("SELECT * FROM config WHERE id = :id LIMIT 1")
    fun findById(id: Int): Config?

    @Insert
    fun insert(config: Config)

    @Update
    fun update(config: Config)

    @Delete
    fun delete(config: Config)

    @Query("DELETE FROM config")
    fun deleteAll()
}