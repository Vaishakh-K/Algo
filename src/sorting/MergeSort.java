// Author - Vaishakh K
package sorting;

public class MergeSort {
  public static void merge(int[] arr, int low, int mid, int high) {
    int lenA = mid - low + 1;
    int lenB = high - mid;

    int[] arrA = new int[lenA];
    int[] arrB = new int[lenB];

    // Copy content from low to mid to arrA
    for (int idx = 0; idx < lenA; idx++) {
      arrA[idx] = arr[low + idx];
    }

    // Copy content from mid + 1 to high to arrB
    for (int idx = 0; idx < lenB; idx++) {
      arrB[idx] = arr[mid + 1 + idx];
    }

    int idxA = 0;
    int idxB = 0;
    int idxRes = low;

    while (idxA < lenA && idxB < lenB) {
      if (arrA[idxA] <= arrB[idxB]) {
        arr[idxRes++] = arrA[idxA++];
      } else {
        arr[idxRes++] = arrB[idxB++];
      }
    }

    while (idxA < lenA) {
      arr[idxRes++] = arrA[idxA++];
    }

    while (idxB < lenB) {
      arr[idxRes++] = arrB[idxB++];
    }
  }

  public static void mergeSort(int[] arr, int low, int high) {
    if (low < high) {
      int mid = low + (high - low) / 2;
      mergeSort(arr, low, mid);
      mergeSort(arr, mid + 1, high);

      merge(arr, low, mid, high);
    }
  }

  public static void main (String[] args) {
    int[] arr = {3, 5, 0, 17, 9, 1, 1, 2, 7, 5};
    mergeSort(arr, 0, arr.length - 1);

    for (int idx = 0; idx < arr.length; idx++) {
      System.out.format("%d\t", arr[idx]);
    }
  }
}
