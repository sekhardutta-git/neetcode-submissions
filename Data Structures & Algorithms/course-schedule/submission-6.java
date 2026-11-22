class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int[] p : prerequisites) {
            graph.computeIfAbsent(p[0], k -> new ArrayList<>())
                 .add(p[1]);
        }

        Set<Integer> visiting = new HashSet<>();
        Set<Integer> completed = new HashSet<>();

        for (int course = 0; course < numCourses; course++) {
            if (!dfs(course, graph, visiting, completed)) {
                return false;
            }
        }

        return true;
    }

    private boolean dfs(
            int course,
            Map<Integer, List<Integer>> graph,
            Set<Integer> visiting,
            Set<Integer> completed) {

        if (visiting.contains(course)) {
            return false; // Cycle detected
        }

        if (completed.contains(course)) {
            return true; // Already validated
        }

        visiting.add(course);

        for (int dependency : graph.getOrDefault(course, Collections.emptyList())) {
            if (!dfs(dependency, graph, visiting, completed)) {
                return false;
            }
        }

        visiting.remove(course);
        completed.add(course);

        return true;
    }
}