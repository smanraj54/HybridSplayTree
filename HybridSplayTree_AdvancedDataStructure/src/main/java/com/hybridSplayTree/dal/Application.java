package com.hybridSplayTree.dal;

import com.hybridSplayTree.dal.Trees.AVLTree.AVLTree;
import com.hybridSplayTree.dal.PrintTree.PrintTreeForm;
import com.hybridSplayTree.dal.Trees.HybridSplayTree.HybridSplayTree;
import com.hybridSplayTree.dal.Trees.SplayTree.SplayTree;
import com.hybridSplayTree.dal.Utilities.TestBalance;
import com.hybridSplayTree.dal.Utilities.TimeComparison;
import com.hybridSplayTree.dal.Utilities.TreeTypes;

import java.io.IOException;
import java.util.Scanner;

public class Application {

    public static void main(String arr[]) {


        int numberOfElements = 50000;
        boolean printGraph = false;

//        try {
//            TimeComparison.getInstance(TreeTypes.Binary_Search_Tree, numberOfElements, printGraph).checkTimeComplexity();
//        } catch (IOException e) {
//            System.err.println("\n\t\t Search operation on " + TreeTypes.Binary_Search_Tree.name()+" Failed with memory issue!");
//        }
        try {
            TimeComparison.getInstance(TreeTypes.AVL_Tree, numberOfElements, printGraph).checkTimeComplexity();
        } catch (IOException e) {
            System.err.println("\n\t\t Search operation on " + TreeTypes.AVL_Tree.name()+" Failed with memory issue!");
        }
        /*try {
            TimeComparison.getInstance(TreeTypes.Splay_Tree, numberOfElements, printGraph).checkTimeComplexity();
        } catch (IOException e) {
            System.err.println("\n\t\t Search operation on " + TreeTypes.Splay_Tree.name()+" Failed with memory issue!");
        }*/
        try {
            TimeComparison.getInstance(TreeTypes.Hybrid_Splay_Tree, numberOfElements, printGraph).checkTimeComplexity();
        } catch (IOException e) {
            System.err.println("\n\t\t Search operation on " + TreeTypes.Hybrid_Splay_Tree.name()+" Failed with memory issue!");
        }


        System.out.println("Hello!");

    }

}
