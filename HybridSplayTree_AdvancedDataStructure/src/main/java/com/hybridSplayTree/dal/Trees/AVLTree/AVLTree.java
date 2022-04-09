package com.hybridSplayTree.dal.Trees.AVLTree;

import com.hybridSplayTree.dal.TreeNode.TreeNode;
import com.hybridSplayTree.dal.TreeNodeOperations.CheckUnBalancedNode;
import com.hybridSplayTree.dal.TreeNodeOperations.TreeNodeOperations;
import com.hybridSplayTree.dal.TreeNodeOperations.UpdateWeights;
import com.hybridSplayTree.dal.Utilities.CreateBasicTree;

import java.util.List;

public class AVLTree implements CreateBasicTree {

    private TreeNode HeadNode = null;

    @Override
    public boolean insert(int data) {
        return insert(new TreeNode(data, null));
    }

    @Override
    public boolean insert(TreeNode data) {
        if(HeadNode == null){
            HeadNode = data;
        }
        TreeNode parent = TreeNodeOperations.getInstance().findParent(HeadNode, data.getData());
        if(parent == null || data.getData() == parent.getData() ){
            return false;
        }
        data.setParent(parent);
        if(data.getData()< parent.getData()){
            parent.setLeftChild(data);
        }
        else if(data.getData()> parent.getData()){
            parent.setRightChild(data);
        }

        UpdateWeights.getInstance().updateWeights(data);
        TreeNode unBalancedNode = CheckUnBalancedNode.getInstance().findUnBalancedNode(data);
        String orientation = CheckUnBalancedNode.getInstance().findOrientation(unBalancedNode);
        if(!orientation.equals("") || unBalancedNode != null ) {
            System.out.println("\"" + orientation + "\" At Node = " + unBalancedNode);
            TreeNode temp = BalancingNode.getInstance().balanceNode(unBalancedNode, orientation);
            if(temp != null){
                HeadNode = temp;
            }
            unBalancedNode = CheckUnBalancedNode.getInstance().findUnBalancedNode(data);
            if(unBalancedNode!=null){
                System.err.println("Still unbalanced!!");
            }
        }

        return true;

    }

    @Override
    public boolean insert(List<Integer> allData) {
        boolean elementsAdded = false;
        for(Integer data : allData){
            elementsAdded = insert(data) || elementsAdded;
        }
        return elementsAdded;
    }

    @Override
    public TreeNode findTreeNode(TreeNode headNode, int data) {

        if (headNode == null | headNode.getData() == data) {
            return headNode;
        }

        if(headNode.getData()>data){
            return findTreeNode(headNode.getLeftChild(), data);
        }
        return findTreeNode(headNode.getRightChild(), data);

    }

    @Override
    public TreeNode getHeadNode() {
        return this.HeadNode;
    }

    @Override
    public void setHeadNode(int data) {
        setHeadNode(new TreeNode(data, null));
    }

    @Override
    public void setHeadNode(TreeNode data) {
        this.HeadNode = data;
    }
}
