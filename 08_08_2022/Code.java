/**
 * Problem 1:
 *  Create a function to find only the root value of 'x' in
 * any quadratic equation 'ax^2 + bx + c'.
 * 
 * Input: 
 * - 'a': coefficient of 'x^2'
 * - 'b': coefficient of 'x'
 * - 'c': constant
 * 
 * Examples:
 * quadraticEquation(1, 2, -3) ➞ 1
 * quadraticEquation(2, -7, 3) ➞ 3
 * quadraticEquation(1, -12, -28) ➞ 14
 * 
 * Restriction:
 * - Quadratic equation guaranteed to have a root
 * - Calculate only the root that sums the square root of the 
 *      discriminant, not the one that subtracts it.
 * - Round the value / return only integer value.
 */

/*
 *  Problem 2:
 *   Create a function that tests whether or not an integer is a
 *  perfect number. A perfect number is a number that can be written
 *  as the sum of its factors, (equal to sum of its proper divisors)
 *  excluding the number itself.
 * 
 *  For example, 6 is a perfect number, since 1 + 2 + 3 = 6, where
 *  1, 2, and 3 are all factors of 6. Similarly, 28 is a perfect
 *  number, since 1 + 2 + 4 + 7 + 14 = 28.
 * 
 * Examples
 * checkPerfect(6) ➞ true
 * checkPerfect(28) ➞ true
 * checkPerfect(496) ➞ true
 * checkPerfect(12) ➞ false
 * checkPerfect(97) ➞ false
 */

import java.lang.Math;

public class Code {
    /*
     * Problem 1
     */
    public static int quadraticEquation(int a, int b, int c){
        int root = -1;
        // Equation of root : x = (-b +/- root(b^2 - 4ac) ) / (2a)
        root = ((-1*b) + (int) (Math.sqrt(b*b - 4*a*c)) ) / (2*a);
        return root;
    }

    /*
     * Problem 2
     */
    public static boolean checkPerfect(int num){
        boolean result = false;
        int sum = 1;
        int min = 1, max = num;
        //Code Logic here
        while(min < max){
            //Increment min
            min++;
            if (min < max){
                //Check if min is a factor
                boolean isFactor = num/min == (double)(num) / min;
                //If so, update max and add two factors to sum
                if (isFactor){
                    max = num/min;
                    sum += min;
                    sum += max;
                }
            }
        }
        //Check Sum
        if (sum == num) result = true;
        return result;
    }

    /*
     * Print Functions
     */
    public static void print_quad_test(int a, int b, int c, int expected, int result){
        String output =     "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n"
                        +   "a: %d\n"
                        +   "b: %d\n"
                        +   "c: %d\n"
                        +   "expected:\t%d\n"
                        +   "result:\t\t%d\n"
                        +   "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";
        output = String.format(output, a, b, c, expected, result);
        System.out.println(output);
    }

    public static void print_perfect_test(int num, boolean expected, boolean result){
        String output =     "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n"
                        +   "num:\t\t%d\n"
                        +   "expected:\t%b\n"
                        +   "result:\t\t%b\n"
                        +   "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";
        output = String.format(output, num, expected, result);
        System.out.println(output);
    }

    /*
     * Test Functions
     */
    public static void test_quadraticEquation(){
        // Test Cases
        int [][] test_case = { {1, 2, -3, 1},
                            {2, -7, 3, 3},
                            {1, -12, -28, 14}};
        int result = -1;

        // Print for each test case
        int counter = 1;
        for( int [] test : test_case){
            System.out.println("~~~~~~~~~~~ Test Quad: " + counter + " ~~~~~~~~~~");
            result = quadraticEquation(test[0], test[1], test[2]);
            print_quad_test(test[0], test[1], test[2], test[3], result);
            counter++;
        }
    }

    public static void test_checkPerfect(){
        int [] test_case = { 6, 28, 496, 12, 97 };
        boolean [] expected = { true, true, true, false, false };
        boolean result = false;

        //Print for each test case
        for(int i=0; i < test_case.length; i++){
            System.out.println("~~~~~~~~~ Test Perfect: " + i + " ~~~~~~~~~");
            result = checkPerfect(test_case[i]);
            print_perfect_test(test_case[i], expected[i], result);
        }
    }

    public static void main (String[] args){
        test_quadraticEquation();
        test_checkPerfect();
    }
}
