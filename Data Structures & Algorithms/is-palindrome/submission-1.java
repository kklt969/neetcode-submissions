class Solution {
    public boolean isPalindrome(String s) {
       
        /*

 Approach:
    Use two pointers, i and j. i starts from the beginning
    and j starts from the end. Skip non-alphanumeric characters
    and compare the characters from both ends while i < j.

    Key Insight:
    Use the two-pointer approach to compare characters from
    opposite ends while moving toward the center.

    Edge Cases:
    A string with one character is a palindrome.
    Strings containing only non-alphanumeric characters are
    also considered valid palindromes.

    Time Complexity: O(n)
    Space Complexity: O(1)


        */



        int i = 0;
        int j = s.length()-1;

        while(i < j){

        if(!Character.isLetterOrDigit(s.charAt(i))){
            i++;
            continue;
        }

         if(!Character.isLetterOrDigit(s.charAt(j))){
            j--;
            continue;
        }


          if (Character.toLowerCase(s.charAt(i)) !=
    Character.toLowerCase(s.charAt(j))) {
    return false;
}

            i++;
            j--;


        }
        return true;
    }
}
