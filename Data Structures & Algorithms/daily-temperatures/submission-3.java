class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        
        /*
            Approach : I used stack to stores the index of the day that are waiting for a higher temperature. If there is a higher temperature for the index at the top of stack, I calculate waitingdays and pop(), then repeatedly doing with the remaining elements in stack using while loop.

            Key Insight : Monotonic stack : store indies of unresolved elements. When a new element makes at the top of the stack resolvable, repeatedly pop and process untill the top can no longer be resolved. 

           Edge Cases: If the stack is empty, the current index is simply pushed.
Any indices remaining in the stack at the end never find a warmer
temperature, so their answers remain 0.

Time & Space Complexity: Time: O(n), because each index is pushed and popped at most once.
Space: O(n) for the stack and result array.

        */



        int[] result = new int[temperatures.length];

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < temperatures.length; i++){

           while(!stack.isEmpty() && (temperatures[i] > temperatures[stack.peek()])){

                int waitingDays = i - stack.peek();
                
                result[stack.peek()] = waitingDays;

                stack.pop();

            
           }
           stack.push(i);

        }

     
       
        return result;

    }
}
