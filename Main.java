package edu.cscc;
//Michael Heironimus, 2.6.2020, The purpose of this program is to find the lowest and highest cell phone prices of a given number of cell phones prices
import java.util.Arrays;
import java.util.Scanner;
import java.lang.Math;

public class Main {

    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int numberOphones;
        System.out.println("How many cell phone prices would you like to enter?");
        //added in the option of entering more or less than 10 cell phone prices
        numberOphones = input.nextInt();
        while (numberOphones <= 0) {
            //this makes sure the user doesn't say they wish to enter a negative number of cell phone prices (or 0)
            System.out.println("How many cell phones prices would you like to enter (greater than 0 numbers only please)?");
            numberOphones = input.nextInt();
        }
        double[] prices = new double[numberOphones];
        // this creates an array that is as big as the previous number the user entered
        String[] pricesFormatGood = new String[numberOphones];
        //this array of strings will later make the numbers rounded to the hundredths place for currency. Simply to make it look better to the user
        System.out.println("Please enter all the cell phone prices (in US $ and separated by a space): ");
        //added unit of measurement, also why I changed the array to doubles instead of integers
        boolean isNegative = false;
        //this is used to check if any entered number is negative (or 0) or includes decimals past the hundredths place
        while (true) {
            for (int i = 0; i < numberOphones; i++) {
                //this for loop will go from 0 to one before the number of the array (because arrays start counting at 0)
                prices[i] = input.nextDouble( );
                if (prices[i] <= 0 || prices[i] - Math.floor(prices[i] * 100.0) / 100.0 != 0) {
                    //this checks if every element of array is negative (or 0) and past the hundredths place and if they are...
                    isNegative=true;
                    //it marks it down as true
                }
            }
            if (!isNegative) {
                //this happens only if "isNegative" is equal to 0 and will break out in the end.
                Arrays.sort(prices);
                //this sorts the array by value
                for (int i = 0; i < numberOphones; i++) {
                    //this will make the array round to the hundredths place example if 2 is entered it will become 2.00. This will turn the number into a string though.
                    //this had to be entered after the previous array was sorted since this array is made of strings it cannot be sorted from smallest to largest.
                    pricesFormatGood[i] = String.format("%.2f", prices[i]);
                    //this will make every entry in the prices array a string that consists of the number displayed to the hundredths place even if they are zeros
                    pricesFormatGood[i] ="$" + pricesFormatGood[i];
                    //this adds a "$" to the front of string.
                }
                if (numberOphones == 1) {
                    //this "if then else tree" is necassary to tell the program what to do if there aren't three highest and lowest prices.
                    System.out.println("The only phone price entered is: ");
                    System.out.println("" + pricesFormatGood[0]);
                    //a for loop doesn't make sense if less then two numbers are entered so I used it if the user entered 4 or more prices.
                } else if (numberOphones == 2 || numberOphones == 3) {
                    System.out.println("The highest cell phone price entered is: ");
                    System.out.println(" " + pricesFormatGood[numberOphones-1]);
                    System.out.println("The lowest cell phone price is: ");
                    System.out.println("" + pricesFormatGood[0]);
                } else if (numberOphones == 4 || numberOphones == 5) {
                    System.out.println("The two highest cell phone prices entered are: ");
                    for (int i=numberOphones-1;i>numberOphones-3;i--) {
                        //this goes through and prints the two highest cell phone prices
                        System.out.println("" +pricesFormatGood [i]);
                    }
                    System.out.println("The two lowest cell phone prices entered are: ");
                    for (int i=0; i<2; i++) {
                        System.out.println("" +pricesFormatGood [i]);
                    }
                } else {
                    System.out.println("The three highest cell phone prices entered are: ");
                    for (int i=numberOphones-1;i>numberOphones-4;i--) {
                        System.out.println("" +pricesFormatGood [i]);
                    }
                    System.out.println("The three lowest cell phone price entered are:" );
                    for (int i=0; i<3; i++) {
                        System.out.println("" + pricesFormatGood[i]);
                    }
                }
                break;
            }
            isNegative = false;
            //this will reset isNegative to 0 and starts the loop over again
            System.out.println("Please reenter all the cell phone prices (in US $ and separated by a space, above 0 and to the hundredths place): ");
        }
    }
}