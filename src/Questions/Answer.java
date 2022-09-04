package Questions;

// Defining and implementing instructor class
class Instructor {
    String name; // name of the instructor
    int experience; // Years of experience of the instructor
    String education; //Education of the instructor
    int salary; // Salary of the instructor
    
    // defining a default constructor
    public Instructor() {
        this.name = ""; // assigning a default value
        this.experience = 0; // assigning a default value
        this.education = ""; // assigning a default value
        this.salary = 0; // assigning a default value
    }
    
    // parametrized constructor
    public Instructor(String name, int experience, String education, int salary) {
        this.name = name; // assigning the value passed to the function to the object's data member using
        // 'this' keyword
        this.experience = experience; // assigning the value passed to the function to the object's data member using
        // 'this' keyword
        this.education = education; // assigning the value passed to the function to the object's data member using
        // 'this' keyword
        this.salary = salary; // assigning the value passed to the function to the object's data member using
        // 'this' keyword
    }
    
    @Override
    // toString() function to print the object of class `Instructor`
    public String toString() {
        // Using \n to enter the content in new line
        return "\nName : " + name + "\nExperience (in years) : " + experience + "\nEducation : " + education +
                "\nSalary : " + salary;
    }
}

// Defining and implementing class course
class CourseC {
    String code; // course code
    String name; // Name of the course
    Instructor instructor; // Instructor of the course
    int level; // level of the Course
    int credits; // Credits of the course
    
    // Defining a default constructor for the class
    public CourseC() {
        this.code = ""; // assigning a default value
        this.name = ""; // assigning a default value
        this.instructor = new Instructor(); // assigning a default value
        this.level = 0; // assigning a default value
        this.credits = 0; // assigning a default value
    }
    
    // Defining a parameterised constructor for the class course
    public CourseC(String code, String name, Instructor instructor, int level, int credits) {
        this.code = code;  // assigning the value passed to the function to the object's data member using
        // 'this' keyword
        this.name = name;  // assigning the value passed to the function to the object's data member using
        // 'this' keyword
        this.instructor = instructor;  // assigning the value passed to the function to the object's data member using
        // 'this' keyword
        this.level = level;  // assigning the value passed to the function to the object's data member using
        // 'this' keyword
        this.credits = credits;  // assigning the value passed to the function to the object's data member using
        // 'this' keyword
    }
    
    // Defining the toString() method for the class course to print the data members value in a user-friendly manner
    @Override
    public String toString() {
        // Using \n to enter the content in new line
        return "Course details are as follows :\n" + "Code : " + code + "\nName : " + name + "\nInstructor : " + instructor + "\nLevel : " + level + "\nCredits : " + credits + '\n';
    }
    
    // Defining and implementing of function named as courseFees() to calculate the course fee Depending upon value
    // of level
    public int courseFees() {
        // If level is 1 return 140
        if (level == 1) {
            return 140;
        }
        // If level is 2 return 160
        else if (level == 2) {
            return 160;
        }
        // If level is 3 return 190
        else if (level == 3) {
            return 190;
        }
        // If level is 4 return 210
        else if (level == 4) {
            return 210;
        }
        // Returning -1 as a sign of incorrect level or wrong value of level passed / set to the level data member
        return -1;
    }
}

public class Answer {
    // main function
    public static void main(String[] args) {
        // Initialising and defining an object of class Instructor using parameterised constructor
        Instructor i1 = new Instructor("James Walker", 10, "Ph.D", 120000);
        
        // Initialising and defining an object of class Course using parameterised constructor
        CourseC c1 = new CourseC("CSE212", "Computer Science", i1, 2, 5);
        
        // Printing c1 to the console
        System.out.println(c1);
        
        // Printing course fee using the function of the class
        System.out.println("Course fees : " + c1.courseFees());
        
        System.out.println(); // printing a new line
        
        // Initialising and defining an object of class instructor using parameterised constructor
        Instructor i2 = new Instructor("Joseph Garcia", 15, "Ph.D", 180000);
        
        // Initialising and defining an object of class Course using parameterised constructor
        CourseC c2 = new CourseC("IT323", "Information Technology", i2, 4, 3);
        
        // Printing c2 to the console
        System.out.println(c2);
        
        // Printing course fee using the function of the class
        System.out.println("Course fees : " + c2.courseFees());
    }
}