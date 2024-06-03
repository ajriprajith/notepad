package com.example.notepad.service

import com.example.notepad.model.Note
import com.example.notepad.repository.NoteRepository
import org.springframework.stereotype.Service

@Service
class Service(private val noteRepository: NoteRepository) {

    fun findById(id: Int): Note? {
        return noteRepository.findById(id).orElse(null)
    }

    fun save(note: Note): Note {
        return noteRepository.save(note)
    }

    fun update(id: Int, updatedNote: Note): Note? {
        val existingNote = noteRepository.findById(id)
        if (existingNote.isPresent) {
            val note = existingNote.get()
            note.noteText = updatedNote.noteText
            return noteRepository.save(note)
        }
        return null
    }

    fun delete(id: Int) {
        noteRepository.deleteById(id)
    }
}
