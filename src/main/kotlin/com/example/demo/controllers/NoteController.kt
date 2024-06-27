package com.example.demo.controllers

import com.example.demo.models.NoteModel
import com.example.demo.repositories.NoteCustomRepositoryImpl
import com.example.demo.services.NoteService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("note")
class NoteController @Autowired constructor(private val noteService:NoteService) {

    private val logger: Logger = LoggerFactory.getLogger(NoteCustomRepositoryImpl::class.java)
    @GetMapping("/search/{id}")
    fun findById(@PathVariable id: String): ResponseEntity<NoteModel?> {
        val note = noteService.findById(id)
        return if (note != null) {
            ResponseEntity.ok(note)
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @GetMapping("/search/title")
    fun findByTitle(@RequestParam title: String): ResponseEntity<List<NoteModel?>> {
        logger.info("into the search title")
        val notes = noteService.findNotesByTitle(title)
        return if (notes.isNotEmpty()) {
            ResponseEntity.ok(notes)
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @PostMapping("/create")
    fun createNote(@RequestBody noteModel: NoteModel): ResponseEntity<NoteModel> {
        val createdNote = noteService.create(noteModel)
        return ResponseEntity.ok(createdNote)
    }

    @PutMapping("/update/{id}")
    fun updateNote(@PathVariable id: String, @RequestBody updatedNote: NoteModel): ResponseEntity<NoteModel?> {
        val updated = noteService.update(id, updatedNote)
        return if (updated != null) {
            ResponseEntity.ok(updated)
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @DeleteMapping("/delete/{id}")
    fun deleteById(@PathVariable id: String): ResponseEntity<Void> {
        noteService.deleteById(id)
        return ResponseEntity.noContent().build()
    }

//    @GetMapping("/all")
//    fun displayAll(): ResponseEntity<List<NoteModel>> {
//        val allData = noteService.displayAll()
//        return if (allData.isNotEmpty()) {
//            ResponseEntity.ok(allData)
//        } else {
//            ResponseEntity.noContent().build()
//        }
//    }
}
