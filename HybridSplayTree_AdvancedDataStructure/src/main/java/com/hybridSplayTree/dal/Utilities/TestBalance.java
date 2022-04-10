package com.hybridSplayTree.dal.Utilities;

import com.hybridSplayTree.dal.TreeNode.TreeNode;

public class TestBalance {

    private static TestBalance instance = null;

    private TestBalance() {
    }

    public static TestBalance getInstance() {
        if (instance == null) {
            instance = new TestBalance();
        }
        return instance;
    }

    public boolean testBalance(TreeNode current) {

        if (current == null) {
            return true;
        }
        int diff = current.getLeftWeight() - current.getRightWeight();

        if (diff < -1 || diff > 1) {
            return false;
        }
        if (!testBalance(current.getLeftChild())) {
            return false;
        }
        if (!testBalance(current.getRightChild())) {
            return false;
        }
        return true;
    }

}
