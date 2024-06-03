package com.example.notepad

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories

@SpringBootApplication
@EnableMongoRepositories(basePackages = ["com.example.notepad.repository"])
class NotepadApplication

fun main(args: Array<String>) {
	runApplication<NotepadApplication>(*args)
}
