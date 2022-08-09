// 16-07-2022 12:11 July

package Questions;

// stock item class
class StockItem {
    int itemID; // int data member to store the ID
    String description; // string data member to store description of the item
    int unitsOnHand; // int data member to store number of units
    double price; // double data member to store price
    
    // parameterized constructor
    public StockItem(int itemID, String description, int unitsOnHand, double price) {
        // assigning the value of class data member to the value passed as argument to the constructor
        this.itemID = itemID;
        this.description = description;
        this.unitsOnHand = unitsOnHand;
        this.price = price;
    }
    
    // toString method for printing the value of object
    @Override
    public String toString() {
        return "StockItem {" +
                "itemID=" + itemID +
                ", description='" + description + '\'' +
                ", unitsOnHand=" + unitsOnHand +
                ", price=" + price +
                '}';
    }
}

// Constructor class to demonstrate the use of constructor
public class Constructor {
    
    // main function
    public static void main(String[] args) {
        // creating an instance of StockItem class using parameterized constructor
        StockItem obj1 = new StockItem(123, "This is just a sample description about the object1", 100, 125.25);
        System.out.println(obj1); // printing obj1 on screen
        StockItem obj2 = new StockItem(10, "This is just a sample description about the object2", 1, 777.147);
        System.out.println(obj2); // printing obj2 on screen
        StockItem obj3 = new StockItem(1, "This is just a sample description about the object3", 250, 521.213);
        System.out.println(obj3); // printing obj3 on screen
    }
    
}
