package coding.backTracking;


//  https://www.geeksforgeeks.org/problems/permutations-of-a-given-string2041/1
//  Given a string S. The task is to print all unique permutations of the given string
//  that may contain duplicates in lexicographically sorted order.
//  Expected Time Complexity: O(n! * n)
//  Expected Space Complexity: O(n! * n)

import java.util.*;

class A6PermutationofStrings6 {

    public static void main(String[] args) {
        find_permutation("aab").forEach(System.out::println);
    }

    public static List<String> find_permutation(String S) {
        List<String> output = new ArrayList<>();
        // Code here

        permute(S, "", output);
        Collections.sort(output);
        return output;
    }

    public static void permute(String s, String ans, List<String> output) {
        if (s.isEmpty()) {
            output.add(ans);
            return;
        }
        Set<Character> hs = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (hs.contains(s.charAt(i))) {
                return;
            }
            hs.add(s.charAt(i));
            permute(s.substring(0, i) + s.substring(i + 1), ans + s.charAt(i), output);
        }

    }
}