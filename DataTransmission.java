/*
Problem Statement

When data is transmitted over a network, it is important to check its validity on the
receiving side. This ensures that data is not altered or corrupted. One approach for
validity check is to suffix the data with additional details generated from the original
data itself.

As original data is always characters, it can be represented as a number sequence
(ASCII / UTF-8 etc). For example, data like "ABCD" can be represented as 65 66 67 68
(referring to ASCII codes). Some additional data generated from 65666768 can be
suffixed while transmitting this sequence.

A similar approach is to build a logic where the given number sequence is separated by
certain digits each. Next, identify how many prime numbers are there in those separated
numbers. Then, add this total number of prime numbers with the second largest prime
number in the separated sequence. This new number can be suffixed with #.

Example:
If we want to transmit the number sequence: 122423314766053

Separating two digits each would generate: 12 24 23 31 47 6605 3.
There are total 5 prime numbers and 31 is the second largest.
Hence, we can suffix 36 with the original sequence.
The final sequence transmitted will be: 122423314766053#36

You need to build code for this logic.
The input will be a set of numbers already separated by space.

The submitted code should return the summation of:
- total number of prime numbers
- second largest prime number

Example Input (numbers separated by space, ends with ';'):
1 0 34 56 76 112 111 17 71 112 113 139;

Answer: 117
(There are 4 prime numbers: 17, 71, 113, 139. Second largest is 113. So, 4 + 113 = 117)

Just print the answer value.

Input limit: 0 <= Input number <= 2,147,483,647.
Assume that prime numbers will not be repeated and each list will have two or more
prime numbers.

Sample Input:
233 2435 1123 109 103 4434 2347 993 880 1117 1801 991;

Sample Output:
1809
*/

import java.util.Scanner;



public class DataTransmission {

    public static boolean isPrime(int n) {
    if (n <= 1) return false;
    if (n == 2) return true;
    if (n % 2 == 0) return false;
    int sqrt = (int)Math.sqrt(n);
    for (int i = 3; i <= sqrt; i += 2) {
        if (n % i == 0) return false;
    }
    return true;
}
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        sc.close();
        String str2 = str.substring(0, str.length()-1);
        String[] num_str = str2.split(" ");

        int largest_num = Integer.MIN_VALUE;
        int sec_num = Integer.MIN_VALUE;

        int cnt = 0;

        for (String num : num_str) {
            int val = Integer.parseInt(num);
            if (DataTransmission.isPrime(val)) {
                cnt++;
                if (val > largest_num) {
                    sec_num = largest_num;
                    largest_num = val;
                } else if (val > sec_num) {
                    sec_num = val;
                }
            }
        }
        System.out.println(cnt + sec_num);
    }
}
