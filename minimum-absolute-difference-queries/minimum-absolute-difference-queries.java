class Solution {
    public int[] minDifference(int[] nums, int[][] queries) {
        // create the dp table
        int[][] dpTable  = new int[nums.length+1][100];
        //fill up the dp table
        for(int i=0;i<nums.length;i++){
            for(int j = 0; j < 100; ++j)
                dpTable[i + 1][j] = dpTable[i][j];
            ++dpTable[i + 1][nums[i] - 1];
        }
        // create result array
        int[] result = new int[queries.length];
        //fill result array
        for(int i=0;i<queries.length;i++){
            List<Integer> numbersList = new ArrayList<>();
            int low = queries[i][0];
            int high = queries[i][1] + 1;
            //fill array consecutively for the cases
            int min = 100;
            
            for(int j = 0; j < 100; ++j)
                if(dpTable[high][j] - dpTable[low][j] != 0)
                    numbersList.add(j);
            for(int j = 1; j < numbersList.size(); ++j)
                min = Math.min(min, numbersList.get(j) - numbersList.get(j - 1));
            
            if(numbersList.size() == 1)
                min = -1;
            
            result[i] = min;
        }
        return result;
    }
}