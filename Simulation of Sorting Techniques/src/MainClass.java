
public class MainClass {
    private static Output output = new Output();

    /**
     * This is main method which executes all the algorithm such as bubble sort, insertion sort, selection sort, merge sort,
 * and quick sort.
     * @param args
     */
    public static void main(String[] args) {
        String[] fileNames = new String[] {"Consumer_Complaints.csv", "exponential.csv", "normal.csv", "1500000 Sales Records.csv"};
        int[] datasets = new int[]{10000};
        Output.SIZE = fileNames.length * datasets.length * 5;
        Output.data = new Data[Output.SIZE];
        for(int i=0; i<fileNames.length; i++){
            for(int j=0; j<datasets.length; j++){
            	long inv_count = get_inversions(fileNames[i], datasets[j]);
                ExecuteMergeSort(fileNames[i], datasets[j], inv_count);
                ExecuteSelectionSort(fileNames[i], datasets[j], inv_count);
                ExecuteQuickSort(fileNames[i], datasets[j], inv_count);
                ExecuteBubbleSort(fileNames[i], datasets[j], inv_count);
                ExecuteInsertionSort(fileNames[i], datasets[j], inv_count);
            }
        }
        System.out.println(output.toString());
    }
    /**
     * This method gets the number of inversions of an array which is used to determine the degree of sorting
     * @param fileName
     * @param numberOfData
     */
    public static long get_inversions(String fileName, int numberOfData) {
        long inv_count = 0;
        Float array[] = InputReader.readCSV(fileName, numberOfData).toArray(new Float[0]);
        for(int i=0;i<array.length;i++){
            for(int j=i+1;j<array.length;j++){
                if (array[i] > array[j]){
                  inv_count = inv_count + 1;
                }
             }
          }
          return inv_count;
      }

    /**
     * This method executes the merge sort and finds the execution time and memory used by the algorithm.
     * @param fileName
     * @param numberOfData
     * @param inv_count
     */
    public static void ExecuteMergeSort(String fileName, int numberOfData, long inv_count){
        long sumExecutionTime = 0;
        long sumMemoryUsage = 0;
        for(int i=0; i<5; i++){
            long startMemoryUsage=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
            Float array[] = InputReader.readCSV(fileName, numberOfData).toArray(new Float[0]);
            long startTime = System.currentTimeMillis();
            SortingAlgorithms.Merge_sort(array, 0, array.length-1);
            long stopTime = System.currentTimeMillis();
            long elapsedTime = stopTime - startTime;
            sumExecutionTime += elapsedTime;
            long endMemoryUsage=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
            long actualMemUsed=endMemoryUsage-startMemoryUsage;
            sumMemoryUsage += actualMemUsed;
            System.gc();
        }
        Data data = new Data("MergeSort", fileName, numberOfData, sumExecutionTime/5, sumMemoryUsage/5, inv_count);
        output.Add(data);
    }
    /**
     * This method executes the selection sort and finds the execution time and memory used by the algorithm.
     * @param fileName
     * @param numberOfData
     * @param inv_count
     */

    public static void ExecuteSelectionSort(String fileName, int numberOfData, long inv_count){
        long sumExecutionTime = 0;
        long sumMemoryUsage = 0;
        for(int i=0; i<5; i++){
            long startMemoryUsage=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
            Float array[] = InputReader.readCSV(fileName, numberOfData).toArray(new Float[0]);
            long startTime = System.currentTimeMillis();
            SortingAlgorithms.Selection_sort(array);
            long stopTime = System.currentTimeMillis();
            long elapsedTime = stopTime - startTime;
            sumExecutionTime += elapsedTime;
            long endMemoryUsage=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
            long actualMemUsed=endMemoryUsage-startMemoryUsage;
            sumMemoryUsage += actualMemUsed;
            System.gc();
        }
        Data data = new Data("SelectionSort", fileName, numberOfData, sumExecutionTime/5, sumMemoryUsage/5, inv_count);
        output.Add(data);
    }
/**
 * This method executes the bubble sort and finds the execution time and memory used by the algorithm.
 * @param fileName
 * @param numberOfData
 * @param inv_count
 */
    public static void ExecuteBubbleSort(String fileName, int numberOfData, long inv_count){
       long sumExecutionTime = 0;
        long sumMemoryUsage = 0;
        for(int i=0; i<5; i++){
            long startMemoryUsage=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
            Float array[] = InputReader.readCSV(fileName, numberOfData).toArray(new Float[0]);
            long startTime = System.currentTimeMillis();
            SortingAlgorithms.Bubble_sort(array);
            long stopTime = System.currentTimeMillis();
            long elapsedTime = stopTime - startTime;
            sumExecutionTime += elapsedTime;
            long endMemoryUsage=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
            long actualMemUsed=endMemoryUsage-startMemoryUsage;
            sumMemoryUsage += actualMemUsed;
            System.gc();
        }
        Data data = new Data("BubbleSort", fileName, numberOfData, sumExecutionTime/5, sumMemoryUsage/5, inv_count);
        output.Add(data);
    }
    /**
     * This method executes the quick sort and finds the execution time and memory used by the algorithm.
     * @param fileName
     * @param numberOfData
     * @param inv_count
     */
    public static void ExecuteQuickSort(String fileName, int numberOfData, long inv_count){
       long sumExecutionTime = 0;
        long sumMemoryUsage = 0;
        for(int i=0; i<5; i++){
            long startMemoryUsage=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
            Float array[] = InputReader.readCSV(fileName, numberOfData).toArray(new Float[0]);
            long startTime = System.currentTimeMillis();
            SortingAlgorithms.Quick_sort(array,0, array.length-1);
            long stopTime = System.currentTimeMillis();
            long elapsedTime = stopTime - startTime;
            sumExecutionTime += elapsedTime;
            long endMemoryUsage=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
            long actualMemUsed=endMemoryUsage-startMemoryUsage;
            sumMemoryUsage += actualMemUsed;
            System.gc();
        }
        Data data = new Data("QuickSort", fileName, numberOfData, sumExecutionTime/5, sumMemoryUsage/5, inv_count);
        output.Add(data);
    }
    /**
     * This method executes the insertion sort and finds the execution time and memory used by the algorithm.
     * @param fileName
     * @param numberOfData
     * @param inv_count
     */
    public static void ExecuteInsertionSort(String fileName, int numberOfData, long inv_count){
       long sumExecutionTime = 0;
        long sumMemoryUsage = 0;
        for(int i=0; i<5; i++){
            long startMemoryUsage=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
            Float array[] = InputReader.readCSV(fileName, numberOfData).toArray(new Float[0]);
            long startTime = System.currentTimeMillis();
            SortingAlgorithms.Insertion_sort(array);
            long stopTime = System.currentTimeMillis();
            long elapsedTime = stopTime - startTime;
            sumExecutionTime += elapsedTime;
            long endMemoryUsage=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
            long actualMemUsed=endMemoryUsage-startMemoryUsage;
            sumMemoryUsage += actualMemUsed;
            System.gc();
        }
        Data data = new Data("InsertionSort", fileName, numberOfData, sumExecutionTime/5, sumMemoryUsage/5, inv_count);
        output.Add(data);
    }
}
