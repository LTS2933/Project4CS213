package Project4CS213;
import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a coffee order in RU Cafe. This class contains variables
 * such as the size of the drink, add ons, and operations on the specific coffee order
 * @author Christian Osma, Liam Smith
 */
public class Coffee extends MenuItem{
    public static final double SMALL = 1.89;
    public static final double TALL = 2.29;
    public static final double GRANDE = 2.69;
    public static final double VENTI = 3.09;
    public static final double TOPPING = 0.3;

    // SMALL, TALL, GRANDE, or VENTI
    private String size;

    private List<String> addOns;

    /**
     * Default constructor that instantiates coffee order with a small
     * size and empty add ons list
     */
    public Coffee(){
        this.size = "SMALL";
        this.addOns = new ArrayList<String>();
    }

    /**
     * Overloaded constructor that takes in the size of the coffee drink and 
     * instantiates empty add ons list
     * @param size String representing the size of the drink
     */
    public Coffee(String size){
        this.size = size;
        this.addOns = new ArrayList<String>();
    }

    /**
     * Changes the size of the drink to the size specified in the parameter
     * @param size String representing the size of the drink
     */
    public void setSize(String size){
        this.size = size;
    }

    /**
     * Getter method for obtaining the size of coffee order
     * @return String representing the size of the drink
     */
    public String getSize(){
        return this.size;
    }

    /**
     * Getter method for obtaining the add ons
     * @return List of String representing every add-on
     */
    public List<String> getAddOns(){
        return this.addOns;
    }

    /**
     * This method adds the specified topping to the add ons list
     * @param topping Topping to be added to the coffee order
     */
    public void addTopping(String topping){
        this.addOns.add(topping);
    }

    /**
     * This method removes the specified topping to the add ons list
     * @param topping Topping to be removed from the coffee order
     */
    public void removeTopping(String topping){
        this.addOns.remove(topping);
    }

    /**
     * This method is able to calculate the price of the order given the size
     * of the coffee and it's add ons
     * @return double representing the price of the coffee order
     */
    public double getPrice(){
        double price = 0.0;

        switch (this.size){
            case "TALL": 
                price += TALL;
                break;
            case "GRANDE":
                price += GRANDE;
                break;
            case "VENTI":
                price += VENTI;
                break;
            default:
                price += SMALL;
        }

        price += this.addOns.size() * TOPPING;
        return price;
    }

    /**
     * This method compares whether two coffee orders are equivalent
     * @return true if the two coffee orders are equal
     */
    @Override
    public boolean equals(Object obj){
        Coffee compare = null;
        if (obj instanceof Coffee) compare = (Coffee) obj;
        else return false;

        if (compare.getSize().equals(this.size) == false) return false;
        if (compare.getAddOns().size() != this.addOns.size()) return false;

        for (int i = 0; i<this.addOns.size(); i++){
            if (this.addOns.get(i).equals(compare.getAddOns().get(i)) == false) return false;
        }
        
        return true;
    }

    @Override
    public String toString(){
        String returnString = "Coffee - " + size + " add-ons: ";
        for (String add : this.addOns){
            returnString += add + ", ";
        }
        return returnString;
    }

    public static void main (String [] args){
        Coffee test1 = new Coffee("SMALL");
        test1.addTopping("sweet cream");
        test1.addTopping("French vanilla");
        test1.addTopping("caramel");
        
        Coffee test2 = new Coffee("SMALL");
        test2.addTopping("sweet cream");
        test2.addTopping("French vanilla");
        test2.addTopping("caramel");

        System.out.println(test1.equals(test2));
    }
}
