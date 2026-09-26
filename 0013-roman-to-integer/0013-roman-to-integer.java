class Solution {
    public int romanToInt(String s) {
         int res = 0;

        Map<Character, Integer> roman = new HashMap<>();

        roman.put('I', 1);
        roman.put('V', 5);
        roman.put('X', 10);
        roman.put('L', 50);
        roman.put('C', 100);
        roman.put('D', 500);
        roman.put('M', 1000);

        for(int i=0; i<s.length()-1; i++){
            int curr= roman.get(s.charAt(i));
            int next = roman.get(s.charAt(i+1));

            if(curr < next){
                res -= curr;
            } else {
                res += curr;
            }
        }

        return res + roman.get(s.charAt(s.length()-1));
    }
}