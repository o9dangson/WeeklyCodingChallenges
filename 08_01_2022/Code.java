/*
 * Create a function that takes an array and a number and selectively reverse
 * the order of the array based on the number you're given (2nd argument). If
 * you're given the arguments [1,2,3,4,5,6] and 2, you would return the array
 * [2,1,4,3,6,5].
 * 
 * - If array can't be broken into equal parts, just reverse remaining numbers
 * - if 'len' exceeds array length, reverse everything
 * - if 'len' = 0; return original array
 */

import java.util.*;

public class Code{
    //Variables
    protected List<int[]> test_arr = new ArrayList<int[]>();
    protected int[] test_num;
    protected List<int[]> expected = new ArrayList<int[]>();

    //Function
    //Setup test
    public void setup(){
        test_arr.add(new int[] {1,2,3,4,5,6});
        test_arr.add(new int[] {2,4,6,8,10,12,14,16});
        test_arr.add(new int[] {5,7,2,6,0,4,6});
        test_num = new int[] {2, 3, 100};
        expected.add(new int[] {2,1,4,3,6,5});
        expected.add(new int[] {6,4,2,12,10,8,16,14});
        expected.add(new int[] {6,4,0,6,2,7,5});
    }

    //Print Results
    public void print_result(){
        for(int i=0;i<test_arr.size();i++){
            System.out.print("selReverse(");
            print_arr(test_arr.get(i));
            System.out.println(", " + test_num[i] + ") =>");
            System.out.print("expected:\t");
            print_arr(expected.get(i));
            System.out.print("\nactual:\t\t");
            print_arr(selReverse(test_arr.get(i), test_num[i]));
            System.out.println('\n');
        }
    }

    //Print Array Contents
    public void print_arr(int[] arr){
        System.out.print("[");
        for( int j=0; j<arr.length; j++){
            if (j != arr.length - 1)
                System.out.print( arr[j] + ", ");
            else
                System.out.print( arr[j] + "]");
        }
    }

    //Implemented Reverse Function
    public static int[] selReverse(int [] arr, int len){
        //Check len = 0
        if (len != 0){
            int index = 0;
            //Check len > arr.length
            if (len > arr.length)
                len = arr.length;
            //Reverse Each Array Segment
            for(index=0; index < arr.length; index+=len){
                int start = index;
                //Check if segment matches 'len' size.
                int end;
                if (index + len < arr.length)
                    end = index + len - 1;
                else
                    end = arr.length - 1;
                for (start = index; start<end; start++){
                    // Swap elements
                    int temp = arr[start];
                    arr[start] = arr[end];
                    arr[end] = temp;
                    // decrement end
                    end--;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args){
        Code myCode = new Code();
        myCode.setup();
        myCode.print_result();
        
        // int [] result = selReverse(myCode.test_arr.get(0), myCode.test_num[0]);
        // myCode.print_arr(result);
    }
}