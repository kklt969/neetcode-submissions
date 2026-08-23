class Solution {


    /*
        Approach:
I iterate through every token. If the token is a number, I push it
onto the stack. If it is an operator, I pop the top two numbers,
perform the operation, and push the result back onto the stack.

Key Insight:
When an operator appears, the top two values in the stack are the
two operands needed for that operation. The second value popped is
the first operand, which is important for subtraction and division.

Time & Space Complexity:
Time: O(n), because every token is processed once and stack operations
are O(1).
Space: O(n), because the stack can hold up to n values.

Edge Cases:
If there is only one token and it is a number, that number is the
answer. More generally, after processing all tokens, one result
remains on the stack.



    */





    public int evalRPN(String[] tokens) {
        
      Stack<Integer> stack = new Stack<>();

        int result = 0;

        if(tokens.length == 1){
            int r = Integer.parseInt(tokens[0]);
            return r;
        }

      for(String token : tokens){

        if (token.equals("+") ||
                token.equals("-") ||token.equals("*") ||
        token.equals("/")){

            int b = stack.pop();
            int a = stack.pop();

            result = switch (token) {
                    case "+" -> a + b;
                    case "-" -> a - b;
                    case "*" -> a * b;
                    case "/" -> a / b;
                    default -> 0;
                };
            
            stack.push(result);

        }
        else{
           
            int num = Integer.parseInt(token);
            stack.push(num);
        }

      }

      return result;


    }
        
}
