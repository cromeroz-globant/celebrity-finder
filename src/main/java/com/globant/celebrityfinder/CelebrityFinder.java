package com.globant.celebrityfinder;

import java.util.List;
import java.util.Optional;

public class CelebrityFinder {

    public Optional<Person> findIn(List<Person> group) {
        return group.stream().filter(person -> isCelebrityInGroup(person, group)).findFirst();
    }

    private boolean isCelebrityInGroup(Person celebrityCandidate, List<Person> group) {
        return celebrityCandidate.getKnownPeople().isEmpty() && group.stream()
                .filter(p -> !p.equals(celebrityCandidate))
                .allMatch(person -> person.getKnownPeople().contains(celebrityCandidate));
    }
}
