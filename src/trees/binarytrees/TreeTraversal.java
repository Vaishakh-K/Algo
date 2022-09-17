package trees.binarytrees;

import java.util.ArrayList;
import java.util.Stack;

public class TreeTraversal {
  public static void main(String[] args) {
    TreeNode rootNode = getTree();
    TreeTraversal treeTraversal = new TreeTraversal();

    ArrayList<Integer> inOrderTraversedTree = new ArrayList<Integer>();
    printTreeTraversal("In-Order Recursive", treeTraversal.inOrderTraversalRecursive(rootNode, inOrderTraversedTree));

    ArrayList<Integer> preOrderTraversedTree = new ArrayList<Integer>();
    printTreeTraversal("Pre-Order Recursive", treeTraversal.preOrderTraversalRecursive(rootNode, preOrderTraversedTree));

    ArrayList<Integer> postOrderTraversedTree = new ArrayList<Integer>();
    printTreeTraversal("Post-Order Recursive", treeTraversal.postOrderTraversalRecursive(rootNode, postOrderTraversedTree));
    printTreeTraversal("In-Order", treeTraversal.inOrderTraversal(rootNode));
    printTreeTraversal("Pre-Order", treeTraversal.preOrderTraversal(rootNode));
    printTreeTraversal("Post-Order", treeTraversal.postOrderTraversal(rootNode));

  }

  public static void printTreeTraversal(String traversalName, ArrayList<Integer> traversedTree) {
    System.out.printf("%s Traversal: ", traversalName);
    for (Integer item: traversedTree) {
      System.out.printf("%d ", item);
    }
    System.out.println("");
  }

  public static TreeNode getTree() {
    TreeNode n1 = new TreeNode(7);
    TreeNode n2 = new TreeNode(4, n1, null);
    TreeNode n3 = new TreeNode(5);
    TreeNode n4 = new TreeNode(2, n2, n3);
    TreeNode n5 = new TreeNode(10);
    TreeNode n6 = new TreeNode(8, n5, null);
    TreeNode n7 = new TreeNode(9);
    TreeNode n8 = new TreeNode(6, n6, n7);
    TreeNode n9 = new TreeNode(3, null, n8);
    TreeNode n10 = new TreeNode(1, n4, n9);

    return n10;
  }

  public ArrayList<Integer> inOrderTraversalRecursive(TreeNode node, ArrayList<Integer> traversedTree) {
    if (node != null) {
      inOrderTraversalRecursive(node.leftNode, traversedTree);
      traversedTree.add(node.value);
      inOrderTraversalRecursive(node.rightNode, traversedTree);
    }

    return traversedTree;
  }

  public ArrayList<Integer> preOrderTraversalRecursive(TreeNode node, ArrayList<Integer> traversedTree) {
    if (node != null) {
      traversedTree.add(node.value);
      preOrderTraversalRecursive(node.leftNode, traversedTree);
      preOrderTraversalRecursive(node.rightNode, traversedTree);
    }

    return traversedTree;
  }

  public ArrayList<Integer> postOrderTraversalRecursive(TreeNode node, ArrayList<Integer> traversedTree) {
    if (node != null) {
      postOrderTraversalRecursive(node.leftNode, traversedTree);
      postOrderTraversalRecursive(node.rightNode, traversedTree);
      traversedTree.add(node.value);
    }

    return traversedTree;
  }

  public ArrayList<Integer> inOrderTraversal(TreeNode rootNode) {
    ArrayList<Integer> traversedTree = new ArrayList<Integer>();
    Stack<TreeNode> nodeStack = new Stack<TreeNode>();
    TreeNode currNode = rootNode;

    while (currNode != null || !nodeStack.empty()) {
      while(currNode != null) {
        nodeStack.push(currNode);
        currNode = currNode.leftNode;
      }

      currNode = nodeStack.pop();
      traversedTree.add(currNode.value);
      currNode = currNode.rightNode;
    }

    return traversedTree;
  }

  public ArrayList<Integer> preOrderTraversal(TreeNode rootNode) {
    ArrayList<Integer> traversedTree = new ArrayList<Integer>();
    Stack<TreeNode> nodeStack = new Stack<TreeNode>();
    TreeNode currNode = rootNode;

    while(currNode != null || !nodeStack.empty()) {
      while (currNode != null) {
        traversedTree.add(currNode.value);
        if (currNode.rightNode != null) {
          nodeStack.push(currNode.rightNode);
        }
        currNode = currNode.leftNode;
      }
      if (!nodeStack.empty()) {
        currNode = nodeStack.pop();
      }
    }

    return traversedTree;
  }

  public ArrayList<Integer> postOrderTraversal(TreeNode rootNode) {
    ArrayList<Integer> traversedTree = new ArrayList<Integer>();
    Stack<TreeNode> nodeStack = new Stack<TreeNode>();
    TreeNode currNode = rootNode;
    TreeNode prevNode = null;

    while(currNode != null || !nodeStack.empty()) {
      while (currNode != null) {
        nodeStack.push(currNode);
        currNode = currNode.leftNode;
      }

      currNode = nodeStack.peek();
      if (currNode.rightNode != null  && currNode.rightNode != prevNode) {
        currNode = currNode.rightNode;
        prevNode = currNode;
      } else {
        prevNode = nodeStack.pop();
        traversedTree.add(prevNode.value);
        currNode = null;
      }
    }

    return traversedTree;
  }
}
