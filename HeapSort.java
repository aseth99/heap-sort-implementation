import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
//put all jars in home folder, right click components and add to build path
/**
 * Lab 1: Java Basics, Heap Sort and Eclipse <br />
 * The {@code HeapSort} class
 */
public class HeapSort {
    /**
     * The heap sort procedure
     * @param numbers   {@code int[]} The integer array to be sorted
     */
    public static void sort(int[] numbers) {
        // TODO: Lab 1 -- write heapsort here
        //parent = (node - 1)/2
        //lchild = (node*2)+1, rchild = (node*2)+2
        //node !0 && node % 2 == 1, means it is an odd #, will be lchild
        //node !0 && node % 2 == 0, means it is an even #, will be rchild
        int lsize = numbers.length;
        int size = lsize-1;
        heap(numbers);
        //for (int n: numbers)
        //    System.out.print(n + " ");
        //System.out.println();
        //int [] sortedarray = new int [numbers.length];
        for (int i = size; i >= 0; i--){
            //sortedarray[i] = numbers[0];
            int temp = numbers[i];
            numbers[i] = numbers[0];
            numbers[0] = temp;
            sorting(numbers, i-1, 0);
        }
    }
    public static void sorting(int[] array, int size, int index) {

        int i = index;
        int lchild = (i*2)+1; //lchild of a (parent at i)
        int rchild = (i*2)+2; //rchild of a (parent at i)
        if (rchild < size+1){
            if (array[lchild] > array[rchild]){
                if (array[i] < array[lchild]){
                    int temp = array[i];
                    array[i] = array[lchild];
                    array[lchild] = temp;
                    i = lchild;
                    sorting(array, size-1, i);
                }
            }
            else if (array[rchild] > array[lchild]){
                if (array[i] < array[rchild]){
                    int temp = array[i];
                    array[i] = array[rchild];
                    array[rchild] = temp;
                    i = rchild;
                    sorting(array, size-1, i);
                }
            }
            else if (array[i] < array[lchild]){
                int temp = array[i];
                array[i] = array[lchild];
                array[lchild] = temp;
                i = lchild;
                sorting(array, size-1, i);
            }
        }
        else if (lchild < size +1){
            if (array[i] < array[lchild]){
                int temp = array[i];
                array[i] = array[lchild];
                array[lchild] = temp;
                i = lchild;
                sorting(array, size-1, i);
            }
            
        }
        
    }
    
    
    public static void heap(int[] array) {
        int index = (array.length) - 1;
        for (int i = 0; i < array.length; i++){
            heaping(array, i);
        }
    }
    public static void heaping(int[] heaparray, int index) {        
            
            int i = index;
            int parent = (i -1)/2; //parent of a (child at i)
            //int lchild = (i*2)+1; //lchild of a (parent at i)
            //int rchild = (i*2)+2; //rchild of a (parent at i)
            if ((i != 0) && (i%2 == 1)) {//this is a left child
                if (heaparray[parent] < heaparray[i]) {
                    int temp = heaparray[i];
                    heaparray[i] = heaparray[parent];
                    heaparray[parent] = temp;
                    i = parent;
                }
                else {
                    i = parent;
                }
            }
            if ((i != 0) && (i%2 == 0)) { // this is a right child
                if (heaparray[parent] < heaparray[i]) {
                    int temp = heaparray[i];
                    heaparray[i] = heaparray[parent];
                    heaparray[parent] = temp;
                    i = parent;
                }
                else {
                    i = parent;
                }
            }
            if (i != 0){
                heaping(heaparray, i);
            }
        }
        
     

    /**
     * Main entry: test the HeapSort
     * @param args      {@code String[]} Command line arguments
     */
    public static void main(String[] args) {
        int[] numbers = new int[10];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = (int) (Math.random() * 200);
            System.out.print(numbers[i] + " ");
        } // for (int i = 0; i < numbers.length; i++)
        System.out.println();

        sort(numbers);

        for (int n: numbers){
            SimpleWriter out = new SimpleWriter1L();
            out.print(n + " ");
            out.close();
        }
        System.out.println();
    }

}
