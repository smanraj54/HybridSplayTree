package BinalrySearchTree;

import TreeNode.TreeNode;
import Utilities.CreateBasicTree;

public class BinarySearchTree implements CreateBasicTree {


    private TreeNode HeadNode = null;

    @Override
    public boolean insert(int data) {
        if (HeadNode == null) {
            HeadNode = new TreeNode(data, null);
            return true;
        }
        TreeNode current = new TreeNode(data);
        return insert(current);
    }

    @Override
    public boolean insert(TreeNode dataNode) {

        int data = dataNode.getData();

        if (HeadNode == null) {
            HeadNode = dataNode;
        }
        TreeNode parentNode = findParent(HeadNode, data);
        if (parentNode == null) {
            //System.err.println("Duplicate entry");
            return false;
        }

        dataNode.setParent(parentNode);

        if (data < parentNode.getData()) {
            parentNode.setLeftChild(dataNode);
            return true;
        }
        if (data > parentNode.getData()) {
            parentNode.setRightChild(dataNode);
            return true;
        }
        return false;
    }

    @Override
    public TreeNode findTreeNode(TreeNode headNode, int data) {

        if (headNode == null || headNode.getData() == data) {
            return headNode;
        }

        if (headNode.getData() < data) {
            return findTreeNode(headNode.getRightChild(), data);
        }

        return findTreeNode(headNode.getLeftChild(), data);

    }

    @Override
    public TreeNode getHeadNode() {
        return HeadNode;
    }

    @Override
    public void setHeadNode(int data) {
        HeadNode = new TreeNode(data, null);
    }

    @Override
    public void setHeadNode(TreeNode data) {
        HeadNode = data;
    }

    private TreeNode findParent(TreeNode current, int data) {
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
