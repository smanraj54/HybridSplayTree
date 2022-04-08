package com.hybridSplayTree.dal.TreeNodeOperations;

import com.hybridSplayTree.dal.TreeNode.TreeNode;

public class UpdateWeights {

    private static UpdateWeights instance = null;

    private UpdateWeights() {
    }

    public static UpdateWeights getInstance() {
        if (instance == null) {
            instance = new UpdateWeights();
        }
        return instance;
    }

    public boolean updateWeights(TreeNode child) {

        TreeNode parent = child.getParent();

        while (parent != null) {
            //boolean updated = false;
            if (!compareParentChild(parent, child)) {
                return false;
            }
            child = child.getParent();
            parent = parent.getParent();
        }
        return true;
    }

    private int maxVal(int a, int b) {
        return a > b ? a : b;
    }

    private boolean compareParentChild(TreeNode parent, TreeNode child) {
        int temp = maxVal(child.getLeftWeight(), child.getRightWeight());
        if (parent.getLeftChild() == child) {
            if (parent.getLeftWeight() <= temp) {
                parent.setLeftWeight(temp + 1);
                if (parent.getLeftWeight() > parent.getRightWeight())
                    return true;
            }

        } else if (parent.getRightChild() == child) {
            if (parent.getRightWeight() <= temp) {
                parent.setRightWeight(temp + 1);
                if (parent.getLeftWeight() < parent.getRightWeight())
                    return true;
            }

        }
        return false;
    }

    public boolean updateWeightsFromBase(TreeNode node){
        int leftWeight = 0;
        int rightWeight = 0;
        //boolean updated = false;

        while(node!=null){
            if(node.getLeftChild()!=null){
                leftWeight = maxVal(node.getLeftChild().getLeftWeight(), node.getLeftChild().getRightWeight())+1;
            }
            if(node.getRightChild()!=null){
                rightWeight = maxVal(node.getRightChild().getLeftWeight(), node.getRightChild().getRightWeight())+1;
            }
            if(node.getLeftWeight()==leftWeight && node.getRightWeight()==rightWeight){
                return false;

            }
            node.setLeftWeight(leftWeight);
            node.setRightWeight(rightWeight);
            node = node.getParent();
        }
        return true;




    }

}

