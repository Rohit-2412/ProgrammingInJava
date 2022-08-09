package Questions;

public class Vehicle {
    private int wheels;
    
    public Vehicle() {
        wheels = 2;
        System.out.println("2 wheels");
    }
    
    public Vehicle(int w) {
        wheels = w;
    }
    
    public int getWheels() {
        return wheels;
    }
    
    public void setWheels(int w) {
        wheels = w;
    }
    
    public String toString() {
        return "Wheels: " + wheels;
    }
    
}

class Bus extends Vehicle {
    private int passenger;
    private String maker;
    
    public Bus(String maker) {
        super(8);
        passenger = 22;
        this.maker = maker;
    }
    
    public Bus(String maker,int w, int passenger ) {
        this.passenger = passenger;
        this.maker = maker;
        setWheels(w);
        System.out.println(maker);
    }
    
    @Override
    public String toString() {
        return maker + ", passengers: " + passenger;
    }
}

