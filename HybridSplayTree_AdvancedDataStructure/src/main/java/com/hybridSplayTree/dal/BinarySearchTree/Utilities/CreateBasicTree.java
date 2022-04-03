package com.hybridSplayTree.dal.BinarySearchTree.Utilities;

import com.hybridSplayTree.dal.BinarySearchTree.TreeNode.TreeNode;

import java.util.List;

public interface CreateBasicTree {

    boolean insert(int data);
    boolean insert(TreeNode data);
    boolean insert(List<Integer> allData);
    TreeNode findTreeNode(TreeNode headNode, int data);
    TreeNode getHeadNode();
    void setHeadNode(int data);
    void setHeadNode(TreeNode data);

}
