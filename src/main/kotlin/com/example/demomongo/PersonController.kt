package com.example.demomongo

import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/persons")
class PersonController(
    private val personRepository: PersonRepository
) {

    @GetMapping("/{id}")
    fun find(@PathVariable id: String): Person {
        return personRepository.findById(id).get()
    }

    @PostMapping
    fun create(@RequestBody request: Person): Person {
        return personRepository.insert(request)
    }

    @PutMapping("/{id}")
    fun update(
        @PathVariable id: String,
        @RequestBody request: Person
    ): Person {
        val person = personRepository.findById(id).get()

        person.name = request.name
        person.birthDate = request.birthDate
        person.genre = request.genre
        person.contacts = request.contacts

        return personRepository.save(person)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: String) {
        personRepository.deleteById(id)
    }
}