class Solution {

  


    public boolean isValid(String s) {
        
        Stack<Character> stack = new Stack<>();

     
        if(s.length() == 1){
            return false;
        }

        for(int i = 0; i < s.length(); i++){

            char bracket = s.charAt(i);
            if(bracket == '[' || bracket == '(' || bracket == '{')
            {
                stack.push(bracket);
                continue;

            }

             if(stack.isEmpty()){
                return false;
            }
                
                    char opening = stack.peek();

                    if( (opening == '[' &&  bracket == ']') || (opening == '{' && bracket == '}') ||           (opening == '(' && bracket == ')') ){

                        stack.pop();
                    }
                    else{
                        return false;
                    }
            

            

        }
        return stack.isEmpty();



    }
    
}
