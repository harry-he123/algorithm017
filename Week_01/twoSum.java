public class twoSum {

        public int[] twoSum(int[] nums, int target) {
            int[] numsb=nums;
            int[] res= new int[2];
            for(int i=0;i<nums.length;i++){
                for(int j=0;j<numsb.length;j++){
                    if(nums[i]+numsb[j]==target){
                        res[0]=i;
                        res[1]=numsb[j];
                    }
                }
            }
            return res;
        }

}
