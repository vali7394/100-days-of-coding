package com.learning.binarysearch;

import java.util.*;
import java.util.stream.Collectors;

/*
Given a string array words, return an array of all characters that show up in all strings within the words (including duplicates). You may return the answer in any order.



Example 1:

Input: words = ["bella","label","roller"]
Output: ["e","l","l"]
Example 2:

Input: words = ["cool","lock","cook"]
Output: ["c","o"]
 */
public class FindCmnChars {
    public static void main(String[] args) {
        System.out.println(commonChars(new String[]{"bella","label","roller"}));
    }
    public static List<String> commonChars(String[] words) {

        if(words==null || words.length==0){
            return Collections.emptyList();
        }
        int[] min_freq_tracker = new int[26];
        Arrays.fill(min_freq_tracker,Integer.MAX_VALUE);

        for(String word : words) {
            int[] word_freq_tracker = new int[26];
            for(char c : word.toCharArray()) {
                word_freq_tracker[c-'a']++;
            }
            for(int i=0; i<26; i++) {
                min_freq_tracker[i] = Math.min(min_freq_tracker[i],word_freq_tracker[i]);
            }
        }

        List<String> result = new ArrayList<>();

        for(int i=0; i<26 ; i++){
            int j = min_freq_tracker[i];
            while(j>0){
                result.add(String.valueOf((char)(i+'a')));
                j--;
            }
        }
        return result;
    }
}
