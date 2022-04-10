package com.hybridSplayTree.dal;

import com.hybridSplayTree.dal.Trees.AVLTree.AVLTree;
import com.hybridSplayTree.dal.PrintTree.PrintTreeForm;
import com.hybridSplayTree.dal.Trees.HybridSplayTree.HybridSplayTree;
import com.hybridSplayTree.dal.Trees.SplayTree.SplayTree;
import com.hybridSplayTree.dal.Utilities.TestBalance;

import java.io.IOException;
import java.util.Scanner;

public class Application {

    public static void main(String arr[]) throws IOException {


        int numberOfElements = 5000;

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
        AVLTree avlTree1 = new AVLTree();
        AVLTree avlTree2 = new AVLTree();
        SplayTree splayTree = new SplayTree();

        Scanner sc = new Scanner(System.in);
        for(int t=1; t<=numberOfElements; t++){
            //avlTree.insert((int)(Math.random()*10000)+1);
            avlTree.insert(t);
            avlTree1.insert(t);
            avlTree2.insert(t);
//            PrintTreeForm printTreeForm = new PrintTreeForm("AVL_Tree");
//            printTreeForm.printTreeFormat(avlTree.getHeadNode());
            if(!TestBalance.getInstance().testBalance(avlTree1.getHeadNode())){
                System.err.println("\n\n\t\tTree is not balanced! at element = "+t+"\n\n");
                break;
            }
        }
//        PrintTreeForm printTreeForm = new PrintTreeForm("AVL_Tree");
//        printTreeForm.printTreeFormat(avlTree.getHeadNode());

        splayTree.setHeadNode(avlTree1.getHeadNode());
        splayTree.setMinNode(avlTree1.getMinNode());
        splayTree.setMaxNode(avlTree1.getMaxNode());

        HybridSplayTree hybridSplayTree = new HybridSplayTree();

        hybridSplayTree.setHeadNode(avlTree2.getHeadNode());
        hybridSplayTree.setMinNode(avlTree2.getMinNode());
        hybridSplayTree.setMaxNode(avlTree2.getMaxNode());
        //PrintTreeForm printSplayTree = new PrintTreeForm("Hybrid_Splay_Tree");

        for(int t=1; t<=numberOfElements; t++){
            hybridSplayTree.findTreeNode(hybridSplayTree.getHeadNode(), t);
            splayTree.findTreeNode(splayTree.getHeadNode(), t);
//            printSplayTree.printTreeFormat(hybridSplayTree.getHeadNode());
        }

        System.out.println("Hello!");

    }

}
