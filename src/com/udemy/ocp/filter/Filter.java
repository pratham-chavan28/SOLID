package com.udemy.ocp.filter;

import java.util.List;
import java.util.stream.Stream;
// This interface is open for implementation but closed for modification
public interface Filter<T> {
    Stream<T> filter(List<T> items, Specification<T> specification);
}
