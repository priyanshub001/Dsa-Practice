class Solution {
    public String getPermutation(int n, int k) {

        List <Integer> list = new ArrayList();
        int fact = 1;
        
        for(int i = 1; i <= n; i++){

            list.add(i);
        }

        for(int i = 1; i<n; i++){
            fact *= i;
            
        }

        k--;

        StringBuilder ans = new StringBuilder();

        while(!list.isEmpty()){

            int index = k/fact;
            int pk = list.get(index);

           ans.append(String.valueOf(pk));
           list.remove(index);

           k = k % fact;

           if(!list.isEmpty()){
           fact = fact / list.size();
           }
     
        }



        


        return ans.toString();


        
    }
}