class MinStack {

    /*
        Approach : I used two arrayLists : One to store the actual stack values and another to sotre the minmum value at each stage of the stack. Whenever I push a value, I compare it with previous minimum and value becomes last current minimum if it is smaller in the mins list.

        KeyInsight : The mins list keeps track of the minimum at every stack level. Therefore, the current minimum is alwasy the last value in mins. 
        so getMin() can retrieve it in O(1) time without searching.

        Time&Space Compexity : all operations is O(1) time complexity with O(n) space. 

        Edge cases : if the stack is empty : first value is put as minimum value.


    */


      ArrayList<Integer> values = new ArrayList<>();

    ArrayList<Integer> mins = new ArrayList<>();


    public MinStack() {
        
      

    }
    
    public void push(int val) {

        values.add(val);

        if(mins.isEmpty()){
            mins.add(val);
        }

        else{
            int prevMin = mins.get(mins.size()-1);
            if(val < prevMin){
                mins.add(val);
            }
            else{
                mins.add(prevMin);
            }
        }
       
    }
    
    public void pop() {

        int lastIndex = values.size() - 1;
        values.remove(lastIndex);
        mins.remove(lastIndex);
        
    }
    
    public int top() {

        int top = values.get(values.size() - 1);
        return top;
        
    }
    
    public int getMin() {
        
        return mins.get(mins.size() - 1);
    }
}
