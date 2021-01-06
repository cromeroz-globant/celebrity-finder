package com.globant.celebrityfinder;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Person {
    private final List<Person> knownPeople = new ArrayList<>();

    public Person addKnown(Person person) {
        knownPeople.add(person);
        return this;
    }
}
