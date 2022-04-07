package com.hybridSplayTree.dal.TreeNodeOperations;

import com.hybridSplayTree.dal.TreeNode.TreeNode;

public class UnbancedNodePackage {

    private TreeNode unBalancedNode = null;
    private String orientation = null;

    public TreeNode getUnBalancedNode() {
        return unBalancedNode;
    }

    public void setUnBalancedNode(TreeNode unBalancedNode) {
        this.unBalancedNode = unBalancedNode;
    }

    public String getOrientation() {
        return orientation;
    }

    public void setOrientation(String orientation) {
        this.orientation = orientation;
    }
}
