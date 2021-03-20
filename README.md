# Dependency Inversion Principle

> In object-oriented design, the dependency inversion principle is a specific form of loosely coupling software modules. When following this principle, the conventional dependency relationships established from high-level, policy-setting modules to low-level, dependency modules are reversed, thus rendering high-level modules independent of the low-level module implementation details. The principle states:
> - High-level modules should not depend on low-level modules. Both should depend on abstractions (e.g., interfaces).
> - Abstractions should not depend on details. Details (concrete implementations) should depend on abstractions.  
> 
> [Wikipedia.org](https://en.wikipedia.org/wiki/Dependency_inversion_principle)

An ***abstraction*** is an abstract class or interface that gives a signature of the operation that it performs, but is not the concrete implementation.  When we code using abstraction it is easier to change implementation without breaking anything.

Say we want some kind of application that models relationships between people like a child to a parent.

[Relationship](src/main/java/com/clarsen/designpatterns/di/types/Relationship.java) defines what type of relationships to tie together.
```
public enum Relationship {
    PARENT, CHILD, SIBLING
}
```

[Person](src/main/java/com/clarsen/designpatterns/di/model/Person.java) is the model of we are relating together.
```
public class Person {
    private String name;
}
```

[Relationships](src/main/java/com/clarsen/designpatterns/di/model/Relationships.java) is a repository to hold all the `Person` relationships.
```
public class Relationships {

    private List<Triplet<Person, Relationship, Person>> relations = new ArrayList<>();

    public void addParentAndChild(Person parent, Person child) {
        relations.add(Triplet.with(parent, Relationship.PARENT, child));
        relations.add(Triplet.with(child, Relationship.CHILD, parent));
    }
}
```

## The Bad

Lets think of a way to find all the children for a given parent's name.  We could create a `Researcher` to search through all of the `Relationships`.

[Researcher](src/main/java/com/clarsen/designpatterns/di/bad/Researcher.java)
```
public class Researcher {
    Relationships relationships;

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
```

However, this breaks the dependency inversion principle.  Any higher level module that needs the ability to research is tied to the `Researcher`'s specific implementation.  This causes tight coupling between the low level `Researcher` module and any higher level module that depends on it.

## The Good

We can pull the implementation out of the `Researcher` into a type of browser.  This will decouple the modules depending on the specific `Researcher` implementation.

```
public interface RelationshipBrowser {
    public List<Person> researchByName(String name);
}
```

Our previous `Researcher` can implement our new browser and keep its implementation intact and still be flexible enough for other high-level modules to provide their own implementation.  Would make more sense as a `ParentResearcher` since that is what the implementation is targeting.  However; this opens us up to be able to create another researcher specific to children.

```
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
```