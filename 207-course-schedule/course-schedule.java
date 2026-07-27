import java.util.*;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Step 1: Create the adjacency list and in-degree array
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        
        int[] inDegree = new int[numCourses];
        
        // Step 2: Build the graph
        // prerequisites[i] = [a, b] means b -> a (b must be taken before a)
        for (int[] pair : prerequisites) {
            int course = pair[0];
            int prereq = pair[1];
            adj.get(prereq).add(course);
            inDegree[course]++;
        }
        
        // Step 3: Add all courses with 0 in-degree (no prerequisites) to the queue
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        
        // Step 4: Process the queue and track how many courses can be completed
        int completedCoursesCount = 0;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            completedCoursesCount++;
            
            // Reduce the in-degree of neighboring courses
            for (int neighbor : adj.get(current)) {
                inDegree[neighbor]--;
                // If a neighbor has no more dependencies, add it to the queue
                if (inDegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }
        
        // Step 5: If we successfully processed all courses, there is no cycle
        return completedCoursesCount == numCourses;
    }
}
