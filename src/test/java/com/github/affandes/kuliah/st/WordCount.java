// Perbaikan pada WordCount.java
package com.github.affandes.kuliah.st;

import java.util.ArrayList;
import java.util.List;

public class WordCount {

    public List<WordInfo> wordCount;

    public WordCount() {
        wordCount = new ArrayList<>();
    }

    public void processText(String text) {
        for (String word : text.split(" ")) {
            addWord(word);
        }
    }

    public void addWord(String word) {
        WordInfo found = wordCount.stream().filter(w -> w.word.equals(word)).findFirst().orElse(null);
        if (found == null) {
            wordCount.add(new WordInfo(word, 1));
        } else {
            found.count += 1;
        }
    }

    public List<WordInfo> getWordCounts() {
        return wordCount;
    }

    public static class WordInfo {
        public String word;
        public int count;

        public WordInfo(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }
}
