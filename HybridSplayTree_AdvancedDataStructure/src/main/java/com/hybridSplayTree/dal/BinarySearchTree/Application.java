package com.hybridSplayTree.dal.BinarySearchTree;

import com.hybridSplayTree.dal.BinarySearchTree.BinarySearchTree;
import com.hybridSplayTree.dal.BinarySearchTree.PrintTree.NodesPerLevel;
import com.hybridSplayTree.dal.BinarySearchTree.PrintTree.PrintFile;
import com.hybridSplayTree.dal.BinarySearchTree.PrintTree.PrintTreeForm;
import com.hybridSplayTree.dal.BinarySearchTree.TreeNode.TreeNode;
import com.hybridSplayTree.dal.BinarySearchTree.Utilities.GenerateRandomValues;
import com.hybridSplayTree.dal.BinarySearchTree.WeightManagement.UpdateWeights;

import java.io.IOException;
import java.util.List;

public class Application {

    public static void main(String arr[]) throws IOException {

        GenerateRandomValues generateRandomValues = new GenerateRandomValues();
        List<Integer> newData = generateRandomValues.getNewData();

        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(newData);
        UpdateWeights updateWeights = new UpdateWeights();
        updateWeights.updateWeightsOfNodes(binarySearchTree.getHeadNode());

        NodesPerLevel nodesPerLevel = new NodesPerLevel();
        List<List<TreeNode>> listOfNodes = nodesPerLevel.findNodesPerLevel(
                binarySearchTree.getHeadNode());
        System.out.println(listOfNodes);
        PrintTreeForm printTreeForm = new PrintTreeForm("Binary_Tree");
        printTreeForm.printTreeFormat(binarySearchTree.getHeadNode());
        System.out.println("Hello!");


    }

}
