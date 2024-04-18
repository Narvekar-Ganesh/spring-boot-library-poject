package home.practice.spring.domain;

import java.util.Arrays;

public enum Season {
    WINTER,
    SUMMER ,
    RAINY;

    public void display(){
        System.out.println("I am in display() method");
    }

    public static void main(String[] args) {
        String inputSeason = "WINTER";

        System.out.println(Season.valueOf(inputSeason)); // it is used to convert a string to enum

        Season[] seasonValues = Season.values(); //it returns an array of Season in which they are declared
        System.out.println("seasonValues : " + Arrays.toString(seasonValues));

        Season.WINTER.display();

        /*Integer integer = Integer.parseInt("Siddhu");
        System.out.println("value of integer : " + integer);
*/
    }
}
