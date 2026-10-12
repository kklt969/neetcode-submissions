class Solution {

    /*
        #3bad#4abc

    */

    public String encode(List<String> strs) {


        StringBuffer encoded_string = new StringBuffer("");
        for(int i = 0 ; i < strs.size() ; i++){

            String str = strs.get(i);

            int strLength = str.length();

            encoded_string.append(strLength)
                            .append('#')
                            .append(str);


        }
        
        return encoded_string.toString();


    }

    public List<String> decode(String str) {

        List<String> decoded_strs = new ArrayList<>();

        int i = 0;
        while(i < str.length()){

           int length = 0;

           while(str.charAt(i) != '#'){

            length = length * 10 + (str.charAt(i) - '0');
            i++;

           }
           i= i+1;
           String word = str.substring(i,i+length);
           decoded_strs.add(word);

           i = i+length;


        }

        return decoded_strs;


    }
}
