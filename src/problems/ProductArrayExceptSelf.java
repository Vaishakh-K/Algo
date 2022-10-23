// Author: Vaishakh
// LeetCode Problem Link: https://leetcode.com/problems/product-of-array-except-self/
package problems;

public class ProductArrayExceptSelf {
  public static void main(String[] args) {
    int[] array = new int[] {1, 2, 3, 4, 5, 6};
    int[] result = getProductArray(array);
    System.out.println("Product Array Except Self");
    for (int element: result) {
      System.out.format("%d ", element);
    }

    int[] resultWithoutExtraSpace = getProductArrayWithoutExtraSpace(array);
    System.out.println("\nProduct Array Except Self Without Additional Space");
    for (int element: resultWithoutExtraSpace) {
      System.out.format("%d ", element);
    }
  }

  public static int[] getProductArray(int[] array) {
    int len = array.length;

    int[] prefixProductArray = new int[len];
    int[] suffixProductArray = new int[len];
    int[] resultArray = new int[len];

    prefixProductArray[0] = 1;
    suffixProductArray[len - 1] = 1;

    for (int i = 1; i < len; i++) {
      prefixProductArray[i] = prefixProductArray[i - 1] * array[i - 1];
    }

    for (int i = len - 2; i >= 0; i--) {
      suffixProductArray[i] = suffixProductArray[i + 1] * array[i + 1];
    }

    for (int i = 0; i < len; i++) {
      resultArray[i] = prefixProductArray[i] * suffixProductArray[i];
    }

    return resultArray;
  }

  public static int[] getProductArrayWithoutExtraSpace(int[] array) {
    int len = array.length;
    int[] resultArray = new int[len];

    resultArray[0] = 1;
    for (int i = 1; i < len; i++) {
      resultArray[i] = resultArray[i - 1] * array[i - 1];
    }

    int suffixProduct = 1;
    for (int i = len - 1; i >= 0; i--) {
      resultArray[i] = resultArray[i] * suffixProduct;
      suffixProduct *= array[i];
    }

    return resultArray;
  }
}
