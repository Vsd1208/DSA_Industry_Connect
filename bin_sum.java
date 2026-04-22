class bin_sum {
    public static void main(String[] args) {
        String str1; // First binary string
        String str2; // Second binary string
        int sl1; // Length of first binary string
        int sl2; // Length of second binary string
        int carry; // Carry for addition
        int sum; // Sum of bits and carry
        StringBuilder sb; // StringBuilder to build the result


        str1 = "10101";
        str2 = "111010";
        sl1 = str1.length();
        sl2 = str2.length();
        while (sl1 < sl2) {
            str1 = "0" + str1;
            sl1++;
        }
        --sl1;
        --sl2;
        carry = 0;
        sum = 0;
        sb = new StringBuilder();
        while (sl1 >= 0 && sl2 >= 0) {
            sum = carry;
            if (sl1 >= 0)
                sum += str1.charAt(sl1--) - '0';
            if (sl2 >= 0)
                sum += str2.charAt(sl2--) - '0';
            sb.append(sum % 2);
            carry = sum / 2;
        }
        if (carry == 1) {
            sb.append(carry);
        }
        System.out.println("Result: " + sb.reverse());
    }
}