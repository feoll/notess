package com.codingwithme.notesapp.dao

import androidx.room.*
import com.codingwithme.notesapp.entities.Notes

@Dao
interface NoteDao {

    //получаем все заметки
    @Query("SELECT * FROM notes ORDER BY id DESC")
    suspend fun getAllNotes() : List<Notes>

    //плучаем заметки по айди
    @Query("SELECT * FROM notes WHERE id =:id")
    suspend fun getSpecificNote(id:Int) : Notes

    //вставляем заметки
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNotes(note:Notes)

    //удаляем заметку
    @Delete
    suspend fun deleteNote(note:Notes)

    //удаляем заметку по айди
    @Query("DELETE FROM notes WHERE id =:id")
    suspend fun deleteSpecificNote(id:Int)

    //обновляем заметку
    @Update
    suspend fun updateNote(note:Notes)
}