public class twosum {
    public static int[] twosumm(int arr[], int target){
       
        int a=0;
        int b=arr.length-1;

        while (a>b) {

            int sum = arr[a]+arr[b];

            if (sum==target) {
                return new int[] {a,b};
            }
            else if (sum <target) {
                a++;
            }else{
                b--;
            }
            
        }

        return new int[]{-1,-1};

    }
    public static void main(String[] args) {
        
        int arr[] = {2,7,11,15};
        int t = 9;

        System.out.println(twosumm(arr, t));
    }
}
