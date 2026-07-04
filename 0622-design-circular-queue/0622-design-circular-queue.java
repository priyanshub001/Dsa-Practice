class MyCircularQueue {

    int arr[];
    int front = -1;
    int rear = -1;
    int size = 0;
    int capacity = 0;

    public MyCircularQueue(int k) {

        arr = new int[k];
        capacity = k;
        
    }
    
    public boolean enQueue(int value) {
        if(size==capacity){
          return false;
        }

        if(size==0){
            front = 0;
            rear = 0;
        }else{

        rear = (rear+1)%capacity;

        }

        arr[rear] = value;
        size++;

        return true;


      
    }
    
    public boolean deQueue() {
        
        if(size==0){
            return false;
        }

        if(size == 1){
            front = -1;
            rear  = -1;
            size--;
            return true;
        }
        else{
            front = (front+1)%capacity;
            size--;
            return true;
        }

       


    }
    
    public int Front() {

        if(size == 0){
            return -1;
        }

        return arr[front];

     
    }
    
    public int Rear() {
        if(size == 0){
            return -1;
        }

        return arr[rear];
    }
    
    public boolean isEmpty() {

        return size==0;
        
    }
    
    public boolean isFull() {

        return size == capacity;
        
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */