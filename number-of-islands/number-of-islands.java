class Solution {
    int[][] dirs ={{0,1},{0,-1},{1,0},{-1,0}};
    public int numIslands(char[][] grid) {
        if(grid==null || grid.length==0 || grid[0].length==0)return 0;
        int islands =0;
        int rows = grid.length, columns=grid[0].length;
        boolean[][] visited = new boolean[rows][columns];
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                if(grid[i][j]=='1' && !visited[i][j]){
                    islands++;
                    dfs(grid,visited,i,j);
                }
            }
        }
        return islands;
    }

    public void dfs(char[][] grid, boolean[][] visited, int row, int column){
        if(row<0 || row>=grid.length || column<0 || column>=grid[0].length || visited[row][column]){
            return; 
        }
        visited[row][column]=true;
        if(grid[row][column]=='1'){
            for(int[] dir: dirs){
                dfs(grid,visited,row+dir[0], column+dir[1]);
            }
        }
    }
}