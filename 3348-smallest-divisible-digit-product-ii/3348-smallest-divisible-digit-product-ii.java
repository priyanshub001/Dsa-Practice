import java.util.*;

class Solution {

    static final int[] primes = {2, 3, 5, 7};

    static final int[][] factors = {
        {},
        {},
        {2},
        {3},
        {2, 2},
        {5},
        {2, 3},
        {7},
        {2, 2, 2},
        {3, 3}
    };

    public String smallestNumber(String num, long t) {

        int[] need = getPrimeCount(t);

        if (need == null) {
            return "-1";
        }

        int[] factorCount = getFactorCount(need);

        if (sum(factorCount) > num.length()) {
            return construct(factorCount);
        }

        int[] prefix = getPrimeCount(num);

        int firstZero = num.indexOf('0');

        if (firstZero == -1) {

            firstZero = num.length();

            if (isSubset(need, prefix)) {
                return num;
            }
        }

        for (int i = num.length() - 1; i >= 0; i--) {

            int digit = num.charAt(i) - '0';

            removeFactors(prefix, digit);

            int space = num.length() - 1 - i;

            if (i > firstZero) {
                continue;
            }

            for (int bigger = digit + 1; bigger <= 9; bigger++) {

                int[] remaining = need.clone();

                for (int j = 0; j < 4; j++) {
                    remaining[j] =
                        Math.max(
                            0,
                            remaining[j]
                            - prefix[j]
                            - countFactor(bigger, j)
                        );
                }

                int[] requiredDigits = getFactorCount(remaining);

                int required = sum(requiredDigits);

                if (required <= space) {

                    int ones = space - required;

                    StringBuilder ans = new StringBuilder();

                    ans.append(num.substring(0, i));
                    ans.append(bigger);

                    ans.append("1".repeat(ones));

                    ans.append(construct(requiredDigits));

                    return ans.toString();
                }
            }
        }

        int[] requiredDigits = getFactorCount(need);

        int required = sum(requiredDigits);

        return "1".repeat(num.length() + 1 - required)
                + construct(requiredDigits);
    }

    static int[] getPrimeCount(long t) {

        int[] count = new int[4];

        for (int i = 0; i < 4; i++) {

            while (t % primes[i] == 0) {
                count[i]++;
                t /= primes[i];
            }
        }

        if (t != 1) {
            return null;
        }

        return count;
    }

    static int[] getPrimeCount(String num) {

        int[] count = new int[4];

        for (char c : num.toCharArray()) {

            int digit = c - '0';

            for (int factor : factors[digit]) {

                if (factor == 2) count[0]++;
                else if (factor == 3) count[1]++;
                else if (factor == 5) count[2]++;
                else if (factor == 7) count[3]++;
            }
        }

        return count;
    }

    static int countFactor(int digit, int index) {

        int target = primes[index];
        int count = 0;

        for (int factor : factors[digit]) {

            if (factor == target) {
                count++;
            }
        }

        return count;
    }

    static void removeFactors(int[] count, int digit) {

        for (int factor : factors[digit]) {

            if (factor == 2) {
                count[0]--;
            } else if (factor == 3) {
                count[1]--;
            } else if (factor == 5) {
                count[2]--;
            } else if (factor == 7) {
                count[3]--;
            }
        }
    }

    static int[] getFactorCount(int[] count) {

        int[] result = new int[10];

        int count8 = count[0] / 3;
        int remaining2 = count[0] % 3;

        int count9 = count[1] / 2;
        int count3 = count[1] % 2;

        int count4 = remaining2 / 2;
        int count2 = remaining2 % 2;

        int count6 = 0;

        if (count2 == 1 && count3 == 1) {

            count2 = 0;
            count3 = 0;
            count6 = 1;
        }

        if (count3 == 1 && count4 == 1) {

            count2 = 1;
            count6 = 1;
            count3 = 0;
            count4 = 0;
        }

        result[2] = count2;
        result[3] = count3;
        result[4] = count4;
        result[5] = count[2];
        result[6] = count6;
        result[7] = count[3];
        result[8] = count8;
        result[9] = count9;

        return result;
    }

    static boolean isSubset(int[] need, int[] have) {

        for (int i = 0; i < 4; i++) {

            if (have[i] < need[i]) {
                return false;
            }
        }

        return true;
    }

    static int sum(int[] count) {

        int ans = 0;

        for (int i = 0; i < count.length; i++) {
            ans += count[i];
        }

        return ans;
    }

    static String construct(int[] count) {

        StringBuilder ans = new StringBuilder();

        for (int digit = 2; digit <= 9; digit++) {

            ans.append(
                String.valueOf(digit).repeat(count[digit])
            );
        }

        return ans.toString();
    }
}