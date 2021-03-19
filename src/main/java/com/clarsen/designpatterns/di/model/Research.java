package com.clarsen.designpatterns.di.model;

import com.clarsen.designpatterns.di.types.Relationship;

// Research is a high-level module that is dependent on the Relationships lower level module
// this breaks the dependency inversion principle
public class Research {

    public Research(Relationships relationships) {
        relationships.getRelations().stream()
            .filter(r -> r.getValue0().getName().equals("Chris") && r.getValue1().equals(Relationship.PARENT))
            .forEach(ch -> System.out.println("Chris has a child named " + ch.getValue2().getName()));
    }
    
}
