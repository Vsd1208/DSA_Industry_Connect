import java.util.*;

public class average_rating {
    public static double updateAverage(double currentAvg, double newValue, int count) {
        return currentAvg + (newValue - currentAvg) / count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, double[]> productData = new HashMap<>();

        System.out.print("Enter number of entries: ");
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            System.out.print("\nEnter product name: ");
            String product = sc.nextLine();
            System.out.print("Enter the rating of the product: ");
            double value = sc.nextDouble();
            sc.nextLine();
            productData.putIfAbsent(product, new double[] { 0, 0 });
            double[] data = productData.get(product);
            int count = (int) data[0] + 1;
            double avg = updateAverage(data[1], value, count);
            data[0] = count;
            data[1] = avg;
            System.out.printf("Current average of %s: %.2f%n", product, avg);
        }
        System.out.println("\nFinal Average per Product:");
        for (Map.Entry<String, double[]> entry : productData.entrySet()) {
            System.out.printf("%s -> %.2f%n", entry.getKey(), entry.getValue()[1]);
        }
        sc.close();
    }
}