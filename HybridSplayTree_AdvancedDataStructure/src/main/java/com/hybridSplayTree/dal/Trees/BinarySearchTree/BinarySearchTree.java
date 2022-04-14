package com.hybridSplayTree.dal.Trees.BinarySearchTree;

import com.hybridSplayTree.dal.TreeNode.TreeNode;
import com.hybridSplayTree.dal.TreeNodeOperations.TreeNodeOperations;
import com.hybridSplayTree.dal.Utilities.CreateBasicTree;

import java.util.List;

public class BinarySearchTree implements CreateBasicTree {


    private TreeNode HeadNode = null;
    private TreeNode minNode = null;
    private TreeNode maxNode = null;

    @Override
    public boolean insert(int data) {
        return insert(new TreeNode(data));
    }

    @Override
    public boolean insert(TreeNode dataNode) {

        int data = dataNode.getData();

        if (HeadNode == null) {
            HeadNode = dataNode;
            maxNode = dataNode;
            minNode = dataNode;
            return false;
        }

        TreeNode parentNode = TreeNodeOperations.getInstance().findParent(HeadNode, data);
        if (parentNode == null || parentNode.getData() == dataNode.getData()) {
            //System.err.println("Duplicate entry");
            return false;
        }

        if(dataNode.getData() < minNode.getData()){
            minNode = dataNode;
        }
        else if(dataNode.getData() > maxNode.getData()){
            maxNode = dataNode;
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
    public boolean insert(List<Integer> allData){
        boolean elementsAdded = false;
        for(Integer data: allData){
            elementsAdded = insert(data) || elementsAdded;
        }
        return elementsAdded;
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

    @Override
    public TreeNode getMinNode() {
        return minNode;
    }

    public void setMinNode(TreeNode minNode) {
        this.minNode = minNode;
    }

    public TreeNode getMaxNode() {
        return maxNode;
    }

    public void setMaxNode(TreeNode maxNode) {
        this.maxNode = maxNode;
    }


}
