package com.xenon.simplyrecipes.utils;

import com.vaadin.flow.data.binder.Result;
import com.vaadin.flow.data.binder.ValueContext;
import com.vaadin.flow.data.converter.Converter;
import com.xenon.simplyrecipes.entities.Category;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetToListConverter implements Converter<Set<Category>, List<Category>> {
    @Override
    public Result<List<Category>> convertToModel(Set<Category> setOfCategories, ValueContext valueContext) {
        List<Category> list = new ArrayList<>(setOfCategories);
        return Result.ok(list);
    }

    @Override
    public Set<Category> convertToPresentation(List<Category> listOfCatogories, ValueContext valueContext) {
        return new HashSet<>(listOfCatogories);
    }
}