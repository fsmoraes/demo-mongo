package com.example.demomongo

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import java.time.LocalDate

class Person(
    @Id
    val id: String = ObjectId().toHexString(),
    var name: String,
    var birthDate: LocalDate,
    var genre: Genre,
    var contacts: List<Contact>? = listOf()
)

enum class Genre { MALE, FEMALE }
enum class ContactType { HOME_PHONE, WORK_PHONE, EMAIL }

class Contact(val type: ContactType, val code: String)
