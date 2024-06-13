package com.example.demo.controllers

import com.example.demo.models.NoteModel
import com.example.demo.respositories.NoteRepository
import com.example.demo.services.NoteService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.*
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities.Private

@RestController
@RequestMapping("note")
class NoteController @Autowired constructor(private val noteService:NoteService, private val noteRepository: NoteRepository) {

    @GetMapping("/search/{id}")
    fun getNoteById(@PathVariable id: String): ResponseEntity<NoteModel?> {
        val note = noteService.findById(id)
        return if (note != null) {
            ResponseEntity.ok(note)
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @GetMapping("/search/title")
    fun findNotesByTitle(@RequestParam title: String): ResponseEntity<List<NoteModel>> {
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
    fun deleteNoteById(@PathVariable id: String): ResponseEntity<Void> {
        noteService.deletebyId(id)
        return ResponseEntity.noContent().build()
    }

    @GetMapping("/all")
    fun displayAll():ResponseEntity<List<NoteModel>>{
        val all_data = noteRepository.displayAll()
        return if(all_data.isNotEmpty()){
            ResponseEntity.ok(all_data)
        }
        else{
            ResponseEntity.noContent().build()
        }
    }
}