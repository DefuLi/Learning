package leetcode;

// 寻找比目标数组大的最小字母
public class NextGreatestLetter {
    public static void main(String[] args) {
        char[] letters = {'e', 'e', 'e', 'k', 'q', 'q', 'q', 'r'};
        char target1 = 'q';

        NextGreatestLetter obj = new NextGreatestLetter();
        System.out.println(obj.nextGreatestLetter(letters, target1));  // c
    }
    // 'a'-'z': 97-122

    /**
     * 二分查找
     * @param letters
     * @param target
     * @return
     */
    public char nextGreatestLetter(char[] letters, char target) {
        if(target < letters[0] || target >= letters[letters.length - 1]) return letters[0];
        if(target == letters[0]) {
            for (int i = 0; i < letters.length; i++) {
                if(target != letters[i]) return letters[i];
            }
        }
        int start = 0;
        int end = letters.length - 1;
        while (start <= end) {
            int mid = (end - start) / 2 + start;
            if(letters[mid] == target) {
                start = mid;
                break;
            }else if(letters[mid] < target) {
                start = mid + 1;
            }else if(letters[mid] > target) {
                end = mid - 1;
            }
        }
        char temp = letters[start];
        if(letters[start] == target) {
            for (int i = start + 1; i < letters.length; i++) {
                if(letters[i] != temp) return letters[i];
            }
        }
        return letters[start];
    }
}
