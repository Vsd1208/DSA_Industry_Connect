import java.util.*;

class MinPlatforms {

    public static int findMinPlatforms(int[][] trains) {
        int n = trains.length;

        int[] arrival = new int[n];
        int[] departure = new int[n];
        for (int i = 0; i < n; i++) {
            arrival[i] = trains[i][0];
            departure[i] = trains[i][1];
        }
        Arrays.sort(arrival);
        Arrays.sort(departure);

        int platformsNeeded = 0;
        int maxPlatforms = 0;
        int i = 0, j = 0;
        while (i < n && j < n) {
            if (arrival[i] < departure[j]) {
                platformsNeeded++;
                maxPlatforms = Math.max(maxPlatforms, platformsNeeded);
                i++;
            } else {
                platformsNeeded--;
                j++;
            }
        }

        return maxPlatforms;
    }

    public static void main(String[] args) {
        int[][] trains = {
                { 9, 10 },
                { 10, 11 },
                { 11, 12 },
                { 12, 13 },
                { 15, 19 },
                { 18, 20 }
        };

        System.out.println("Minimum platforms required: " +
                findMinPlatforms(trains));
    }
}
