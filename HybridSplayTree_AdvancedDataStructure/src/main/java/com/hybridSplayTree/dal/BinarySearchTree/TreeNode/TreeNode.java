package com.hybridSplayTree.dal.BinarySearchTree.TreeNode;

public class TreeNode {



    private int data = 0;
    private int leftWeight = 0;
    private int rightWeight = 0;

    private TreeNode leftChild = null;
    private TreeNode rightChild = null;
    private TreeNode parent = null;

    public TreeNode(int data, TreeNode parent) {
        this.data = data;
        this.parent = parent;
    }

    public TreeNode(int data) {
        this.data = data;
    }


    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public int getLeftWeight() {
        return leftWeight;
    }

    public void setLeftWeight(int leftWeight) {
        this.leftWeight = leftWeight;
    }

    public int getRightWeight() {
        return rightWeight;
    }

    public void setRightWeight(int rightWeight) {
        this.rightWeight = rightWeight;
    }

    public TreeNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public TreeNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(TreeNode rightChild) {
        this.rightChild = rightChild;
    }

    public TreeNode getParent() {
        return parent;
    }

    public void setParent(TreeNode parent) {
        this.parent = parent;
    }

    public String toString(){
        return Integer.toString(data);
    }
}
