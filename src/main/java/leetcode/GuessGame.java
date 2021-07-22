package leetcode;

// 猜数字大小

public class GuessGame {
    /* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

    /**
    public class Solution extends GuessGame {
        public int guessNumber(int n) {
            int start = 1;
            int end = n;
            while(start <= end) {
                int mid = (end - start) / 2 + start;
                int com = guess(mid);
                if(com == -1){  // mid大
                    end = mid - 1;
                }else if(com == 1){  // mid小
                    start = mid + 1;
                }else{  // 相等
                    return mid;
                }
            }
            return start;
        }
    }
     */
}
