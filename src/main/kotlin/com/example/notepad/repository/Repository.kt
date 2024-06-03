package com.example.notepad.repository

import com.example.notepad.model.Note;
import org.springframework.data.mongodb.repository.MongoRepository;

interface NoteRepository : MongoRepository<Note, Int>


containing any keyword input( i want the result for anyu note )
        using custom  query/aggregation
