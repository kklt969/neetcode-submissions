
class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }

        Map<Character, Integer> need = new HashMap<>();

        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> window = new HashMap<>();

        int left = 0;
        int right = 0;
        int have = 0;
        int required = need.size();

        int minLength = Integer.MAX_VALUE;
        int minStart = 0;

        while (right < s.length()) {
            // 1. Expand the window
            char c = s.charAt(right);
            window.put(c, window.getOrDefault(c, 0) + 1);

            if (need.containsKey(c)
                    && window.get(c).intValue() == need.get(c).intValue()) {
                have++;
            }

            right++;

            // 2. Shrink while the window is valid
            while (have == required) {
                int length = right - left;

                // Record the shortest valid window
                if (length < minLength) {
                    minLength = length;
                    minStart = left;
                }

                char leftChar = s.charAt(left);

                // Will removing this character break validity?
                if (need.containsKey(leftChar)
                        && window.get(leftChar).intValue()
                        == need.get(leftChar).intValue()) {
                    have--;
                }

                window.put(leftChar, window.get(leftChar) - 1);
                left++;
            }
        }

        if (minLength == Integer.MAX_VALUE) {
            return "";
        }

        return s.substring(minStart, minStart + minLength);
    }
}
