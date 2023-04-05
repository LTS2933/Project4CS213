package com.example.project4.model;

import java.text.DecimalFormat;
import java.util.List;
import java.util.ArrayList;

/**
 * This class represents an order that has an order number and a list of menu itmes.
 * Contains methods to alter order
 * @author Christian Osma, Liam Smith
 */
public class Order implements Comparable<Order>{
    public static final double SALES_TAX = 0.0625;

    private int orderNumber;
    private List<MenuItem> items;

    /**
     * Constructor that takes in an order number and sets the menu items
     * to an empty list
     * @param orderNumber integer representing the order number
     */
    public Order(int orderNumber){
        this.orderNumber = orderNumber;
        this.items = new ArrayList<MenuItem>();
    }

    /**
     * Constructors that takes in the order number and all menu items of that order
     * @param orderNumber integer representing the order number
     * @param items list of menu items of the order
     */
    public Order(int orderNumber, List<MenuItem> items){
        this.orderNumber = orderNumber;
        this.items = items;
    }

    /**
     * Constructors that takes in all menu items of that order
     * @param items list of menu items of the order
     */
    public Order(List<MenuItem> items){
        this.orderNumber = 0;
        this.items = items;
    }

    /**
     * Copy constructor to copy the inputted order to a new object
     * @param order Order to be copied
     */
    public Order (Order order){
        this.orderNumber = order.getOrderNumber();
        this.items = new ArrayList<MenuItem>();
        for (MenuItem item : order.getMenuItems()){
            if (item instanceof Coffee) this.items.add(new Coffee((Coffee)item));
            else if (item instanceof Donut) this.items.add(new Donut((Donut)item));
        }
    }

    /**
     * Setter method to change the order number to the one specified in the parameter
     * @param orderNumber order number to be changed to
     */
    public void setOrderNumber(int orderNumber){
        this.orderNumber = orderNumber;
    }

    /**
     * Getter method for obtaining the order number
     * @return integer representing the order number
     */
    public int getOrderNumber(){
        return this.orderNumber;
    }

    /**
     * Getter method for obtaining the list of menu items in the order
     * @return List containing the menu items
     */
    public List<MenuItem> getMenuItems(){
        return this.items;
    }

    /**
     * Setter method for changing the menu items of the order to the inputted value
     * @param items New list of menu items
     */
    public void setMenuItems(List<MenuItem> items){
        this.items = items;
    }

    /**
     * This method takes in a menu item and adds it to the list of
     * menu items for the order
     * @param item MenuItem to be added to the menu items
     */
    public void addMenuItem(MenuItem item){
        this.items.add(item);
    }

    /**
     * This method takes in a manu items and removes it from the list
     * of menu items for that order
     * @param item MenuItem to be removed from the menu items
     */
    public void removeMenuItem(MenuItem item){
        this.items.remove(item);
    }

    /**
     * This method adds all the prices of the menu items to get the total
     * price with taxes included
     * @return double representing the total price for the order
     */
    public double getPrice(){
        double price = 0.0;

        for (MenuItem item : this.items){
            price += item.getPrice();
        }

        return price;
    }

    /**
     * This method checks whether two orders are the same
     * given their order number
     * @param obj Order to be compared to
     * @return true if the two orders are the same
     */
    @Override
    public boolean equals(Object obj){
        Order compare = null;
        if (obj instanceof Order) compare = (Order) obj;
        else return false;

        return compare.getOrderNumber() == this.orderNumber;
    }

    /**
     * This method compares two orders and returns 0 if the orders are the
     * same, 1 if the current order has a higher order number, and -1
     * otherwise
     * @param obj The order to be compared to
     * @return integer representing the comparison between the two orders
     */
    @Override
    public int compareTo(Order obj){
        if (obj.getOrderNumber() == this.orderNumber) return 0;
        if (this.orderNumber > obj.getOrderNumber()) return 1;
        return -1;
    }

    /**
     * Method for getting the string representation of the current order
     * @return String representing the order
     */
    @Override
    public String toString(){
        String returnString = "Order: " + this.orderNumber + "\n";
        DecimalFormat df = new DecimalFormat("#,##0.00");
        returnString += "Price: $" + df.format(this.getPrice()) + "\n";
        for (MenuItem i: this.items){
            returnString += i.toString();
        }
        return returnString;
    }

    public static void main (String [] args){
        Order order = new Order(1);
        order.addMenuItem(new Donut("YEAST", "CHOCOLATE"));
        order.addMenuItem(new Coffee("SMALL"));

        List<MenuItem> orderItems = order.getMenuItems();
        for (MenuItem i: orderItems){
            System.out.println(i.toString());
        }

        order.removeMenuItem(new Coffee("SMALL"));
        System.out.println();
        orderItems = order.getMenuItems();
        for (MenuItem i: orderItems){
            System.out.println(i.toString());
        }
    }

}
