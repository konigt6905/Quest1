package org.example;

import java.util.List;

public class GNodeImpl implements GNode {
    private String name;
    private List<GNode> children;

    public GNodeImpl(String name, List<GNode> children) {
        this.name = name;
        this.children = children;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public List<GNode> getChildren() {
        return children;
    }
}
