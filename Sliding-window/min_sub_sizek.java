public class min_sub_sizek {
    

    public static int findmin(int arr[], int k){
        int window=0;
        int min=Integer.MAX_VALUE;

        for (int i=0; i<k; i++){
            window+=arr[i];
        }
        min=window;

        for(int i=k; i<arr.length; i++){

            window += arr[i]-arr[i-k];
            min=Math.min(min, window);
        }

        return min;

    }

    public static void main(String[] args) {
        
       int arr[] = {2,5,1,8,2,9,1};
       int k = 3;

       System.out.println(findmin(arr, k));

    }
}
