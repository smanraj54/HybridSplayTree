package com.hybridSplayTree.dal.Trees.SplayTree;

import com.hybridSplayTree.dal.TreeNode.TreeNode;

public class SplayNode {

    private static SplayNode instance = null;



    private SplayNode(){}

    public static SplayNode getInstance(){
        if(instance == null){
            instance = new SplayNode();
        }
        return instance;
    }

    public boolean splayNode(String splayOrientation, TreeNode current){
        switch(splayOrientation){
            case "zz":{
                return splayZigZig(current);
            }
            case "ZZ":{
                return splayZagZag(current);
            }
            case "zZ":{
                return splayZigZag(current);
            }
            case "Zz":{
                return splayZagZig(current);
            }
            case "z":{
                return splayZig(current);
            }
            case "Z":{
                return splayZag(current);
            }
            default:{
                System.err.println("Orientation is wrong!!");
            }

        }
        return false;
    }

    private boolean splayZag(TreeNode current){
        System.out.println("\n\n\tZag-Splay\n\n\t");
        TreeNode parent =  current.getParent();
        if(parent == null){
            return false;
        }

        if(!createConnection(parent, current, parent.getParent())){
            return false;
        }

        connectTwoNodes(parent, current.getLeftChild(),true);
        connectTwoNodes(current, parent, false);
        updateWeight(parent);
        updateWeight(current);
        return true;
    }

    private boolean splayZig(TreeNode current){
        System.out.println("\n\n\tZig-Splay\n\n\t");
        TreeNode parent =  current.getParent();
        if(parent == null){
            return false;
        }

        if(!createConnection(parent, current, parent.getParent())){
            return false;
        }

        connectTwoNodes(parent, current.getRightChild(),false);
        connectTwoNodes(current, parent, true);
        updateWeight(parent);
        updateWeight(current);
        return true;
    }

    private boolean splayZigZig(TreeNode current){
        System.out.println("\n\n\tZigZig-Splay\n\n\t");
        TreeNode parent = current.getParent();
        if(parent == null)return false;

        TreeNode superParent = parent.getParent();
        if(superParent == null)return false;

        if(!createConnection(superParent, current, superParent.getParent())){
            return false;
        }

        connectTwoNodes(superParent, parent.getRightChild(), false);

        connectTwoNodes(parent, current.getRightChild(), false);

        connectTwoNodes(parent, superParent, true);
        connectTwoNodes(current, parent, true);

        updateWeight(superParent);
        updateWeight(parent);
        updateWeight(current);
        return true;
    }

    private boolean splayZagZag(TreeNode current){
        System.out.println("\n\n\tZagZag-Splay\n\n");
        TreeNode parent = current.getParent();
        if(parent == null)return false;

        TreeNode superParent = parent.getParent();
        if(superParent == null)return false;

        if(!createConnection(superParent, current, superParent.getParent())){
            return false;
        }

        connectTwoNodes(superParent, parent.getLeftChild(), true);

        connectTwoNodes(parent, current.getLeftChild(), true);

        connectTwoNodes(parent, superParent, false);
        connectTwoNodes(current, parent, false);

        updateWeight(superParent);
        updateWeight(parent);
        updateWeight(current);
        return true;

    }

    private boolean splayZigZag(TreeNode current){
        System.out.println("\n\n\tZigZag-Splay\n\n\t");
        TreeNode parent = current.getParent();
        if(parent == null)return false;

        TreeNode superParent = parent.getParent();
        if(superParent == null)return false;
        if(!createConnection(superParent, current, superParent.getParent())){
            return false;
        }

        connectTwoNodes(parent, current.getLeftChild(), true);
        connectTwoNodes(superParent, current.getRightChild(), false);
        connectTwoNodes(current, parent, false);
        connectTwoNodes(current, superParent, true);
        updateWeight(superParent);
        updateWeight(parent);
        updateWeight(current);
        return true;
    }

    private boolean splayZagZig(TreeNode current){
        System.out.println("\n\n\tZagZig-Splay\n\n\t");
        TreeNode parent = current.getParent();
        if(parent == null)return false;

        TreeNode superParent = parent.getParent();
        if(superParent == null)return false;
        if(!createConnection(superParent, current, superParent.getParent())){
            return false;
        }

        connectTwoNodes(parent, current.getRightChild(), false);
        connectTwoNodes(superParent, current.getLeftChild(), true);
        connectTwoNodes(current, parent, true);
        connectTwoNodes(current, superParent, false);
        updateWeight(superParent);
        updateWeight(parent);
        updateWeight(current);
        return true;
    }



    private boolean updateWeight(TreeNode current){

        int leftWeight = processChild(current.getLeftChild())+1;
        int rightWeight = processChild(current.getRightChild())+1;

        if(current.getLeftWeight()!=leftWeight || current.getRightWeight() != rightWeight){
            current.setLeftWeight(leftWeight);
            current.setRightWeight(rightWeight);
            return true;
        }
        return false;
    }

    private int processChild(TreeNode child){
        if(child==null)return -1;
        return child.getLeftWeight()> child.getRightWeight()? child.getLeftWeight(): child.getRightWeight();
    }

    private int maxVal(int a, int b){
        return a>b?a:b;
    }

    private boolean createConnection(TreeNode oldChild, TreeNode newChild, TreeNode parent){
        if(parent != null){
            if(parent.getLeftChild()==oldChild){
                parent.setLeftChild(newChild);
            }
            else if(parent.getRightChild()==oldChild){
                parent.setRightChild(newChild);
            }
            else{
                return false;
            }
        }
        if(newChild != null){
            newChild.setParent(parent);
        }
        return true;
    }

    private boolean connectTwoNodes(TreeNode parent, TreeNode child, boolean isRight ){
        if(parent == null){
            return false;
        }
        if(isRight){
            parent.setRightChild(child);
        }
        else{
            parent.setLeftChild(child);
        }
        if(child != null){
            child.setParent(parent);
        }
        return true;
    }



}
