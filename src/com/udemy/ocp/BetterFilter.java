package com.udemy.ocp;

import com.udemy.ocp.filter.Filter;
import com.udemy.ocp.filter.Specification;

import java.util.List;
import java.util.stream.Stream;

public class BetterFilter implements Filter<Product> {

    @Override
    public Stream<Product> filter(List<Product> items, Specification<Product> specification) {
        return items.stream().filter(specification::isSatisfied);
    }
}
