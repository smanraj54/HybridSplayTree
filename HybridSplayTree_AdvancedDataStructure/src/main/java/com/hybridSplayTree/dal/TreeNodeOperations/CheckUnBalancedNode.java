package com.hybridSplayTree.dal.TreeNodeOperations;

import com.hybridSplayTree.dal.TreeNode.TreeNode;

public class CheckUnBalancedNode {

    private CheckUnBalancedNode() {
    }

    private static CheckUnBalancedNode instance = null;

    public static CheckUnBalancedNode getInstance() {
        if (instance == null) {
            instance = new CheckUnBalancedNode();
        }
        return instance;
    }

    public TreeNode findUnBalancedNode(TreeNode node) {

        while (node != null) {
            int diff = node.getLeftWeight() - node.getRightWeight();
            if (diff < 0) {
                diff = diff * (-1);
            }
            if (diff > 1) {
                return node;
            }
            node = node.getParent();
        }
        return null;
    }

    public String findOrientation(TreeNode data) {
        String orientation = "";
        if(!isUnbalanced(data)){
            return "";
        }

        orientation = orientation + orientation(data);
        if(orientation.equals("L"))
            data = data.getLeftChild();
        else if(orientation.equals("R")){
            data = data.getRightChild();
        }
        else{
            return "";
        }
        String temp = orientation + orientation(data);
        if(temp.equals(orientation)){
            temp = orientation + orientation;
        }
        return temp;
    }

    public boolean isUnbalanced(TreeNode data) {
        if (data == null) {
            return false;
        }

        int temp = data.getLeftWeight() - data.getRightWeight();
        return (temp < -1 || temp > 1);
    }

    private String orientation(TreeNode data) {
        if (data.getLeftWeight() > data.getRightWeight()) {
            return "L";
        }
        if (data.getLeftWeight() < data.getRightWeight()) {
            return "R";
        }
        return "";


    }


}
