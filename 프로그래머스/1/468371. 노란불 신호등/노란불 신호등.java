class Solution {

    public int gcd(int a, int b) {

        while (b != 0) {

            int temp = a % b;

            a = b;
            b = temp;
        }

        return a;
    }

    public int lcm(int a, int b) {

        return a * b / gcd(a, b);
    }

    public int solution(int[][] signals) {

        int totalCycle = 1;

        for (int i = 0; i < signals.length; i++) {

            int green = signals[i][0];
            int yellow = signals[i][1];
            int red = signals[i][2];

            int cycle = green + yellow + red;

            totalCycle = lcm(totalCycle, cycle);
        }

        for (int time = 1; time <= totalCycle; time++) {

            boolean allYellow = true;

            for (int i = 0; i < signals.length; i++) {

                int green = signals[i][0];
                int yellow = signals[i][1];
                int red = signals[i][2];

                int cycle = green + yellow + red;

                int current = time % cycle;

                if (current == 0) {

                    current = cycle;
                }

                boolean isYellow =
                        current > green &&
                        current <= green + yellow;

                if (!isYellow) {

                    allYellow = false;
                    break;
                }
            }

            if (allYellow) {

                return time;
            }
        }

        return -1;
    }
}