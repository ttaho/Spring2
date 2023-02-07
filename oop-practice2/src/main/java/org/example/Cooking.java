package org.example;

public class Cooking {
    public Cook makecook(MenuItem menuItem) {

        Cook cook = new Cook(menuItem);
        return cook;
    }
}
