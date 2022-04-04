package com.hybridSplayTree.dal.BinarySearchTree.WeightManagement;

import com.hybridSplayTree.dal.BinarySearchTree.TreeNode.TreeNode;

public class UpdateWeights {
    public void updateWeightsOfNodes(TreeNode HeadNode) {
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
