class MinStack {

    Stack <Integer> s;
    Stack <Integer> formin;

    public MinStack() {

        
        s = new Stack<>();
        formin = new Stack<>();
    }
    
    public void push(int value) {

        s.push(value);

        if(formin.isEmpty() || value <= formin.peek()){
            formin.push(value);
        }



        
    }
    
    public void pop() {

       
        

            if(s.peek().equals(formin.peek())){
                formin.pop();
            }

                s.pop();
    


        
        
    }
    
    public int top() {
        return s.peek();
    }
    
    public int getMin() {
        return formin.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */