import java.util.*;

class Prime12 {// limit is 10^15 for 12-digit primes
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (long num = 100000000000L; num < 999999999999L && n > 0; num++) {
            if (num % 2 != 0 && num % 3 != 0 && num % 5 != 0 && num % 7 != 0 && num % 11 != 0 && num % 13 != 0
                    && num % 17 != 0) {// miller-rabin bases
                System.out.println(num);
                n--;
            }
        }
    }
}