public class SortColors {

    // public void sortColors(int[] nums) {
    //     int zero = 0, one = 0, two = 0;

    //     for (int i = 0; i < nums.length; i++) {             
    //         if (nums[i] == 0) zero++;
    //         else if (nums[i] == 1) one++;                         O(n)
    //         else two++;                                         better soln.
    //     }

    //     for (int i = 0; i < nums.length; i++) {
    //         if (zero > 0) {
    //             nums[i] = 0;
    //             zero--;
    //         } else if (one > 0) {
    //             nums[i] = 1;
    //             one--;
    //         } else {
    //             nums[i] = 2;
    //             two--;
    //         }
    //     }
    // }

     //                                                            O(n)
     //                                                 Duch national flag algo.   
     public void sortColors(int[] nums) {
        int low=0,high=nums.length-1,mid=0;
        for(int i=0 ; i<nums.length ; i++)
        {
            if(nums[mid]==0){
                // Swap nums[low] and nums[mid]
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                 low++;
                 mid++;
            }
            else if(nums[mid]==1){
                mid++;
            }

            else{
               // Swap nums[mid] and nums[high]
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;
                high--;
            }
        }
        
    } 

    public static void main(String[] args) {
        SortColors sorter = new SortColors();

        int[] nums = {2, 0, 2, 1, 1, 0};
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();

        sorter.sortColors(nums);

        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    
}
