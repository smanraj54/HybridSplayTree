package com.hybridSplayTree.dal;

import com.hybridSplayTree.dal.Trees.AVLTree.AVLTree;
import com.hybridSplayTree.dal.PrintTree.PrintTreeForm;
import com.hybridSplayTree.dal.Trees.SplayTree.SplayTree;

import java.io.IOException;
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
        SplayTree splayTree = new SplayTree();

        Scanner sc = new Scanner(System.in);
        for(;;){
            splayTree.insert(sc.nextInt());
            PrintTreeForm printTreeForm = new PrintTreeForm("Splay_Tree");
            printTreeForm.printTreeFormat(splayTree.getHeadNode());
        }

        //System.out.println("Hello!");


    }

}
