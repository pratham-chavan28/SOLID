package com.udemy.liskov;

// Liskov singularity principle
// - All base classes can be defined by their child classes
// and should give same response
public class LSPDemo {

    static void useIt(Rectangle r)
    {
        int width = r.getWidth();
        r.setHeight(10); // sets width also to 10 for square object
        System.out.println("Expected area of " + (width*10) + ", got " + r.getArea());
    }

    public static void main(String[] args) {
        Rectangle rc = new Rectangle(2, 3);
        useIt(rc);

        // violated LSP as Rectangle's width is also changed to 10 (at line 11)
        // as a Square object is created below.
        Rectangle sq = new Square();
        sq.setHeight(5);
        useIt(sq);
        System.out.println();

        // resolved using factory method
        // factory will return a Rectangle always
        // so the width and height are not codependent
        Rectangle rc1 = RectangleFactory.newRectangle(2, 3);
        System.out.println("Using factory method");
        useIt(rc1);
        Rectangle sq1 = RectangleFactory.newSquare(5);
        useIt(sq1);

    }
}
