// 09-09-2022 12:31 September

package Questions;

// public class
public class DateClass {
    // main function
    public static void main(String[] args) {
        // creating an instance date1 of myDate class
        myDate date1 = new myDate(10, 4, 1990); // 10 April 1990
        System.out.println(date1); // printing date1
        System.out.println(date1.dayofWeek()); // printing day of week for date1
        
        // creating an instance date2 of myDate class
        myDate date2 = new myDate(10, 4, 1990); // 10 April 1990
        System.out.println(date2);// printing date1
        System.out.println(date2.dayofWeek());// printing day of week for date2
        
        // creating an instance date3 of myDate class
        myDate date3 = new myDate(19, 9, 2022); // 3 August 1995
        System.out.println(date3);// printing date1
        System.out.println(date2.dayofWeek());// printing day of week for date3
        
        // comparing date1 with date3
        System.out.println(date1.compare(date2)); // prints 0
        
        // comparing date2 with date3
        System.out.println(date2.compare(date3)); // prints -1
        
        // comparing date3 with date1
        System.out.println(date3.compare(date1)); // prints 1
        
    }
    
    static class myDate {
        int day;
        int month;
        int year;
        
        public myDate(int day, int month, int year) {
            this.day = day;
            this.month = month;
            this.year = year;
        }
        
        public int getDay() {
            return day;
        }
        
        public void setDay(int day) {
            this.day = day;
        }
        
        public int getMonth() {
            return month;
        }
        
        public void setMonth(int month) {
            this.month = month;
        }
        
        public int getYear() {
            return year;
        }
        
        public void setYear(int year) {
            this.year = year;
        }
        
        boolean isLeap() {
            return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
        }
        
        int compare(myDate date1) {
            if (this.year > date1.year) {
                return 1;
            }
            else if (this.year == date1.year) {
                if (this.month > date1.month) {
                    return 1;
                }
                else if (this.month == date1.month) {
                    return Integer.compare(this.day, date1.day);
                }
            }
            
            return -1;
        }
        
        String dayofWeek() {
            String[] weekdays = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
            int day =
                    (this.year / 400 - this.year / 50 - 1 + 5 * this.year / 4 - 5 * (this.year / 100) * 25 + 26 * (this.month + 1) / 10 + this.day) % 7;
            return weekdays[day];
        }
        
        @Override
        public String toString() {
            String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September",
                               "October", "November", "December"};
            return day + " " + months[month - 1] + " " + year;
        }
    }
}
