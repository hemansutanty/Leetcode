class Solution {
    public int search(int[] nums, int target) {
        int length = nums.length;
        int start=0, end = length-1;
        while(start<end){
            int mid = (start+end)/2;
            if(nums[mid]>nums[end])start=mid+1;
            else end=mid;
        }
        //start=end = the pivot 
        int pivot = start;
        if(nums[pivot]==target) {return pivot;}
        start = target<=nums[length-1]?pivot:0;
        end = target>nums[length-1]?pivot:length-1;
        while(start<=end){
            int mid = (start+end)/2;
            if(nums[mid]==target)return mid;
            else if(nums[mid]<target) start=mid+1;
            else end=mid-1;
        }
        return -1;
    }
}