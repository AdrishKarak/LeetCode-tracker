class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
         // Store frequency of each character in magazine
        HashMap<Character, Integer> magaHash = new HashMap<>();

        // Count frequencies
        for (char c : magazine.toCharArray()) {
            magaHash.put(c, magaHash.getOrDefault(c, 0) + 1);
        }

        // Try to construct ransomNote
        for (char c : ransomNote.toCharArray()) {

            // Character not present or exhausted
            if (!magaHash.containsKey(c) || magaHash.get(c) <= 0) {
                return false;
            }

            // Use one occurrence
            magaHash.put(c, magaHash.get(c) - 1);
        }

        return true;
    }
}