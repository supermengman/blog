package _posts;

// write java code to add two binary numbers of 1 and 1
// 1 + 1 = 10

import java.util.Scanner;
public class BinaryAdd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter first binary number: ");
        // Use as radix 2 because it's binary   
        int a = Integer.parseInt(sc.nextLine(), 2);
        System.out.println("Enter second binary number: ");
        int b = Integer.parseInt(sc.nextLine(), 2);
         

        int sum = a + b;
        System.out.println("Sum of two binary numbers is: " + Integer.toBinaryString(sum));
    }
}