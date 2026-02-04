import java.util.*;

class Fibonacci {
    private void series(int count, int a, int b) {
        if (count == 0)
            return;
        System.out.print(a + " ");
        series(count - 1, b, a + b);// Tail recursion to generate Fibonacci series
    }

    public static void main(String[] args) {
        Fibonacci f = new Fibonacci();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of terms in Fibonacci series: ");
        int n = sc.nextInt();
        System.out.println("Fibonacci Series:");
        f.series(n, 0, 1);
        sc.close();
    }
}