class MinStack {

    ArrayList<Integer> stack = new ArrayList<>();

    ArrayList<Integer> mins = new ArrayList<>();

    public MinStack() {
        
    }
    
    public void push(int val) {

        
        if(stack.size() >0){
            int min = mins.get(mins.size()-1);

            if(val < min){
                mins.add(val);
            }
            else{
                mins.add(min);
            }

        }
        else{
            mins.add(val);
        }
        stack.add(val);

        
        
    }
    
    public void pop() {

        stack.remove(stack.size()-1);
        mins.remove(mins.size()-1);
        
    }
    
    public int top() {
        return stack.get(stack.size()-1);
        
    }
    
    public int getMin() {

        return  mins.get(mins.size()-1);
        
    }
    
}
