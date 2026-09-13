class Solution {
    public int largestRectangleArea(int[] heights) {
        
        Stack<Integer> stack = new Stack<>();
        int largestArea = 0;

        for (int i = 0; i < heights.length; i++) {

            while (!stack.isEmpty() &&
                   heights[i] < heights[stack.peek()]) {

                int height = heights[stack.pop()];

                int left = stack.isEmpty() ? -1 : stack.peek();
                int width = i - left - 1;

                int area = height * width;
                largestArea = Math.max(largestArea, area);
            }

            stack.push(i);
        }

        // Process bars that never found a smaller bar on the right
        while (!stack.isEmpty()) {

            int height = heights[stack.pop()];

            int left = stack.isEmpty() ? -1 : stack.peek();
            int width = heights.length - left - 1;

            int area = height * width;
            largestArea = Math.max(largestArea, area);
        }

        return largestArea;

    }
}
