
class Max_profit {

    public static void main(String[] args) {
        int[] buy = { 7, 1, 5, 3, 6, 4 };
        int[] sell = { 1, 2, 3, 4, 5, 6 };
        int max_profit = 0;
        for (int index = 0; index < buy.length; index++) {
            for (int j = index + 1; j < sell.length; j++) {
                if (sell[j] - buy[index] > max_profit) {
                    max_profit = sell[j] - buy[index];
                }
            }
        }
        System.out.println(max_profit);
    }
}