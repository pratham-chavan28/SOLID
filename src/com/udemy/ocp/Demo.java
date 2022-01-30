package com.udemy.ocp;

import com.udemy.ocp.filter.AndSpecification;
import com.udemy.ocp.filter.ColorSpecification;
import com.udemy.ocp.filter.SizeSpecification;

import java.util.List;

public class Demo {
    public static void main(String[] args) {
        Product apple = new Product("Apple", Color.GREEN, Size.SMALL);
        Product tree = new Product("Tree", Color.GREEN, Size.LARGE);
        Product house = new Product("House", Color.BLUE, Size.LARGE);

        List<Product> products = List.of(apple, tree, house);

        ProductFilter pf = new ProductFilter();
        System.out.println("Green products (old)");
        pf.filterByColor(products, Color.GREEN).forEach(p -> System.out.println(
                " - " + p.name + " is GREEN."
        ));

        // as requirement of new filter came, we had to modify ProductFilter class
        // by adding the filterBySize() method. Violating the OCP principle
        pf.filterBySize(products, Size.LARGE).forEach(p -> System.out.println(
                " - " + p.name + " is Large."
        ));

        // OCP compliant code
        BetterFilter bf = new BetterFilter();
        System.out.println("Green products (new)");
        bf.filter(products, new ColorSpecification(Color.GREEN))
                .forEach(p -> System.out.println(
                        " - " + p.name + " is GREEN."
                ));

        System.out.println();
        System.out.println("Large products (new)");
        bf.filter(products, new SizeSpecification(Size.LARGE))
                .forEach(p -> System.out.println(
                        " - " + p.name + " is Large."
                ));

        System.out.println();
        System.out.println("Large and Blue products");

        // with increasing requirement of filters, you don't have to
        // modify the BetterFilter class, instead we can implement Specification interface
        // in a new class i.e. Open for implementation and close for modification.
        SizeSpecification s = new SizeSpecification(Size.LARGE);
        ColorSpecification c = new ColorSpecification(Color.BLUE);
        bf.filter(products, new AndSpecification<>(s, c))
                .forEach(p -> System.out.println(
                        " - " + p.name + " is Blue and Large."
                ));

    }
}
