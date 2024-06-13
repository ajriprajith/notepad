package com.example.demo.respositories

import com.example.demo.models.NoteModel
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.*
import org.springframework.data.repository.RepositoryDefinition
import org.springframework.stereotype.Repository

interface NoteRepository : MongoRepository<NoteModel, String> {
    @Aggregation(pipeline= ["{ \$match: { title: ?0 } }"])
    fun findNotesByTitle(title: String): List<NoteModel>

    @Query("{}")
    fun displayAll():List<NoteModel>
}