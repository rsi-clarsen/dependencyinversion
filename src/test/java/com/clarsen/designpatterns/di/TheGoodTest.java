package com.clarsen.designpatterns.di;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import com.clarsen.designpatterns.di.good.ChildResearcher;
import com.clarsen.designpatterns.di.good.ParentResearcher;
import com.clarsen.designpatterns.di.good.RelationshipBrowser;
import com.clarsen.designpatterns.di.model.Person;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class TheGoodTest {
    
    private static RelationshipBrowser parentResearcher;
    private static RelationshipBrowser childResearcher;

    @BeforeAll
    public static void setup() {
        parentResearcher = new ParentResearcher(TestDataGenerator.TEST_DATA);

        childResearcher = new ChildResearcher(TestDataGenerator.TEST_DATA);
    }

    @Test
    public void testParent() {
        List<Person> children = parentResearcher.researchByName("Mercedes");

        assertTrue(children.size() == 4);
    }

    @Test
    public void testChild() {
        List<Person> parents = childResearcher.researchByName("Kay");

        assertTrue(parents.size() == 2);
    }
}
