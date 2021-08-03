/*

Your task is to find the sum of all integer numbers lying between 1 and N inclusive.
Input
The input consists of a single integer N that is not greater than 10000 by it's absolute value.
Output
Write a single integer number that is the sum of all integer numbers lying between 1 and N inclusive.
Sample
input	
-3
output
-5


*/

import java.util.*;

public class Sum_1068 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextInt(), s = 0;
        if (n > 0)
            for (int i = 1; i <= n; i++)    {
                s += i;
            }
        else
            for (int i = 1; i >= n; i--) {
                s += i;
            }
        System.out.println(s);
    }
}
