package com.hybridSplayTree.dal.Trees.SplayTree;

import com.hybridSplayTree.dal.TreeNode.TreeNode;
import com.hybridSplayTree.dal.TreeNodeOperations.TreeNodeOperations;
import com.hybridSplayTree.dal.TreeNodeOperations.UpdateWeights;
import com.hybridSplayTree.dal.Utilities.CreateBasicTree;

import java.util.List;

public class SplayTree implements CreateBasicTree {

    private TreeNode HeadNode = null;

    @Override
    public boolean insert(int data) {
        return insert(new TreeNode(data, null));
    }

    @Override
    public boolean insert(TreeNode data) {
        if(getHeadNode() == null){
            setHeadNode(data);
        }
        TreeNode parent = TreeNodeOperations.getInstance().findParent(getHeadNode(), data.getData());
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

        TreeNode temp = SplayNodeToTop.getInstance().splayNodeToTop(data);
        if(temp!=null){
            setHeadNode(temp);
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
        TreeNode current  = reccursiveFindNode(headNode, data);
        SplayNodeToTop.getInstance().splayNodeToTop(current);
        return null;
    }

    private TreeNode reccursiveFindNode(TreeNode current, int data){
        if(current==null || current.getData() == data){
            return current;
        }

        if(current.getData() < data){
            TreeNode temp = reccursiveFindNode(current.getRightChild(), data);
            if(temp == null){
                temp = current;
            }
            return temp;
        }

        TreeNode temp = reccursiveFindNode(current.getLeftChild(), data);
        if(temp == null){
            temp = current;
        }
        return temp;

    }

    private TreeNode reccursiveInsertNodeParent(TreeNode current, TreeNode data){
        if(current == null || data == null || current.getData()==data.getData()){
            return null;
        }

        if(current.getData() < data.getData()){
            return reccursiveInsertNodeParent(current.getRightChild(), data);
        }
        return reccursiveInsertNodeParent(current.getLeftChild(), data);
    }

    private boolean splayToTheTop(){
        return false;
    }

    @Override
    public TreeNode getHeadNode() {
        return HeadNode;
    }

    @Override
    public void setHeadNode(int data) {
        setHeadNode(new TreeNode(data));
    }

    @Override
    public void setHeadNode(TreeNode data) {
        HeadNode = data;
    }
}
