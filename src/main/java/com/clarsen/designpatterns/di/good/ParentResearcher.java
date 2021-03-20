package com.clarsen.designpatterns.di.good;

import java.util.List;
import java.util.stream.Collectors;

import com.clarsen.designpatterns.di.model.Person;
import com.clarsen.designpatterns.di.model.Relationships;
import com.clarsen.designpatterns.di.types.Relationship;

import org.javatuples.Triplet;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class ParentResearcher implements RelationshipBrowser {
    private Relationships relationships;

    @Override
    public List<Person> researchByName(String name) {
        return relationships.getRelations().stream()
            .filter(rl -> this.relationshipIsAParent(rl.getValue1()))
            .filter(rl -> this.nameIsPersonsName(rl.getValue0(), name))
            .map(Triplet::getValue2)
            .collect(Collectors.toList());
    }

    private boolean relationshipIsAParent(Relationship relationship) {
        return relationship.equals(Relationship.PARENT);
    }
    
    private boolean nameIsPersonsName(Person person, String name) {
        return person.getName().equals(name);
    }
    
}
