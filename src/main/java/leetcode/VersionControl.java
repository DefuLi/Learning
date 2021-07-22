package leetcode;

// 第一个错误的版本
public class VersionControl {

     /* The isBadVersion API is defined in the parent class VersionControl.
     boolean isBadVersion(int version); */
    /**
    public class Solution extends VersionControl {
        public int firstBadVersion(int n) {
            int start = 1;
            int end = n;
            while(start < end) {
                int mid = (end - start) / 2 + start;
                if(isBadVersion(mid)) { // 该版本为true
                    end = mid;
                }else {  // 该版本为false
                    start = mid + 1;
                }
            }
            return end;
        }
    }
    */
}
