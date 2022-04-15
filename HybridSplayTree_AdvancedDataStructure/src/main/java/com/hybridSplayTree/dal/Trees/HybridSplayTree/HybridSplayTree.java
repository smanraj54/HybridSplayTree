package com.hybridSplayTree.dal.Trees.HybridSplayTree;

import com.hybridSplayTree.dal.TreeNode.TreeNode;
import com.hybridSplayTree.dal.TreeNodeOperations.CheckUnBalancedNode;
import com.hybridSplayTree.dal.Trees.AVLTree.BalancingNode;
import com.hybridSplayTree.dal.Trees.SplayTree.SplayTree;
import com.hybridSplayTree.dal.Utilities.CreateBasicTree;

public class HybridSplayTree extends SplayTree implements CreateBasicTree{

    public TreeNode findTreeNode(TreeNode headNode, int data){
        super.findTreeNode(headNode, data);
        if(headNode.getData() == data){
            return headNode;
        }
        TreeNode newHead = getHeadNode();
        if(newHead == getMinNode() || newHead == getMaxNode()){
            return newHead;
        }
        while(headNode.getParent()!=null) {
            String orientation = CheckUnBalancedNode.getInstance().findOrientation(headNode);
            if(orientation.equals("")){
                break;
            }
            //System.out.println("\"" + orientation + "\" At Node = " + headNode);
            BalancingNode.getInstance().balanceNode(headNode, orientation);
        }
        return newHead;
    }

}
