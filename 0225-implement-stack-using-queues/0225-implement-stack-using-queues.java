class MyStack {

    LinkedList<Integer> q;

    public MyStack() {

        q = new LinkedList<>();
        
    }
    
    public void push(int x) {


        q.offer(x);
        
        
    }
    
    public int pop() {
    //   int rear = ((LinkedList<Integer>) q).removeLast();
      return  q.removeLast();
    }
    
    public int top() {
        // int rear = ((LinkedList<Integer>) q).getLast();
        return q.getLast();
    }
    
    public boolean empty() {
        return q.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */