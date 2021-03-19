package com.clarsen.designpatterns.di;

import com.clarsen.designpatterns.di.model.Person;
import com.clarsen.designpatterns.di.model.Relationships;
import com.clarsen.designpatterns.di.model.Research;

public class Application {
    public static void main(String[] args) {
        Person child1 = new Person("Nate");
        Person child2 = new Person("Zack");
        Person child3 = new Person("Kay");
        Person parent = new Person("Chris");
        
        Person otherChild1 = new Person("Carla");
        Person otherChild2 = new Person("Steven");
        Person otherChild3 = new Person("Kayla");
        Person otherParent = new Person("Mercedes");

        Relationships rl = new Relationships();
        
        rl.addParentAndChild(parent, child1);
        rl.addParentAndChild(parent, child2);
        rl.addParentAndChild(parent, child3);

        rl.addParentAndChild(otherParent, otherChild1);
        rl.addParentAndChild(otherParent, otherChild2);
        rl.addParentAndChild(otherParent, otherChild3);

        new Research(rl);
    }
}
