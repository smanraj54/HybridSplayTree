package com.hybridSplayTree.dal.WeightManagement;

import com.hybridSplayTree.dal.TreeNode.TreeNode;

public class AddWeights {
    public void addWeightsToNodes(TreeNode HeadNode) {
        updateAllNodes(HeadNode);
    }

    private int updateAllNodes(TreeNode current) {

        int left = 0;
        int right = 0;
        if (current.getLeftChild() == null) {
            left = 0;
        }
        if (current.getRightChild() == null) {
            right = 0;
        }
        if (current.getLeftChild() != null) {
            left = updateAllNodes(current.getLeftChild())+1;
        }
        if (current.getRightChild() != null) {
            right = updateAllNodes(current.getRightChild())+1;
        }
        current.setRightWeight(right);
        current.setLeftWeight(left);

        return (left > right) ? left : right;

    }

}
