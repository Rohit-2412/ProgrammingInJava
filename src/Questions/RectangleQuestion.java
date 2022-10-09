package Questions;

// Rectangle class implementation
public class RectangleQuestion {
    private final int width; // data member
    private final int height; // data member
    private final CoordinatePoint location; // data member
    
    //    default constructor
    public RectangleQuestion() {
        this.width = 0;
        this.height = 0;
        this.location = new CoordinatePoint();
    }
    
    // parameterized constructor
    public RectangleQuestion(int width, int height, CoordinatePoint location) {
        this.width = Math.max(width, 0);
        this.height = Math.max(height, 0);
        this.location = location;
    }
    
    // parameterized constructor
    public RectangleQuestion(int width, int height) {
        this.width = Math.max(width, 0);
        this.height = Math.max(height, 0);
        this.location = new CoordinatePoint();
    }
    
    // parameterized constructor
    public RectangleQuestion(int x, int y, int width, int height) {
        this.width = Math.max(width, 0);
        this.height = Math.max(height, 0);
        this.location = new CoordinatePoint(x, y);
    }
    
    //    copy constructor
    public RectangleQuestion(RectangleQuestion r) {
        this.height = r.height;
        this.width = r.width;
        this.location = r.location;
    }
    
    //    toString method
    @Override
    public String toString() {
        return "Rectangle: location=(" + location.x + "," + location.y + "), width=" + width + ", height=" + height;
    }
    
    //    function to return location
    public CoordinatePoint getLocation() {
        return location;
    }
    
    //    function to return height
    public int getHeight() {
        return height;
    }
    
    //    function to return width
    public int getWidth() {
        return width;
    }
    
    
    //    function to return area using area = height * width
    public double getArea() {
        return height * width;
    }
    
    //    function to return perimeter using perimeter = 2(height + width)
    public double getPerimeter() {
        return 2 * (height + width);
    }
    
    
    //    function to return perimeter using diagonal = sqrt(width^2 + height^2)
    public double getDiagonal() {
        return Math.sqrt(Math.pow(width, 2) + Math.pow(height, 2));
    }
    
    //    function to check if one object of class Rectangle is equal to another object or not
    public boolean isEqualTo(RectangleQuestion other) {
        return this.height == other.getHeight() && this.width == other.getWidth();
    }
    
    //    function to check if a point lies between this rectangle or not
    public boolean contains(int x, int y) {
        return x > location.x && y > location.y &&
                x < location.x + height && y < location.y + width;
    }
    
    //    function to check if a point lies between this rectangle or not
    public boolean contains(CoordinatePoint point) {
        return point.x > location.x && point.y > location.y &&
                point.x < location.x + height && point.y < location.y + width;
        
    }
}

// coordinate point class
class CoordinatePoint {
    int x, y; // data members
    
    
    //    default constructor
    public CoordinatePoint() {
        this.x = 0;
        this.y = 0;
    }
    
    //    parameterized constructor
    public CoordinatePoint(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

