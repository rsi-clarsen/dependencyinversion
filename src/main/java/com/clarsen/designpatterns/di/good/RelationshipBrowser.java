package com.clarsen.designpatterns.di.good;

import java.util.List;

import com.clarsen.designpatterns.di.model.Person;

public interface RelationshipBrowser {
    public List<Person> researchByName(String name);
}
