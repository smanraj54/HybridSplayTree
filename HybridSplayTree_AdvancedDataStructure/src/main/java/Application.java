import BinalrySearchTree.BinarySearchTree;
import PrintTree.NodesPerLevel;
import TreeNode.TreeNode;
import Utilities.GenerateRandomValues;

import java.util.List;

public class Application {

    public static void main(String arr[]) {

        GenerateRandomValues generateRandomValues = new GenerateRandomValues();
        List<Integer> newData = generateRandomValues.getNewData();

        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(newData);

        NodesPerLevel nodesPerLevel = new NodesPerLevel();
        List<List<TreeNode>> listOfNodes = nodesPerLevel.findNodesPerLevel(
                binarySearchTree.getHeadNode());
        System.out.println(listOfNodes);
        System.out.println("Hello!");


    }

}
