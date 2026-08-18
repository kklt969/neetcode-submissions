class Solution {

    /*
    
        Approach : I use a stack to keep track of opening brackets. When I see an opening bracket I push it to stack. When I see a closing bracket I compare it with the character top of the stack, pop the top of the stack if it matches. Return false if it does not.

        Key Insight : The stack works because brackets need to be closed in reserved of how they were opened , which is LIFO


        Complexity: 
                    Time: O(n) because I iterated through the string once.
                    Space: O(n) because stack can contain up to n opening bracket.

        Edge Cases: If I encounter a closing bracket when the stack is empty, it is invalid. At the end, the stack must also be empty.



    */


    public boolean isValid(String s) {
        
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length() ; i++){

            char c = s.charAt(i);

            if(c == '(' || c == '{' || c == '['){

                stack.push(c);
                continue;
            }

            if(stack.isEmpty()){
                return false;
            }

            char top = stack.peek();

            if( (top == '(' && c == ')') || (top == '{' && c == '}') || (top == '[' && c == ']')  ){

                stack.pop();

            }
            else{
                return false;
            }
            
            

        }

        return stack.isEmpty(); // Matches when the whole stack is empty. 



    }
}
