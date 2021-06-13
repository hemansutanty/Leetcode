class Number implements Comparable<Number>{
    public int number;
    public int index;
    public Number(int number, int index){
        this.number=number;
        this.index=index;
    }
    public int compareTo(Number number){
        return this.number-number.number;
    }
}
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        int length = nums.length;
        Number[] numbers = new Number[length]; 
        for(int i=0;i<length;i++){
            numbers[i] = new Number(nums[i], i);
        }
        Arrays.sort(numbers);
        
        int i = 0, j = length-1;
        while(i<j){
            if (numbers[i].number+numbers[j].number==target){
                result[0]=numbers[i].index;result[1]=numbers[j].index;
                break;
            }else if(numbers[i].number+numbers[j].number>target){
                j--;
            }else{
                i++;
            }
        }
        return result;
    }
}