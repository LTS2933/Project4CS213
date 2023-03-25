package Project4CS213;
import java.util.List;
import java.util.ArrayList;

/**
 * This class represents an order that has an order number and a list of menu itmes.
 * Contains methods to alter order
 * @author Christian Osma, Liam Smith
 */
public class Order {
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

        price *= SALES_TAX;
        return price;
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
