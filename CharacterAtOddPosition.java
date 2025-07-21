/*
 Problem Statement

 Write a Java program to print the characters at the odd position of a given string

 Input

    Hey there!

 Output

    e hr!

 Explanation

 All the characters (including whitespace) at the odd position of the string `Hey there!` are printed.
*/

import java.util.Scanner;

public class CharacterAtOddPosition {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        String ans = "";

        for(int i=0;i<str.length();i++){
            if(i%2==1){
                ans = ans+str.charAt(i);
            }
        }

        System.out.println(ans);
    }
}
