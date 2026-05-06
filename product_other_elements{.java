class product_other_elements {
    private static int[] other_product(int[] arr) {
        int[] result = new int[arr.length];

        int[] left_product = new int[arr.length];
        int[] right_product = new int[arr.length];

        for (int index = 0; index < arr.length; index++) {
            if (index == 0)
                left_product[index] = 1;
            else
                left_product[index] = left_product[index - 1] * arr[index - 1];
        }
        for (int index = arr.length - 1; index >= 0; index--) {
            if (index == arr.length - 1)
                right_product[index] = 1;
            else
                right_product[index] = right_product[index + 1] * arr[index + 1];
        }
        for (int index = 0; index < arr.length; index++) {
            result[index] = left_product[index] * right_product[index];
        }
        return result;

    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 0, -10, 5 };

        int[] result = other_product(arr);

        for (int index = 0; index < result.length; index++)
            System.out.print(result[index] + " ");
    }
}