/**
 * This class contains sorting algorithms such as bubble sort, insertion sort, selection sort, merge sort,
 * and quick sort.
 * @author Deeksha & sumitha
 *
 */

public class SortingAlgorithms {
/**
 * This method sorts an array using bubble sort.
 * This sorting technique works repeatedly swapping the adjacent elements if they are in an unsorted order.
 * @param arr
 * input array to the method.
 */
    public static void Bubble_sort(Float arr[]){
      int n = arr.length;
      for (int i =0 ; i < n-1 ; i++){
        for (int j=0 ; j <n-i-1;j++){
          if (arr[j] > arr[j+1]){
            Float temp = arr[j];
            arr[j] = arr[j+1];
            arr[j+1]=temp;
             }
          }
       }
    }
  /**
   * This method sorts an array using insertion sort.
   * Insertion sort checks each element in an array with the previous elements, resulting in a
   * growing sorted output list. This will continue until the whole list is sorted.
   * @param arr
   * input array to the method.
   */
   public static void Insertion_sort(Float arr[]){
      int n = arr.length;
      for (int i=1;i<n-1;i++){
        Float key = arr[i];
        int j = i-1;
        while ( j >=0 && key < arr[j]){
          arr[j+1] = arr[j];
          j = j-1;
        }
        arr[j+1] = key;
      }
    }

   /**
    * This method sorts an array using selection sort.
    * This sorting technique is an in-place comparison sort.
    * @param arr
    * input array to the method.
    */
    public static void Selection_sort(Float arr[]){
      int n = arr.length;
      for(int i=0;i<n;i++){
        int min_index = i;
        for (int j = i+1;j<n;j++){
          if (arr[j]<arr[min_index]){
            min_index = j;
          }
        }
        Float temp = arr[i];
        arr[i] = arr[min_index];
        arr[min_index] = temp;
      }
    }

    /**
     * This method sorts an array using merge sort.
     * This sorting algorithm is based on divide and conquer technique.
     * @param arr
     * input array to the method.
     * @param start
     * This method indicates starting index of an array.
     * @param end
     * This method indicates end index of an array.
     */
    public static void Merge_sort(Float arr[],int start,int end){
      if (end > start) {
          int mid = (start + end) / 2;
          Merge_sort(arr, start, mid);
          Merge_sort(arr, mid + 1, end);
          merge(arr, start, mid, end);
      }
    }


    private static void merge(Float[] A, int left, int middle, int right) {
        Float[] leftTmpArray = new Float[middle - left + 2];
        Float[] rightTmpArray = new Float[right - middle + 1];
        for (int i = 0; i <= middle - left; i++)
            leftTmpArray[i] = A[left + i];
        for (int i = 0; i < right - middle; i++)
            rightTmpArray[i] = A[middle + 1 + i];
        leftTmpArray[middle - left + 1] = Float.MAX_VALUE;
        rightTmpArray[right - middle] = Float.MAX_VALUE;
        int i = 0, j = 0;
        for (int k = left; k <= right; k++) {
            if (leftTmpArray[i] < rightTmpArray[j]) {
                A[k] = leftTmpArray[i];
                i++;
            } else {
                A[k] = rightTmpArray[j];
                j++;
            }
        }
    }
    /**
     * This method sorts an array using quick sort.
     * Quick sort is a highly efficient sorting algorithm and is based on partitioning of array
     * of data into smaller arrays.
     * @param arr
     * input array to the method.
     * @param start
     * This method indicates starting index of an array.
     * @param end
     * This method indicates end index of an array.
     */
    public static void Quick_sort(Float[] arr, int start, int end){
      int mid = partition(arr, start, end);
      if(mid-1>start) {
        Quick_sort(arr, start, mid - 1);
      }
      if(mid+1<end) {
        Quick_sort(arr, mid + 1, end);
      }
    }
    /**
     * @param arr
     * input array to a method.
     * @param start
     * This method indicates starting index of an array.
     * @param end
     * This method indicates end index of an array.
     * @return
     */

    private static int partition(Float[] arr, int start, int end){
        float pivot = arr[end];

        for(int i=start; i<end; i++){
            if(arr[i]<pivot){
                float temp= arr[start];
                arr[start]=arr[i];
                arr[i]=temp;
                start++;
            }

        }
        float temp = arr[start];
        arr[start] = pivot;
        arr[end] = temp;

        return start;
    }
}
