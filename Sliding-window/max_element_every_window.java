public class max_element_every_window {
    
    public static int[] maxElement(int arr[], int k){

        int n=arr.length;

        int res[] = new int[n-k+1];
        // int max=Integer.MIN_VALUE;


        for(int i=0; i<n-k+1; i++){

            int max=arr[i];

             for (int j=i; j<i+k; j++) {
                if (arr[j] > max) {
                    max = arr[j];
                }
            }
            res[i]=max;

        }

    

        return res;
    }
    public static void main(String[] args) {

        int arr[] = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        int result[] = maxElement(arr, k);

        for (int k : result) {
            System.out.print(k + " ");
        }
    }
}
