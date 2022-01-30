package com.udemy.ocp;

import java.util.List;
import java.util.stream.Stream;

public class ProductFilter {

    public Stream<Product> filterByColor(List<Product> products,
                                         Color color) {
        return products.stream().filter(p -> p.color == color);
    }

    public Stream<Product> filterBySize(List<Product> products,
                                        Size size) {
        return products.stream().filter(p -> p.size == size);
    }

    // as requirement of new filter comes, we have to modify this class
    // e.g. for three specifications, there can be at most seven methods
    public Stream<Product> filterByColorAndSize(List<Product> products,
                                                Size size,
                                                Color color) {
        return products.stream().filter(p -> p.size == size && p.color == color);
    }
 }
