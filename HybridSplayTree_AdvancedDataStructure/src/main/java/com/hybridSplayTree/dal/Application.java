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

    public static void main(String arr[]) throws IOException {


        int numberOfElements = 10;
        boolean printGraph = true;

        TimeComparison.getInstance(TreeTypes.Binary_Search_Tree, numberOfElements, printGraph).checkTimeComplexity();
        TimeComparison.getInstance(TreeTypes.AVL_Tree, numberOfElements, printGraph).checkTimeComplexity();
        TimeComparison.getInstance(TreeTypes.Splay_Tree, numberOfElements, printGraph).checkTimeComplexity();
        TimeComparison.getInstance(TreeTypes.Hybrid_Splay_Tree, numberOfElements, printGraph).checkTimeComplexity();



        System.out.println("Hello!");

    }

}
