
class Solution {

    List<Integer>[] children;
    int[] newParent;
    int[] ans;
    HashMap<Character, Integer> lastSeen = new HashMap<>();

    public int[] findSubtreeSizes(int[] parent, String s) {
        int n = parent.length;

        children = new ArrayList[n];
        newParent = parent.clone();
        ans = new int[n];

        for (int i = 0; i < n; i++) {
            children[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            children[parent[i]].add(i);
        }

        findParents(0, s);

        for (int i = 0; i < n; i++) {
            children[i].clear();
        }

        for (int i = 1; i < n; i++) {
            children[newParent[i]].add(i);
        }

        dfs(0);

        return ans;
    }

    void findParents(int node, String s) {
        char c = s.charAt(node);
        Integer previous = lastSeen.get(c);

        if (previous != null) {
            newParent[node] = previous;
        }

        lastSeen.put(c, node);

        for (int child : children[node]) {
            findParents(child, s);
        }

        if (previous == null) {
            lastSeen.remove(c);
        } else {
            lastSeen.put(c, previous);
        }
    }

    int dfs(int node) {
        int size = 1;

        for (int child : children[node]) {
            size += dfs(child);
        }

        ans[node] = size;
        return size;
    }
}
