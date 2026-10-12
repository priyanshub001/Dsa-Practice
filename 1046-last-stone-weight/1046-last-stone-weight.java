class Solution {
    public int lastStoneWeight(int[] stones) {

        PriorityQueue <Integer> p = new PriorityQueue<>(Collections.reverseOrder());

        for(int n :stones){
            p.offer(n);
        }

        while(p.size() > 1){
            int a = p.poll();
            int b = p.poll();

            if(a!=b){
                p.offer(a-b);
            }
        }
        
        return p.isEmpty() ? 0 : p.peek();

    }
}