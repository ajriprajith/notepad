package com.example.demo.services

import com.example.demo.models.NoteModel
import com.example.demo.repositories.NoteCustomRepositoryImpl
import com.example.demo.repositories.NoteRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class NoteService @Autowired constructor(private val noteRepository: NoteRepository){

    private val logger: Logger = LoggerFactory.getLogger(NoteCustomRepositoryImpl::class.java)
    fun findById(id: String): NoteModel? {
        return noteRepository.findById(id).orElse(null)
    }


    fun update(id: String, updated: NoteModel): NoteModel? {
        val existingNote = noteRepository.findById(id)
        if (existingNote.isPresent) {
            val note = existingNote.get()
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

    fun deleteById(id: String) {
        noteRepository.deleteById(id)
    }

    fun findNotesByTitle(keyword: String): List<NoteModel?> {
        logger.info("in the service layer")
        return noteRepository.findNotesByTitle(keyword)
    }

//    fun displayAll():List<NoteModel>{
//        return  noteRepository.displayAll()
//    }
}
