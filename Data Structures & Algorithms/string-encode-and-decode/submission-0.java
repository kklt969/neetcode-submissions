class Solution {

    public String encode(List<String> strs) {
    
        StringBuilder sb = new StringBuilder();

    for(String word : strs){

        sb.append(word.length());
        sb.append("#");
        sb.append(word);
    }

    return sb.toString();
    
    }

    public List<String> decode(String str) {

        List<String> result = new ArrayList<>();

        int i = 0;
        while( i < str.length()) {

            int length = 0;


            while(str.charAt(i) != '#'){
                length = length * 10 + (str.charAt(i) - '0');
                i++;
            }

            i = i+1;
            String word = str.substring(i, i+length);
            result.add(word);

            i = i + length;

        }
        return result;

    }
}
