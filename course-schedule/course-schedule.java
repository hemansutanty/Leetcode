class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses<=0) return false;
        List<Integer> courses = new ArrayList<>();
        Map<Integer, Integer> indegree = new HashMap<>();
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i=0;i<numCourses;i++){
            indegree.put(i,0);
            graph.put(i, new ArrayList<>());
        }
        
        for(int[] pre: prerequisites){
            int parent = pre[1], child = pre[0];
            graph.get(parent).add(child);
            indegree.put(child, indegree.get(child)+1);
        }
        Queue<Integer> sources = new LinkedList<>();
        for(Map.Entry<Integer,Integer> entry: indegree.entrySet()){
            if(entry.getValue()==0)sources.add(entry.getKey());
        }
        
        while(!sources.isEmpty()){
            int course = sources.poll();
            courses.add(course);
            List<Integer> children = graph.get(course);
            for(int child: children){
                indegree.put(child, indegree.get(child)-1);
                if(indegree.get(child)==0){
                    sources.add(child);
                }
            }
        }
        return courses.size()==numCourses ? true:false;
    }
}