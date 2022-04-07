package com.hybridSplayTree.dal;

import com.hybridSplayTree.dal.AVLTree.AVLTree;
import com.hybridSplayTree.dal.BinarySearchTree.BinarySearchTree;
import com.hybridSplayTree.dal.PrintTree.NodesPerLevel;
import com.hybridSplayTree.dal.PrintTree.PrintTreeForm;
import com.hybridSplayTree.dal.TreeNode.TreeNode;
import com.hybridSplayTree.dal.Utilities.GenerateRandomValues;
import com.hybridSplayTree.dal.WeightManagement.AddWeights;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Application {

    public static void main(String arr[]) throws IOException {

        /*
        GenerateRandomValues generateRandomValues = new GenerateRandomValues();
        List<Integer> newData = generateRandomValues.getNewData();

        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(newData);
        AddWeights addWeights = new AddWeights();
        addWeights.addWeightsToNodes(binarySearchTree.getHeadNode());

        NodesPerLevel nodesPerLevel = new NodesPerLevel();
        List<List<TreeNode>> listOfNodes = nodesPerLevel.findNodesPerLevel(
                binarySearchTree.getHeadNode());
        System.out.println(listOfNodes);
        PrintTreeForm printTreeForm = new PrintTreeForm("Binary_Tree");
        printTreeForm.printTreeFormat(binarySearchTree.getHeadNode());
        */
        AVLTree avlTree = new AVLTree();
        Scanner sc = new Scanner(System.in);
        for(;;){
            avlTree.insert(sc.nextInt());
            PrintTreeForm printTreeForm = new PrintTreeForm("AVL_Tree");
            printTreeForm.printTreeFormat(avlTree.getHeadNode());
        }

        //System.out.println("Hello!");


    }

}
