package Questions;

public class Answer3 {
    public static void main(String[] args) {
/*
        int[] table = {1, 2, 3, 4, 5, 6};
        for (int i = table.length % 2; i < table.length / 2; i++) {
            System.out.println("Iteration " + (i + 1) + " : i = " + i);
            System.out.println("Current state of array : ");
            System.out.println(Arrays.toString(table));
            System.out.println();
            System.out.println("table[i] = table[i + 1] + table[i];");
            System.out.println("table[" + i + "] = " + "table[" + (i + 1) + "] + " + "table[" + i + "]");
            System.out.println("table[" + i + "] = " + table[(i + 1)] + " + " + table[i]);
            table[i] = table[(i + 1)] + table[i];
            System.out.println();
            System.out.println("Updated state of array : ");
            System.out.println(Arrays.toString(table));
            System.out.println();
        }
*/
        
        /*
        QUESTION 1
        
        table.length = 6
        so, table.length % 2 = 0 (because even number gives % 2 as 0)
            table.length / 2 = 3

        Iteration 1 : i = 0 (0 < 3 : true)
        Current state of array :
        [1, 2, 3, 4, 5, 6]
        
        table[i] = table[i + 1] + table[i];
        table[0] = table[1] + table[0]
        table[0] = 2 + 1
        
        Updated state of array :
        [3, 2, 3, 4, 5, 6]
        
        Iteration 2 : i = 1 (1 < 3 : true)
        Current state of array :
        [3, 2, 3, 4, 5, 6]
        
        table[i] = table[i + 1] + table[i];
        table[1] = table[2] + table[1]
        table[1] = 3 + 2
        
        Updated state of array :
        [3, 5, 3, 4, 5, 6]
        
        Iteration 3 : i = 2 (2 < 3 : true)
        Current state of array :
        [3, 5, 3, 4, 5, 6]
        
        table[i] = table[i + 1] + table[i];
        table[2] = table[3] + table[2]
        table[2] = 4 + 3
        
        Updated state of array :
        [3, 5, 7, 4, 5, 6]

        Iteration 4 : i = 3 (3 < 3 : false)
        for loop breaks
        
        Answer : B
         */


        int k = 2;
        int m = 4;

        do {
            System.out.println("Hi");
        } while (k > m);
        
        /*
        QUESTION 2
        In a do-while loop, first the task is executed once then it checks the condition written inside while ()
        
        Here we have given variable k as 2 and variable m as 4
        in the start it will enter the do block and execute the " System.out.println("Hi"); " once then it will check if
        k is greater than m
        since k = 2 and m = 4
        we can straight away conclude that, k is not greater than m
        so condition fails, and it will exit from the do-while loop
        
        Answer : B
         */
        
        /*
        QUESTION 3
        A. public static findValue(double[] a);
        Explanation: This is a wrong method heading because there is no return type mentioned in the function declaration heading.
        
        B. public static void findValue(int a[10]);
        Explanation: This is a wrong method heading because here the declaration of array is wrong, and we have also declared the size of the area which can lead to error sometimes.
        
        C. public static boolean findValue(double [] a);
        Explanation: This is a correct method heading because here the return type is mentioned i.e. boolean, and we haven't mentioned the size of the array and the declaration of array is also as per the Java rules.
        date_type [] array_name; // java style
        date_type array_name []; // c-style
        
        D. public static double findValue(a);
        Explanation: This method declaration is wrong because here we have not mentioned the data type of the parameter which we are accepting in our method.
        
        Answer : C
         */
    }
//    public static findValue(double[] a);
//    public static void findValue(int a[10]);
//    public static boolean findValue(double [] a);
//    public static double findValue(a);

}
