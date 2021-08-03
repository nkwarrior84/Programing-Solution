/*
Boxing, karate, sambo… The audience is sick of classic combat sports. That is why a popular sports channel launches a new competition format based on the traditional Russian entertainment called line fighting. There can be from 2 to k teams taking part in a competition, and there are n fighters altogether in all the teams. Before the competition starts, the fighters are divided into teams: each fighter becomes a member of exactly one team. Two fighters fight each other if they are members of different teams. The organizers believe that the more the number of fights between fighters, the higher the popularity of a competition will be. Help the organizers to distribute fighters between teams so as to maximize the number of fights and output this number.
Input
The first line contains the number of tests T (1 ≤ T ≤ 10). In each of the following T lines you are given a test: integers n and k separated with a space (2 ≤ k ≤ n ≤ 104).
Output
For each test output the answer (one integer) in a separate line.
Sample
input	
3
6 3
5 5
4 2
output

12
10
4

*/

import java.util.Scanner;

public class lineFighting {
    
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        int n = x.nextInt();
        
        for (int i = 0; i < n; i++) {
            System.out.println(solve(x.nextInt(), x.nextInt()));
        }
    }

    public static long solve(int n, int k){
        int a[] = new int[k], t = 0;
        long res = 0;
        
        int x = n % k == 0 ? n / k : n % k ;
        int y = n % k  == 0 ? n / k : n / k + 1;

        for (int i = 0; i < x; i++) {
            if (i < a.length)  
                a[i] = y;
            t++;
        }

        for (int i = t; i < a.length; i++) {
            a[i] =  n / k;
        }

        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                res += a[i] * a[j];
            }
        }
        return res;
    }
}
