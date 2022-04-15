package com.hybridSplayTree.dal.Utilities;

import com.hybridSplayTree.dal.PrintTree.PrintTreeForm;
import com.hybridSplayTree.dal.Trees.AVLTree.AVLTree;
import com.hybridSplayTree.dal.Trees.BinarySearchTree.BinarySearchTree;
import com.hybridSplayTree.dal.Trees.HybridSplayTree.HybridSplayTree;
import com.hybridSplayTree.dal.Trees.SplayTree.SplayTree;
import com.hybridSplayTree.dal.WeightManagement.AddWeights;

import java.io.IOException;

import static com.hybridSplayTree.dal.Utilities.TreeTypes.Binary_Search_Tree;

public class TimeComparison {

    private TreeTypes treeType = TreeTypes.NULL;
    private int numberOfElements = 0;
    private boolean printGraph = false;

    private static TimeComparison instance = null;
    public static TimeComparison getInstance(TreeTypes treeType, int numberOfElements, boolean printGraph){
        if(instance == null){
            instance = new TimeComparison(treeType, numberOfElements, printGraph);
        }
        return instance;
    }

    private TimeComparison(TreeTypes treeType, int numberOfElements, boolean printGraph){
        this.treeType = treeType;
        this.numberOfElements = numberOfElements;
        this.printGraph = printGraph;
    }

    public void checkTimeComplexity() throws IOException {

        CreateBasicTree tree = getSuitableObject();

        if(treeType == Binary_Search_Tree){
            for(int t=1; t<=numberOfElements; t++){
                tree.insert(t);
            }
            AddWeights addWeights = new AddWeights();
            addWeights.addWeightsToNodes(tree.getHeadNode());
        }
        else {
            AVLTree avlTree = new AVLTree();

            for (int t = 1; t <= numberOfElements; t++) {
                avlTree.insert(t);
                if (!TestBalance.getInstance().testBalance(avlTree.getHeadNode())) {
                    System.err.println("\n\n\t\tTree is not balanced! at element = " + t + "\n\n");
                    break;
                }
            }

            tree.setHeadNode(avlTree.getHeadNode());
            tree.setMinNode(avlTree.getMinNode());
            tree.setMaxNode(avlTree.getMaxNode());
        }

        PrintTreeForm printTree = new PrintTreeForm(treeType.name());


        Long searchStartTime = System.nanoTime();

        for(int t=1; t<=numberOfElements; t++){
            //hybridSplayTree.findTreeNode(hybridSplayTree.getHeadNode(), t);
            tree.findTreeNode(tree.getHeadNode(), t);

        }

        Long searchStopTime = System.nanoTime();

        if(printGraph){
            printTree.printTreeFormat(tree.getHeadNode());
        }
        else{
            printTree.printHeight(tree.getHeadNode());
        }

        Long startBestSearch = System.nanoTime();
        tree.findTreeNode(tree.getHeadNode(), numberOfElements);
        Long stopBestSearch = System.nanoTime();


        Long startSearchTimeMinNode = System.nanoTime();

        tree.findTreeNode(tree.getHeadNode(), tree.getMinNode().getData());

        Long stopSearchTimeMinNode = System.nanoTime();
        Long averageFindTime = (searchStopTime - searchStartTime)/numberOfElements;
        Long worstSearch =  stopSearchTimeMinNode - startSearchTimeMinNode;
        Long bestSearch = stopBestSearch - startBestSearch;

        System.out.println("\n\n\n\t\t"+treeType.name()+" Operations:");
        System.out.println("\n\t\tAverage Time complexity of Search Operation = "+ averageFindTime);
        System.out.println("\n\t\tSearch Time complexity of recently added element = "+ bestSearch);
        System.out.println("\n\t\tWorst Time complexity of searching node = "+ worstSearch);

        this.instance = null;

    }

    private CreateBasicTree getSuitableObject(){
        switch(this.treeType){
            case Binary_Search_Tree: {
                return new BinarySearchTree();
            }
            case AVL_Tree:{
                return new AVLTree();
            }
            case Splay_Tree:{
                return new SplayTree();
            }
            case Hybrid_Splay_Tree:{
                return new HybridSplayTree();

            }
            default:{
                return null;
            }
        }
    }

}
