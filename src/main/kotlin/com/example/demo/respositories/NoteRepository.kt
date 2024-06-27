package com.example.demo.repositories

import com.example.demo.models.NoteModel

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface  NoteRepository : MongoRepository<NoteModel, String>, NoteCustmRepository {
    // Additional query methods if needed

//    @Query("{}")
//    fun displayAll():List<NoteModel>
}
