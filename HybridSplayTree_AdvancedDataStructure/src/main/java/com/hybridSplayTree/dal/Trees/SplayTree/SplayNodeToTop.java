package com.hybridSplayTree.dal.Trees.SplayTree;

import com.hybridSplayTree.dal.TreeNode.TreeNode;

public class SplayNodeToTop {

    private static SplayNodeToTop instance = null;
    private SplayNodeToTop(){}
    public static SplayNodeToTop getInstance(){
        if(instance == null){
            instance = new SplayNodeToTop();
        }
        return instance;
    }

    public TreeNode splayNodeToTop(TreeNode current){
        if(current==null) return null;

        while(current.getParent()!=null){
            if(!SplayNode.getInstance().splayNode(findSplayOrientation(current), current)){
                return null;
            }
        }
        return current;
    }


    private String findSplayOrientation(TreeNode currentNode){
        String orientation = "";
        TreeNode parent = currentNode.getParent();
        if(parent == null){
            return "";
        }

        orientation = checkSingleOrientation(parent, currentNode);
        TreeNode superParent = parent.getParent();

        if(superParent == null){
            return orientation;
        }
        return checkSingleOrientation(superParent, parent) + orientation;

    }

    private String checkSingleOrientation(TreeNode parent, TreeNode child){
        if(parent.getLeftChild() == child){
            return "z";
        }
        else{
            return "Z";
        }
    }

}
