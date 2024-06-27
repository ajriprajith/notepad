package com.example.demo.repositories

import com.example.demo.models.NoteModel
import org.springframework.stereotype.Repository


interface NoteCustmRepository {
        fun findNotesByTitle(title: String): List<NoteModel?>
}
