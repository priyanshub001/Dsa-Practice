class Solution {
    public List<Integer> getRow(int rowIndex) {
    //    List< List<Integer>> ans = new ArrayList<>();

    //     for(int i = 0; i<=rowIndex; i++){

    //         List<Integer > row = new ArrayList<>();

    //         for(int j = 0; j <=i; j++ ){

    //             if(j==0 || j == i){
    //                 row.add(1);
    //             }else{

    //                 List<Integer > prv = ans.get(i-1);

    //                 row.add(prv.get(j-1) + prv.get(j));

    //             }
    //         }

    //         ans.add(row);
    //     }




    //     return ans.get(rowIndex);


    List <Integer> ans = new ArrayList<>();

    ans.add(1);

    for(int i = 1; i<= rowIndex; i++){

        ans.add(1);

        for(int j = i-1; j > 0; j--){

            ans.set(j,ans.get(j)+ans.get(j-1));

        }
    }
    return ans;


        

        
    }
}