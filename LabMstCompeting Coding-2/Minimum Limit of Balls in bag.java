class Solution {
    public boolean valid(int []nums,int maxOperations,int mid){
        long total=0;
        for(int i:nums){
            total+=(i-1)/mid;
        }
        return total<=maxOperations;
    }
    public int minimumSize(int[] nums, int maxOperations) {
        int l=1,r=0,ans=0;
        for(int i:nums){
            r=Math.max(i,r);
        }
        ans=r;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(valid(nums,maxOperations,mid)){
                ans=mid;
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return ans;
    }
}