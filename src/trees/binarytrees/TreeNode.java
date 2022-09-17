package trees.binarytrees;

public class TreeNode {
  int value;
  TreeNode leftNode;
  TreeNode rightNode;

  public TreeNode() {};

  public TreeNode(int value) {
    this.value = value;
  }

  public TreeNode(int value, TreeNode left, TreeNode right) {
    this.value = value;
    this.leftNode = left;
    this.rightNode = right;
  }
}
