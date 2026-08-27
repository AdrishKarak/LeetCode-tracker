class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        // indegree[i] = number of incoming edges to node i
        int[] indegree = new int[n];

        // Count incoming edges for every node
        for (List<Integer> edge : edges) {

            int to = edge.get(1);

            indegree[to]++;
        }

        List<Integer> answer = new ArrayList<>();

        // Nodes with indegree 0 cannot be reached
        // from any other node, so they must be included
        for (int node = 0; node < n; node++) {

            if (indegree[node] == 0) {
                answer.add(node);
            }
        }

        return answer;
    }
}