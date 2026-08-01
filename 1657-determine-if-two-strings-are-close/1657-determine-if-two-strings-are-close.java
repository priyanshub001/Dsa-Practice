class Solution {
    public boolean closeStrings(String word1, String word2) {
        
        HashMap<Character , Integer> map1 = new HashMap<>();
        HashMap<Character , Integer> map2 = new HashMap<>();

        for(char ch : word1.toCharArray()){

            map1.put(ch,map1.getOrDefault(ch,0)+1);
        }

        for(char ch : word2.toCharArray()){

            map2.put(ch,map2.getOrDefault(ch,0)+1);
        }

        // HashSet<Character> set1 = new HashSet<>();
        // HashSet<Character> set2 = new HashSet<>();

        // for(char ch : word1.toCharArray()){
        //     set1.add(ch);
        // }

        // for(char ch : word2.toCharArray()){
        //     set2.add(ch);
        // }

    //    for(char ch : set1){

    //     if(!set2.contains(ch)) return false;

    //    }

    // if(!set1.equals(set2)) return false;


    if(!map1.keySet().equals(map2.keySet())) return false;

    List<Integer> list1 = new ArrayList<>(map1.values());
    List<Integer> list2 = new ArrayList<>(map2.values());

    Collections.sort(list1);
    Collections.sort(list2);

    if(!list1.equals(list2)) return false;

        return true;
    }
}