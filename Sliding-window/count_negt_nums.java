public class count_negt_nums {
    public static int[] count_negative_nums(int arr[], int k){

        int n = arr.length;

        int res[] = new int[n-k+1];

        for(int i=0; i<=n-k; i++){

            int found=0;

            for(int j=i; j<i+k; j++){

                if (arr[j]<0) {
                    found=arr[j];
                    break;
                }
            }

            res[i]=found;
        }


        return res;
    }

    public static void main(String[] args) {
        
        int arr[] = {12, -1, -7, 8, -15, 30, 16, 28};
        int k = 3;

        int result[] = count_negative_nums(arr, k);

        for (int val : result) {
            System.out.print(val + " ");
        }
    }
}
