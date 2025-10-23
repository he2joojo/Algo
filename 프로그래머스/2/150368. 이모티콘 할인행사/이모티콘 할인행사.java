class Solution {

    static int n;
    static int[] discounts = { 10, 20, 30, 40 };

    static int subscribers;
    static int sales;

    public int[] solution(int[][] users, int[] emoticons) {

        // 1. 초기 세팅
        n = emoticons.length;
        subscribers = 0;
        sales = 0;

        // 2. 로직
        getComb(users, emoticons, new int[n], 0);

        // 3. 반환
        return new int[] { subscribers, sales };
    }

    static void getComb(int[][] users, int[] emoticons, int[] percents, int idx) {

        if (idx == n) {
            calculate(users, emoticons, percents);
            return;
        }

        for (int d : discounts) {
            percents[idx] = d;
            getComb(users, emoticons, percents, idx + 1);
        }
    }

    static void calculate(int[][] users, int[] emoticons, int[] percents) {

        int join = 0;
        int sale = 0;

        for (int[] user : users) {
            int minDiscount = user[0];
            int joinPrice = user[1];

            int sum = 0;

            for (int i = 0; i < n; i++) {
                if (minDiscount <= percents[i]) {
                    int tmp = emoticons[i] * (100 - percents[i]) / 100;
                    sum += tmp;
                }
            }

            if (joinPrice <= sum) {
                join++;
            } else {
                sale += sum;
            }
        }

        if (subscribers < join) {
            subscribers = join;
            sales = sale;
        } else if (subscribers == join && sales < sale) {
            sales = sale;
        }
    }
}
