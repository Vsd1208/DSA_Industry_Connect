import java.util.*;

class Code {
    private int[] pattern(int n) {
        int arr[] = new int[n];
        for (int i = 0; i < n - 1; i++) {
            if (i == 0)
                arr[i] = 1;
            else if (i == 1)
                arr[i] = 2;
            else {
                arr[i] = Math.abs(arr[i - 1]) + i * i;
            }
            if ((i + 1) % 3 == 0)
                arr[i] = -arr[i];
        }
        return arr;
    }

    private static void cons_print(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] < 0 || arr[i + 1] < 0)
                System.out.println(arr[i] + " " + arr[i + 1]);
        }
    }

    private static void ascen_order(int[] arr) {
        // List<Integer> temp = new ArrayList<>();
        // for (int i = 0; i < arr.length; i++) {
        //     if (i == 0 || arr[i] >= arr[i - 1]) {
        //         temp.add(arr[i]);
        //     } else {
        //         System.out.println(temp);
        //         temp.clear();
        //         temp.add(arr[i]);
        //     }
        // }
        // if (!temp.isEmpty()) {
        //     System.out.println(temp);
        // }
        for(int i=0;i<arr.length-3;i++){
            if(arr[i]==1||arr[i]==2)
                System.out.print(arr[i]+" ");
            else{
                System.out.println();
                System.out.println(arr[i]+" "+arr[i+1]+" "+arr[i+2]);
                i+=2;
            }
        }
    }

    public static void main(String[] args) {
        Code c = new Code();
        int n = 100; // Example input
        int[] result = c.pattern(n);
        System.out.println(Arrays.toString(result));
        cons_print(result);
        ascen_order(result);
    }
}