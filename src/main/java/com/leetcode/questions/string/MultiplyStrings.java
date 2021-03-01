package com.leetcode.questions.string;

public class MultiplyStrings {
    /*
    - intuition:
        - use two pointers i and j
            - one nested in the other
            e.g. 100 * 45
                 100 * 5 * 1 -> 500
                 100 * 4 * 10 -> 4000
                 4000 + 500 -> 4500
    */
    public String multiply(String num1, String num2) {
        // always make num1 the shorter number
        if (num1.length() > num2.length()) {
            String tmp = num1;
            num1 = num2;
            num2 = tmp;
        }

        StringBuilder product = new StringBuilder("0");
        int tailingZeros = 0;
        int carry = 0;

        for (int i = num1.length() - 1; i >= 0; i--) {
            carry = 0;
            int a = num1.charAt(i) - '0';
            StringBuilder tmp = new StringBuilder();

            for (int j = num2.length() - 1; j >= 0; j--) {
                int b = num2.charAt(j) - '0';
                int c = a * b + carry;

                if (c >= 10) {
                    carry = c / 10;
                    tmp.insert(0, c % 10);
                } else {
                    carry = 0;
                    tmp.insert(0, c);
                }
            }

            if (carry > 0) tmp.insert(0, carry);

            for (int k = 0; k < tailingZeros; k++) {
                tmp.append(0);
            }

            tailingZeros++;

            add(product, tmp);
            product = tmp;
        }

        return product.toString();
    }

    /*
    b is always longer than a
    */
    private void add(StringBuilder a, StringBuilder b) {
        int carry = 0;

        int i = a.length() - 1, j = b.length() - 1;

        while (i >= 0 && j >= 0) {
            int num1 = a.charAt(i) - '0';
            int num2 = b.charAt(j) - '0';
            int sum = num1 + num2 + carry;

            if (sum >= 10) {
                carry = 1;
                b.setCharAt(j, (char) ((sum % 10) + '0'));
            } else {
                carry = 0;
                b.setCharAt(j, (char) (sum + '0'));
            }

            i--;
            j--;
        }

        if (carry == 1) {
            if (b.charAt(0) == '0' || a.length() == b.length()) {
                b.insert(0, '1');
            } else {
                int c = b.charAt(0) - '0' + 1;
                b.setCharAt(0, (char) ((c % 10) + '0'));

                if (c >= 10) {
                    b.insert(0, '1');
                }
            }
        }
    }
}
