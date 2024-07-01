package org.example;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GraphUtils {
    public static List<GNode> walkGraph(GNode node) {
        List<GNode> result = new ArrayList<>();
        Set<GNode> visited = new HashSet<>();
        dfs(node, result, visited);
        return result;
    }

    private static void dfs(GNode node, List<GNode> result, Set<GNode> visited) {
        if (node == null || visited.contains(node)) {
            return;
        }
        visited.add(node);
        result.add(node);
        for (GNode child : node.getChildren()) {
            dfs(child, result, visited);
        }
    }

    public static List<List<GNode>> paths(GNode node) {
        List<List<GNode>> result = new ArrayList<>();
        if (node == null) {
            return result;
        }
        List<GNode> currentPath = new ArrayList<>();
        findPaths(node, currentPath, result);
        return result;
    }

    private static void findPaths(GNode node, List<GNode> currentPath, List<List<GNode>> result) {
        if (node == null) {
            return;
        }
        currentPath.add(node);
        if (node.getChildren().isEmpty()) {
            result.add(new ArrayList<>(currentPath));
        } else {
            for (GNode child : node.getChildren()) {
                findPaths(child, currentPath, result);
            }
        }
        currentPath.remove(currentPath.size() - 1);
    }
}
