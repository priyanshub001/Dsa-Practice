class Solution {
    public int[] arrayRankTransform(int[] arr) {

        int temp[] = arr.clone();
        HashMap<Integer,Integer> map = new HashMap<>();

        Arrays.sort(temp);

        int rank = 1;

        for(int a : temp){
            if(!map.containsKey(a)){
            map.put(a,rank);
            rank++;

            }
        }

        for(int i = 0; i<arr.length; i++){
            arr[i] = map.get(arr[i]);
        }
        
        return arr;
    }
}