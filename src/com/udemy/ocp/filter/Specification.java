package com.udemy.ocp.filter;

// This interface is open for implementation but closed for modification
public interface Specification <T> {
    boolean isSatisfied(T item);
}

