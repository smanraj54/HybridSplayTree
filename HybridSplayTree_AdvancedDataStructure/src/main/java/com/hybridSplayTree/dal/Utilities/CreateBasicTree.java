package com.hybridSplayTree.dal.Utilities;

import com.hybridSplayTree.dal.TreeNode.TreeNode;

import java.util.List;

public interface CreateBasicTree {

    boolean insert(int data);
    boolean insert(TreeNode data);
    boolean insert(List<Integer> allData);
    TreeNode findTreeNode(TreeNode headNode, int data);
    TreeNode getHeadNode();
    void setHeadNode(int data);
    void setHeadNode(TreeNode data);

    void setMinNode(TreeNode minNode);

    void setMaxNode(TreeNode maxNode);

    TreeNode getMinNode();
    TreeNode getMaxNode();

}
