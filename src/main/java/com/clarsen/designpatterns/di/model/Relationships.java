package com.clarsen.designpatterns.di.model;

import java.util.ArrayList;
import java.util.List;

import com.clarsen.designpatterns.di.types.Relationship;

import org.javatuples.Triplet;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Relationships {

    private List<Triplet<Person, Relationship, Person>> relations = new ArrayList<>();

    public void addParentAndChild(Person parent, Person child) {
        relations.add(Triplet.with(parent, Relationship.PARENT, child));
        relations.add(Triplet.with(child, Relationship.CHILD, parent));
    }
}
