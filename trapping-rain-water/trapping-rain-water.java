class Solution {
    public int trap(int[] height) {
        if(height==null || height.length==0) return 0;
        int n = height.length;
        int low=0, high=n-1;
        int water = 0;
        int leftMax= height[low], rightMax=height[high];
        while(low<=high){
            if(height[low]<height[high]){
                if(height[low]>leftMax){
                    leftMax=height[low];
                }else{
                    water= water+leftMax-height[low];
                }
                low++;
            }else{
                if(height[high]>rightMax){
                    rightMax=height[high];
                }else{
                    water= water+rightMax-height[high];
                }
                high--;
            }
        }
        return water;
    }
}