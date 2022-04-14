package com.hybridSplayTree.dal.PrintTree;


import com.hybridSplayTree.dal.TreeNode.TreeNode;

import java.io.IOException;
import java.util.List;

public class PrintTreeForm {

    private String treeType = "";

    public PrintTreeForm(String treeType) {
        this.treeType = treeType;
    }

    private int partition = 150;


    public void printTreeFormat(TreeNode head) throws IOException {

        NodesPerLevel nodes = new NodesPerLevel();
        List<List<TreeNode>> allNodes = nodes.findNodesPerLevel(head);

        for (List<TreeNode> treeNodes : allNodes) {
            boolean first = true;
            boolean toggle = true;
            PrintFile.getInstance(treeType).printNext(true);
            for (TreeNode node : treeNodes) {

                String data = "_";
                if (node != null) {
                    data = node.toString();
                }
                if (first) {
                    PrintFile.getInstance(treeType).print(true, partition, data);
                    first = false;
                } else {
                    if (toggle) {
                        PrintFile.getInstance(treeType).print(true, partition / 2, data);
                    } else {
                        PrintFile.getInstance(treeType).print(true, partition, data);
                    }
                }
                //PrintFile.getInstance(treeType).print(true, partition, data);
                toggle = !toggle;
            }
            partition = (partition * 2) / 3;
        }
        PrintFile.getInstance(treeType).printNext(true);
        printHeight(head);

        PrintFile.getInstance(treeType).close();


    }

    public void printHeight(TreeNode head) throws IOException {
        PrintFile.getInstance(treeType).printNext(true);
        int maxHeight = (head.getLeftWeight() > head.getRightWeight() ? head.getLeftWeight() : head.getRightWeight()) + 1;

        PrintFile.getInstance(treeType).print(true, 40, "Height of "+treeType+": " + maxHeight);
        PrintFile.getInstance(treeType).printNext(true);
    }


}
