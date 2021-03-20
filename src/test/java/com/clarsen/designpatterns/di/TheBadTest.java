package com.clarsen.designpatterns.di;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import com.clarsen.designpatterns.di.bad.Researcher;
import com.clarsen.designpatterns.di.model.Person;
import com.clarsen.designpatterns.di.model.Relationships;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class TheBadTest {

    private static Researcher researcher;

    @BeforeAll
    public static void setup() {
        researcher = new Researcher(TestDataGenerator.TEST_DATA);
    }

    @Test
    public void testee() {
        List<Person> children = researcher.researchByName("Chris");

        assertTrue(children.size() == 3);
    }
}

