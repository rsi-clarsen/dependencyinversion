package com.clarsen.designpatterns.di.good;

import java.util.List;
import java.util.stream.Collectors;

import com.clarsen.designpatterns.di.model.Person;
import com.clarsen.designpatterns.di.model.Relationships;
import com.clarsen.designpatterns.di.types.Relationship;

import org.javatuples.Triplet;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class ChildResearcher implements RelationshipBrowser {
    private Relationships relationships;

    @Override
    public List<Person> researchByName(String name) {
        return relationships.getRelations().stream()
            .filter(rl -> this.relationshipIsAChild(rl.getValue1()))
            .filter(rl -> this.nameIsPersonsName(rl.getValue0(), name))
            .map(Triplet::getValue2)
            .collect(Collectors.toList());
    }

    private boolean relationshipIsAChild(Relationship relationship) {
        return relationship.equals(Relationship.CHILD);
    }
    
    private boolean nameIsPersonsName(Person person, String name) {
        return person.getName().equals(name);
    }
    
}
