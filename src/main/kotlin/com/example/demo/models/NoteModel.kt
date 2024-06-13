package com.example.demo.models

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.Instant


@Document(collection = "Notepad")
data class NoteModel(
    @Id val id:String?,
    var title:String?,
    var description: String?,
    val created_at: Instant? = Instant.now()
)