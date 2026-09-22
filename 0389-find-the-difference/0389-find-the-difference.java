class Solution {
    public char findTheDifference(String s, String t) {
        // Store frequency of characters in t
        Map<Character, Integer> count = new HashMap<>();

        for (char c : t.toCharArray()) {
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        // Remove characters present in s
        for (char c : s.toCharArray()) {

            count.put(c, count.get(c) - 1);

            // Remove entry if frequency becomes 0
            if (count.get(c) == 0) {
                count.remove(c);
            }
        }

        // Only one character remains 
        return (char) count.keySet().toArray()[0];   
    }
}