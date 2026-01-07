import java.util.*;

public class average_rating {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Map<Double, Integer> rating = new HashMap<>();
        // System.out.print("Enter number of users: ");
        int n = sc.nextInt();
        // if (n <= 0) {
        // System.out.println("No ratings available.");
        // return;
        // }
        // for (int i = 0; i < n; i++) {
        // System.out.print("Enter rating::");
        // double r = sc.nextDouble();
        // if (r < 1 || r > 5) {
        // System.out.println("Invalid rating");
        // i--;
        // continue;
        // }
        // rating.put(r, rating.getOrDefault(r, 0) + 1);
        // }
        // double sum = 0;
        // int totalCount = 0;
        // for (Map.Entry<Double, Integer> entry : rating.entrySet()) {
        // sum += entry.getKey() * entry.getValue();
        // totalCount += entry.getValue();
        // }
        // double average = sum / totalCount;
        // System.out.printf("Average Product Rating: %.2f\n", average);
        // sc.close();
        double avg = 0;
        for (int i = 1; i <= n; i++) {
            double k = sc.nextDouble();
            avg += (k - avg) / i;
            System.out.println(avg);
        }
    }
}
