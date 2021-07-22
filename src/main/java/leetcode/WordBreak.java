package leetcode;

import java.util.ArrayList;
import java.util.List;

// 单词拆分
public class WordBreak {
    public static void main(String[] args) {
        String s = "applepenapple";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("apple");
        wordDict.add("pen");
        WordBreak obj = new WordBreak();
        System.out.println(obj.wordBreak(s, wordDict));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        return false;
    }
}
