package com.clarsen.designpatterns.di;

import com.clarsen.designpatterns.di.model.Person;
import com.clarsen.designpatterns.di.model.Relationships;

import lombok.Getter;

public class TestDataGenerator {

    public final static Relationships TEST_DATA;

    static {
        Person child1 = new Person("Nate");
        Person child2 = new Person("Zach");
        Person child3 = new Person("Kay");
        Person parent = new Person("Chris");
        
        Person otherChild1 = new Person("Carla");
        Person otherChild2 = new Person("Steven");
        Person otherChild3 = new Person("Kay");
        Person otherChild4 = new Person("Mitch");
        Person otherParent = new Person("Mercedes");

        TEST_DATA = new Relationships();
        
        TEST_DATA.addParentAndChild(parent, child1);
        TEST_DATA.addParentAndChild(parent, child2);
        TEST_DATA.addParentAndChild(parent, child3);

        TEST_DATA.addParentAndChild(otherParent, otherChild1);
        TEST_DATA.addParentAndChild(otherParent, otherChild2);
        TEST_DATA.addParentAndChild(otherParent, otherChild3);
        TEST_DATA.addParentAndChild(otherParent, otherChild4);
    }
}
