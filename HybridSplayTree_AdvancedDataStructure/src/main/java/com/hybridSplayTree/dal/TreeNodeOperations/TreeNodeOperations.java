package com.hybridSplayTree.dal.TreeNodeOperations;

import com.hybridSplayTree.dal.TreeNode.TreeNode;

public class TreeNodeOperations {

    private TreeNodeOperations(){}
    public static TreeNodeOperations instance = null;

    public static TreeNodeOperations getInstance() {
        if(instance==null){
            instance = new TreeNodeOperations();
        }
        return instance;
    }

    public TreeNode findParent(TreeNode current, int data) {
        if ((data < current.getData() && current.getLeftChild() == null) ||
                (data > current.getData() && current.getRightChild() == null)) {
            return current;
        }
        if (data < current.getData()) {
            return findParent(current.getLeftChild(), data);
        }
        if (data > current.getData()) {
            return findParent(current.getRightChild(), data);
        }
        return null;
    }
}
