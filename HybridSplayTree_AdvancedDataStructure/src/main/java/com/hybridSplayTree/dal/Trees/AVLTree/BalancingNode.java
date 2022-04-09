package com.hybridSplayTree.dal.Trees.AVLTree;

import com.hybridSplayTree.dal.TreeNode.TreeNode;
import com.hybridSplayTree.dal.TreeNodeOperations.UpdateWeights;

public class BalancingNode {

    private BalancingNode(){}

    private static BalancingNode instance = null;

    public static BalancingNode getInstance(){
        if(instance == null){
            instance = new BalancingNode();
        }
        return instance;
    }

    public TreeNode balanceNode(TreeNode node, String orientation){
        TreeNode HeadNode = null;
        switch(orientation.toUpperCase()){
            case "LL":{
                HeadNode = rightRotation(node);
                break;
            }
            case "RR":{
                HeadNode = leftRotation(node);
                break;
            }
            case "RL":{
                HeadNode = rightLeftRotation(node);
                break;
            }
            case "LR":{
                HeadNode = leftRightRotation(node);
                break;
            }
            default:{
                System.err.println("Orientation is wrong!!");
            }
        }

        return HeadNode;
    }

    private TreeNode leftRotation(TreeNode node){

        TreeNode HeadNode = null;
        TreeNode nodeParent = node.getParent();
        TreeNode rightChild = node.getRightChild();

        if(nodeParent != null) {
            if(nodeParent.getLeftChild()==node){
                nodeParent.setLeftChild(rightChild);
            }
            else{
                nodeParent.setRightChild(rightChild);
            }

            rightChild.setParent(nodeParent);
        }
        else {
            rightChild.setParent(null);
            HeadNode = rightChild;
        }

        node.setRightChild(rightChild.getLeftChild());

        if(node.getRightChild()!=null)
            node.getRightChild().setParent(node);

        rightChild.setLeftChild(node);
        node.setParent(rightChild);
        balanceWeights(node);
        return HeadNode;
    }

    private TreeNode rightRotation(TreeNode node){

        TreeNode HeadNode = null;
        TreeNode nodeParent = node.getParent();
        TreeNode leftChild = node.getLeftChild();

        if(nodeParent != null) {
            if(nodeParent.getLeftChild()==node){
                nodeParent.setLeftChild(leftChild);
            }
            else{
                nodeParent.setRightChild(leftChild);
            }

            leftChild.setParent(nodeParent);
        }
        else {
            leftChild.setParent(null);
            HeadNode = leftChild;
        }

        node.setLeftChild(leftChild.getRightChild());

        if(node.getLeftChild()!=null)
            node.getLeftChild().setParent(node);

        leftChild.setRightChild(node);
        node.setParent(leftChild);
        balanceWeights(node);
        return HeadNode;
    }

    private TreeNode leftRightRotation(TreeNode node){
        leftRotation(node.getLeftChild());

        return rightRotation(node);
    }

    private TreeNode rightLeftRotation(TreeNode node){
        rightRotation(node.getRightChild());

        return leftRotation(node);
    }

    private boolean balanceWeights(TreeNode node){
        return UpdateWeights.getInstance().updateWeightsFromBase(node);
    }




}
