package Questions;

import java.util.ArrayList;

public class TestVehicle {
    public static void main(String[] args) {
        ArrayList<Vehicle> vList = new ArrayList<>();
        vList.add(new Vehicle()); // 1
        
        Bus b1 = new Bus("Mercedes");
        Bus b2 = new Bus("Toyota", 6, 24);
        Bus b3 = new Bus("Mazda");
        // 2

        vList.add(b1);

        System.out.println(vList.get(1).getWheels()); // 3

        vList.add(new Bus("Mazda"));

        System.out.println(vList.contains(b3));  // 4

        vList.set(1, b2);
        System.out.println(vList.remove(2)); // 5

        System.out.println(vList); // 6
    }
}
/*
OUTPUT 1 :
2 Wheels
REASON - (DEFAULT CONSTRUCTOR CALLED)

OUTPUT 2 :
2 Wheels (DUE TO DEFAULT CONSTRUCTOR BEING CALLED)
Toyota (System.out.println(maker); // HERE MAKER = Toyota)

OUTPUT 3 :
8
when b1 was instantiated/created a string was passed
and then this code was executed : super(8);
it sets the nWheels as 8

OUTPUT 4 :
false
we have added only b1 in the vList
hence it returns false for
System.out.println(vList.contains(b3));

OUTPUT 5 :
Mazda, passengers: 22
System.out.println(vList.remove(2));
removes the object stored at index 2, or 3rd item from beginning

OUTPUT 6 :
[Wheels: 2, Toyota, passengers: 24]
After removal of object at index 2
only 2 items were left in the list

first the toString for Vehicle will get called
which will return {Wheels: 2}
NOTE : {} are just for better understanding they're not part of answer.

then toString for Bus will get called
which will return {Toyota, passengers: 24}
NOTE : {} are just for better understanding they're not part of answer.
 */