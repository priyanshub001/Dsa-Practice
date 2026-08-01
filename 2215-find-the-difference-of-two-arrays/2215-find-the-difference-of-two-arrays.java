class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {

        List<List<Integer>> res = new ArrayList(2);

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for(int n: nums1){
            set1.add(n);
        }

        for(int n: nums2){
            set2.add(n);
        }


        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        for(int n:set1){
            if(!set2.contains(n)){
                list1.add(n);
            }
        }

        for(int n:set2){
            if(!set1.contains(n)){
                list2.add(n);
            }
        }
        res.add(list1);
        res.add(list2);

        return res;


        
    }
}