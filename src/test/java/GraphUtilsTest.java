import org.example.GNode;
import org.example.GNodeImpl;
import org.example.GraphUtils;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GraphUtilsTest {

    @Test
    public void testWalkGraph() {
        GNode nodeJ = new GNodeImpl("J", Collections.emptyList());
        GNode nodeA = getgNode(nodeJ);

        List<GNode> result = GraphUtils.walkGraph(nodeA);
        String[] expectedNames = {"A", "B", "E", "F", "C", "G", "H", "D", "J"};

        assertEquals(expectedNames.length, result.size());
        for (int i = 0; i < expectedNames.length; i++) {
            assertEquals(expectedNames[i], result.get(i).getName());
        }
    }

    @Test
    public void testPaths() {
        GNode nodeJ = new GNodeImpl("J", Collections.emptyList());
        GNode nodeA = getgNode(nodeJ);

        List<List<GNode>> result = GraphUtils.paths(nodeA);

        String[][] expectedPaths = {
                {"A", "B", "E"},
                {"A", "B", "F"},
                {"A", "C", "G"},
                {"A", "C", "E"},
                {"A", "C", "H"},
                {"A", "D", "J"}
        };

        assertEquals(expectedPaths.length, result.size());
        for (String[] expectedPath : expectedPaths) {
            boolean pathFound = false;
            for (List<GNode> actualPath : result) {
                if (expectedPath.length == actualPath.size()) {
                    boolean match = true;
                    for (int i = 0; i < expectedPath.length; i++) {
                        if (!expectedPath[i].equals(actualPath.get(i).getName())) {
                            match = false;
                            break;
                        }
                    }
                    if (match) {
                        pathFound = true;
                        break;
                    }
                }
            }
            assertTrue(pathFound, "Expected path not found: " + Arrays.toString(expectedPath));
        }
    }


    private static GNode getgNode(GNode nodeJ) {
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
