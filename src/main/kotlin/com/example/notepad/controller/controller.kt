package com.example.notepad.controller

import com.example.notepad.model.Note
import com.example.notepad.service.Service
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/notes")
class Controller(private val service: Service) {

    @GetMapping("/{id}")
    fun getNoteById(@PathVariable id: Int): Note? {
        return service.findById(id)
    }

    @PostMapping("/notes")
    fun createNote(@RequestBody note: Note): Note {
        return service.save(note)
    }

    @DeleteMapping("/{id}")
    fun deleteNote(@PathVariable id: Int) {
        service.delete(id)
    }

    @PutMapping("/{id}")
    fun updateNote(@PathVariable id: Int, @RequestBody note: Note): Note? {
        return service.update(id, note)
    }

    @GetMapping("/heartbeat")
    fun heartbeat(): String {
        return "I'm alive!"
    }



}
