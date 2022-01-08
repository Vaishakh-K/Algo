// Author - Vaishakh K
package sorting;

public class QuickSort {
  public static void swap (int[] arr, int idxSource, int idxTarget) {
    int temp = arr[idxSource];
    arr[idxSource] = arr[idxTarget];
    arr[idxTarget] = temp;
  }
  public static void quickSort(int[] arr, int low, int high) {
    if (low < high) {
      int pivot = partition(arr, low, high);

      quickSort(arr, low, pivot - 1);
      quickSort(arr, pivot + 1, high);
    }
  }
  public static int partition(int[] arr, int low, int high) {
    int idxLowerVal = low - 1;
    int pivot = arr[high];

    for (int idxCurr = low; idxCurr <= high; idxCurr++) {
      if (arr[idxCurr] < pivot) {
        idxLowerVal++;
        swap(arr, idxLowerVal, idxCurr);
      }
    }
    swap(arr,  idxLowerVal + 1, high);
    return idxLowerVal + 1;
  }

  public static void main (String[] args) {
    int[] arr = {3, 5, 0, 17, 9, 1, 1, 2, 7, 5};
    quickSort(arr, 0, arr.length - 1);

    for (int idx = 0; idx < arr.length; idx++) {
      System.out.format("%d\t", arr[idx]);
    }
  }
}
