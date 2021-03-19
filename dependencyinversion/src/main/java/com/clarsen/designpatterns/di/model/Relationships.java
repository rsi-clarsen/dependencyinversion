package com.clarsen.designpatterns.di.model;

import java.util.ArrayList;
import java.util.List;

import com.clarsen.designpatterns.di.types.Relationship;

import org.javatuples.Triplet;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
// A lower-level module that is a concrete implementation.
// The dependency inversion principle states that this lower-level module
// should be a derived class from an abstraction that is shared between 
// the high-level and low-level modules.
public class Relationships {
    @Default
    private List<Triplet<Person, Relationship, Person>> relations = new ArrayList<>();

    public void addParentAndChild(Person parent, Person child) {
        relations.add(Triplet.with(parent, Relationship.PARENT, child));
        relations.add(Triplet.with(child, Relationship.CHILD, parent));
    }
}
