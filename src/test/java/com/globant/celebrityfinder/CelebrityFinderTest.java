package com.globant.celebrityfinder;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

class CelebrityFinderTest {

    private CelebrityFinder celebrityFinder;

    @BeforeEach
    void setUp() {
        celebrityFinder = new CelebrityFinder();
    }

    @Test
    void findCelebrityInEmptyGroupReturnsEmpty() {
        List<Person> group = List.of();

        Optional<Person> result = celebrityFinder.findIn(group);

        assertThat(result).isEmpty();
    }

    @Test
    void findCelebrityInOnePersonGroupReturnsEmpty() {
        Person person = new Person();
        List<Person> group = List.of(person);

        Optional<Person> result = celebrityFinder.findIn(group);

        assertThat(result).isNotEmpty();
    }

    @Test
    void findCelebrityInTwoPeopleGroupReturnsCelebrityWhenExists() {
        Person celebrity = new Person();
        Person person = new Person().addKnown(celebrity);

        List<Person> group = List.of(celebrity, person);

        Optional<Person> result = celebrityFinder.findIn(group);

        assertThat(result).contains(celebrity);
    }

    @Test
    void findCelebrityInTwoPeopleGroupReturnsEmptyWhenTheyKnowEachOther() {
        Person person1 = new Person();
        Person person2 = new Person().addKnown(person1);
        person1.addKnown(person2);

        List<Person> group = List.of(person1, person2);

        Optional<Person> result = celebrityFinder.findIn(group);

        assertThat(result).isEmpty();
    }

    @Test
    void findCelebrityInTwoPeopleGroupReturnsEmptyWhenTheyNotKnowEachOther() {
        Person person1 = new Person();
        Person person2 = new Person();

        List<Person> group = List.of(person1, person2);

        Optional<Person> result = celebrityFinder.findIn(group);

        assertThat(result).isEmpty();
    }

    @Test
    void findCelebrityInFourPeopleGroupReturnsCelebrityWhenExists() {
        Person celebrity = new Person();
        Person person1 = new Person().addKnown(celebrity);
        Person person2 = new Person().addKnown(celebrity).addKnown(person1);
        Person person3 = new Person().addKnown(celebrity).addKnown(person2);

        List<Person> group = List.of(celebrity, person1, person2, person3);

        Optional<Person> result = celebrityFinder.findIn(group);

        assertThat(result).contains(celebrity);
    }

    @Test
    void findCelebrityInFourPeopleGroupReturnsEmptyWhenNoCelebrityExists() {
        Person almostCelebrity = new Person();
        Person person1 = new Person().addKnown(almostCelebrity);
        Person person2 = new Person().addKnown(person1);
        Person person3 = new Person().addKnown(almostCelebrity).addKnown(person2);

        List<Person> group = List.of(almostCelebrity, person1, person2, person3);

        Optional<Person> result = celebrityFinder.findIn(group);

        assertThat(result).isEmpty();
    }
}