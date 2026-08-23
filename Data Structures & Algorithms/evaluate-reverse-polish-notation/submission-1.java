class Solution {
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
