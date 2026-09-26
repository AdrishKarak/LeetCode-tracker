class Solution {
    public int addDigits(int num) {
        while(num>9){
            int result=0;
            while(num !=0){
                int digit = num % 10;
                result += digit;
                num /= 10;
            }
            num = result;
        }
        return num;
    }
}

//Math Approach:
//Zero case: If num is 0, digital root is 0
//Multiple of 9: If num % 9 equals 0 (and num ≠ 0), digital root is 9
//General case: For all other numbers, digital root is num % 9
//Mathematical property: This works because repeatedly summing digits is equivalent to finding the remainder when divided by 9
//Constant time: No loops or recursion needed

//class Solution {
//public int addDigits(int num) {
//       if (num == 0)
//       return 0;
//       if (num % 9 == 0)
//       return 9;
//       return num % 9;
//        }
//     }
