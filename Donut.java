package Project4CS213;

/**
 * This class represents a donut order and contains methods such as getting
 * the price of the order and getting the type of the order
 * @author Christian Osma, Liam Smith
 */
public class Donut extends MenuItem {
    public static final double YEAST = 1.59;
    public static final double CAKE = 1.79;
    public static final double HOLE = 0.39;

    // CAKE, YEAST, or HOLE
    private String type;
    private String flavor;

    /**
     * Default constructor that sets the type of order to a YEAST donut
     */
    public Donut(){
        this.type = "YEAST";
        this.flavor = "CHOCOLATE";
    }

    /**
     * Overloaded constructor that sets the type of donut to the type specified
     * @param type String representing the type of donut
     */
    public Donut(String type){
        this.type = type;
        this.flavor = "CHOCOLATE";
    }

    /**
     * Overloaded constructor that sets the Donut object to the type and flavor specified
     * in the input
     * @param type String representing the type of donut
     * @param flavor String representing the flavor of the donut
     */
    public Donut(String type, String flavor){
        this.type = type;
        this.flavor = flavor;
    }

    /**
     * Setter method that changes the type of donut to the type specified in the parameter
     * @param type String representing the new type of donut
     */
    public void setType(String type){
        this.type = type;
    }

    /**
     * Getter method for obtaining the type of donut order
     * @return String representing the type of donut order
     */
    public String getType(){
        return this.type;
    }

    /**
     * Setter method for setting the flavor of the donnut
     * @param flavor String representing the flavor of donut
     */
    public void setFlavor(String flavor){
        this.flavor = flavor;
    }

    /**
     * Getter method for obtaining the flavor of the donut
     * @return String representing the flavor of donut
     */
    public String getFlavor(){
        return this.flavor;
    }

    /**
     * This method returns the price of the donut order depending
     * on the type of donut
     * @return double representing the price of the donut order
     */
    public double getPrice(){
        if (type.equals("YEAST")) return YEAST;
        else if (type.equals("CAKE")) return CAKE;
        return HOLE;
    }

    /**
     * This method compares two donut orders and checks if they are equal
     * @return true if the donut orders are equal
     */
    @Override
    public boolean equals(Object obj){
        Donut compare = null;
        if (obj instanceof Donut) compare = (Donut) obj;
        else return false;
        return (compare.getType().equals(this.type));
    }

    /**
     * This method returns the donut object as a string 
     * @return String representing the donut
     */
    @Override
    public String toString(){
        return "Donut - " + type + ": " + flavor;
    }
}
