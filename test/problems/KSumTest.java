package problems;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KSumTest {
  @Test
  public void test2Sum() {
    KSum ksum = new KSum();
    int[] array = new int[] {1,0,-1,0,-2,2};
    int target = 0;
    int k = 2;

    List<List<Integer>> expectedResultList = new ArrayList<>();
    Integer[][] expResult = new Integer[][] {{-2, 2}, {-1, 1}, {0, 0}};
    for (Integer[] res: expResult) {
      List<Integer> resList = Arrays.asList(res);
      expectedResultList.add(resList);
    }

    ksum.computeKSum(array, target, k);
    Assert.assertEquals(expectedResultList, ksum.resultList);
  }

  @Test
  public void test3Sum() {
    KSum ksum = new KSum();
    int[] array = new int[] {1,0,-1,0,-2,2};
    int target = 0;
    int k = 3;

    List<List<Integer>> expectedResultList = new ArrayList<>();
    Integer[][] expResult = new Integer[][] {{-2, 0, 2}, {-1, 0, 1}};
    for (Integer[] res: expResult) {
      List<Integer> resList = Arrays.asList(res);
      expectedResultList.add(resList);
    }

    ksum.computeKSum(array, target, k);
    Assert.assertEquals(expectedResultList, ksum.resultList);
  }

  @Test
  public void test4Sum() {
    KSum ksum = new KSum();
    int[] array = new int[] {1,0,-1,0,-2,2};
    int target = 0;
    int k = 4;

    List<List<Integer>> expectedResultList = new ArrayList<>();
    Integer[][] expResult = new Integer[][] {{-2, -1, 1, 2}, {-2, 0, 0, 2}, {-1, 0, 0, 1}};
    for (Integer[] res: expResult) {
      List<Integer> resList = Arrays.asList(res);
      expectedResultList.add(resList);
    }

    ksum.computeKSum(array, target, k);
    Assert.assertEquals(expectedResultList, ksum.resultList);
  }
}
