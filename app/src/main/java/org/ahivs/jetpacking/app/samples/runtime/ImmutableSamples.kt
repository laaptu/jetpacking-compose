package org.ahivs.jetpacking.app.samples.runtime

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable


fun simpleImmutableClass() {
    @Immutable
    data class Person(val name: String, val phoneNumber: String)

    @Composable
    fun PersonView(person: Person) {
        Column {
            Row {
                Text("Name: ")
                Text(person.name)
            }
            Row {
                Text("Phone: ")
                Text(person.phoneNumber)
            }
        }
    }

    @Composable
    fun PeopleView(people: List<Person>) {
        Column {
            for (person in people) {
                PersonView(person)
            }
        }
    }
}