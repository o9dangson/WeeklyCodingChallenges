/**
 * Create a function to find only the root value of 'x' in
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
 * - Calculate only the root that sums the square root of the discriminant, not the one that subtracts it.
 * - Round the value / return only integer value.
 */

import java.lang.Math;

public class Code {
    public static int quadraticEquation(int a, int b, int c){
        int root = -1;
        // Equation of root : x = (-b +/- root(b^2 - 4ac) ) / (2a)
        root = ((-1*b) + (int) (Math.sqrt(b*b - 4*a*c)) ) / (2*a);
        return root;
    }

    public static void print_test(int a, int b, int c, int expected, int result){
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

    public static void test_quadraticEquation(){
        // Test Cases
        int [][] test_case = { {1, 2, -3, 1},
                            {2, -7, 3, 3},
                            {1, -12, -28, 14}};
        int result = -1;

        // Print for each test case
        int counter = 1;
        for( int [] test : test_case){
            System.out.println("~~~~~~~~~~~ Test Case: " + counter + " ~~~~~~~~~~");
            result = quadraticEquation(test[0], test[1], test[2]);
            print_test(test[0], test[1], test[2], test[3], result);
            counter++;
        }
    }

    public static void main (String[] args){
        test_quadraticEquation();
    }
}
