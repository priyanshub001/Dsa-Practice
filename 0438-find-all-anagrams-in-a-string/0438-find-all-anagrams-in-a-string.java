class Solution {
    public List<Integer> findAnagrams(String s, String p) {
       
    //  List<Integer> l = new ArrayList<>();

    //  int scount[] = new int[26];
    //  int pcount[] = new int[26];

    //  for(char c : p.toCharArray()){

    //     pcount[c-'a']++;
    //  }

    //  int n = p.length();

    //  for(int i=0; i<s.length(); i++){

    //     scount[s.charAt(i)-'a']++;

    //     if(i>=n){
    //         scount[s.charAt(i-n)-'a']--;
    //     }

    //     if(Arrays.equals(scount,pcount)){
    //         l.add(i-n+1);
    //     }



    //  }

    //  return l;


    HashMap <Character, Integer> map1 = new HashMap<>();
    List <Integer > ans = new ArrayList<>();

    for(char ch : p.toCharArray()){

        map1.put(ch,map1.getOrDefault(ch,0)+1);
    }

    int n = p.length();
    int l = 0;

     HashMap<Character , Integer> map2 = new HashMap<>();
    for(int i = 0; i<s.length(); i++){

        char ch = s.charAt(i);
        map2.put(ch,map2.getOrDefault(ch,0)+1);

        if(i >= n){
            char remove = s.charAt(l);
            map2.put(remove,map2.get(remove)-1);
            l++;

            if (map2.get(remove) == 0) {
             map2.remove(remove);
        }

        }



        if(map1.equals(map2) && i >= n-1) {
            ans.add(l);
        };




    }

    return ans;


    }
}