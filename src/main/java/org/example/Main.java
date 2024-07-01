package org.example;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        GNode nodeA = getgNode();

        List<GNode> walkResult = GraphUtils.walkGraph(nodeA);
        System.out.println("walkGraph result:");
        for (GNode node : walkResult) {
            System.out.print(node.getName() + " ");
        }

        System.out.println("\n\npaths result:");
        List<List<GNode>> pathsResult = GraphUtils.paths(nodeA);
        for (List<GNode> path : pathsResult) {
            for (GNode node : path) {
                System.out.print(node.getName() + " ");
            }
            System.out.println();
        }
    }

    private static GNode getgNode() {
        GNode nodeJ = new GNodeImpl("J", Collections.emptyList());
        GNode nodeH = new GNodeImpl("H", Collections.emptyList());
        GNode nodeE = new GNodeImpl("E", Collections.emptyList());
        GNode nodeG = new GNodeImpl("G", Collections.emptyList());
        GNode nodeF = new GNodeImpl("F", Collections.emptyList());

        GNode nodeD = new GNodeImpl("D", Arrays.asList(nodeJ));
        GNode nodeC = new GNodeImpl("C", Arrays.asList(nodeG, nodeE, nodeH));
        GNode nodeB = new GNodeImpl("B", Arrays.asList(nodeE, nodeF));
        GNode nodeA = new GNodeImpl("A", Arrays.asList(nodeB, nodeC, nodeD));
        return nodeA;
    }
}