package com.example.notepad.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document


@Document(collection="notes")
data class Note(
    @Id val id: Int,
    var noteText: String?

)

