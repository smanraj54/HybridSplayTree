package com.hybridSplayTree.dal.PrintTree;

import com.hybridSplayTree.dal.TreeNode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class NodesPerLevel {

    private List<List<TreeNode>> allNodesPerLevel = null;
    private int level = 0;
    private boolean allNull = true;

    public NodesPerLevel(){
        allNodesPerLevel = new ArrayList<>();
    }

    public List<List<TreeNode>> findNodesPerLevel(TreeNode headNode){

        if(level==0){
            List<TreeNode> temp = new ArrayList<TreeNode>();
            allNodesPerLevel.add(temp);
            temp.add(headNode);
        }

        addAllNodes();
        allNodesPerLevel.remove(allNodesPerLevel.size()-1);
        return allNodesPerLevel;

    }

    private void addAllNodes(){

        List<TreeNode> current = allNodesPerLevel.get(level);
        if(current==null) {
            return;
        }
        level++;
        List<TreeNode> temp = new ArrayList<TreeNode>();

        allNull = true;
        for(TreeNode iter: current){
            if(iter!=null){
                allNull = false;
                temp.add(iter.getLeftChild());
                temp.add(iter.getRightChild());
            }
            else{
                temp.add(null);
                temp.add(null);
            }
        }
        if(allNull){
            return;
        }
        allNodesPerLevel.add(temp);
        addAllNodes();
    }
}
