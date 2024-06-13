package com.example.demo.services

import com.example.demo.models.NoteModel
import com.example.demo.respositories.NoteRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class NoteService @Autowired constructor(private val noteRepository: NoteRepository){

    fun findNotesByTitle(title: String): List<NoteModel> {
        return noteRepository.findNotesByTitle(title)
    }

    fun findById(id: String): NoteModel? {
        return noteRepository.findById(id).orElse(null)
    }

    fun save(note: NoteModel): NoteModel {
        return noteRepository.save(note)
    }

    fun update(id: String, updated: NoteModel): NoteModel? {
        val existingNote = noteRepository.findById(id)
        if (existingNote.isPresent) {
            val note = existingNote.get()
            // Check if the ID matches, although normally IDs are immutable once set
            if (note.id == updated.id) {
                note.title = updated.title
                note.description = updated.description
                return noteRepository.save(note)
            }
        }
        return null
    }

     fun create(note: NoteModel): NoteModel {
        return noteRepository.save(note)
    }


    fun deletebyId(id: String) {
        noteRepository.deleteById(id)
    }

}