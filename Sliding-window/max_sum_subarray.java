public class max_sum_subarray {

    public static int Maxsumarray(int arr[],int k){

        int window=0;
        int maxsum=0;

        if(arr == null || arr.length < k){
         return 0;
         }

        for(int p=0; p<k; p++){
            window+=arr[p];
        }

        maxsum=window;

        for(int p=k; p<arr.length; p++){

            window+=arr[p]-arr[p-k];
            maxsum=Math.max(maxsum, window);
        }

        return maxsum;


    }

    public static void main(String[] args) {
        
        int arr[]={};
        int k=3;

       System.out.println(Maxsumarray(arr, k)); 
    }
}