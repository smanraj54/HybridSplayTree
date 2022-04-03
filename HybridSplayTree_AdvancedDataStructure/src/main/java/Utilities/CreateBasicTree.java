package Utilities;

import TreeNode.TreeNode;

public interface CreateBasicTree {

    boolean insert(int data);
    boolean insert(TreeNode data);
    TreeNode findTreeNode(TreeNode headNode, int data);
    TreeNode getHeadNode();
    void setHeadNode(int data);
    void setHeadNode(TreeNode data);

}
