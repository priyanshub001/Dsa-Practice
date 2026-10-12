class KthLargest {

    PriorityQueue<Integer> p = new PriorityQueue<>();
    int  k = 0;

    public KthLargest(int k, int[] nums) {

        this.k = k;

        for(int n: nums){
            p.offer(n);

            if(p.size() > k) p.poll();
        }

        
    }
    
    public int add(int val) {
        
      p.offer(val);
      if(p.size() > k) p.poll();

      return p.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */