package com.example.project4.model;

/**
 * This is an abstract class to represent menu items
 * Contains common operations for each menu item such as getting
 * the price
 * @author Christian Osma, Liam Smith
 */
public abstract class MenuItem {
    /**
     * This abstract method must be implemented in sub-classes
     * to calculate the price of the current item
     * @return double representing the menu item price
     */
    public abstract double getPrice();
}
