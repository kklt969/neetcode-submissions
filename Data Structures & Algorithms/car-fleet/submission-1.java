class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        
        /*
    Approach:
    I created a 2D array to store each car's position and speed together.
    I sorted the cars by position in descending order so I can process
    them from closest to the target to farthest. For each car, I calculate
    its time to reach the target. I use a stack to store the arrival time
    of each fleet. If the current car's arrival time is less than or equal
    to the fleet ahead, it catches that fleet and joins it. Otherwise, it
    forms a new fleet and its time is pushed onto the stack.

    Key Insight:
    A car can only catch the fleet directly in front of it. If its arrival
    time is less than or equal to the fleet ahead, it will eventually catch
    that fleet because cars cannot pass each other.

    Edge Cases:
    If there are no cars, the stack remains empty and the answer is 0.
    If there is only one car, it forms one fleet.
    Cars that never catch another fleet remain as separate fleets.

    Time & Space Complexity:
    Sorting takes O(n log n) time and processing the cars takes O(n),
    so the overall time complexity is O(n log n).
    The 2D array and stack use O(n) space.
*/




        int[][] cars = new int[position.length][2];

        for(int i = 0; i < position.length; i++)
        {
             cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }
        

        Arrays.sort(cars,(a,b) ->Integer.compare(b[0], a[0]));

        Stack<Double> stack = new Stack<>();

        

        for(int i = 0 ; i < position.length; i ++){

            double time =(double) ( target - cars[i][0]) / cars[i][1];

           if(stack.isEmpty() || time > stack.peek()){
            stack.push(time);
           }


        }

      
        return stack.size();


    }
    
}
