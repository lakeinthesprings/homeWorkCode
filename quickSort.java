import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

class quickSort{
	public static void main(String[] args) throws FileNotFoundException {
		int arr[] = new int[]{3,55,45,12,8,6,41,76,100,99};
		System.out.println("Array 1 test case, unsorted sorted: ");
		System.out.println("Array test sorted? " + Boolean.toString(isSorted(arr, arr.length)));
		quickSort ob = new quickSort();
		System.out.println(Arrays.toString(arr));
		ob.recursionCall(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));		
		System.out.println("Array test sorted? " + Boolean.toString(isSorted(arr, arr.length)));
		
		Scanner scannerTen = new Scanner(new File("problem5.6test1.txt"));
		
		int [] arrTen = readBufferFiletoInt("problem5.6test1.txt", 10);
		int [] arrHun = readBufferFiletoInt("problem5.6test2.txt", 100);
		int [] arrTenTho = readBufferFiletoInt("problem5.6test3.txt", 10000);
		
		
		System.out.println("\n \n Array 10, unsorted sorted: ");
		
		System.out.println(Arrays.toString(arrTen));
		System.out.println("Array 10 sorted? " + Boolean.toString(isSorted(arrTen, arrTen.length)));
		ob.recursionCall(arrTen, 0, arrTen.length-1);
		System.out.println(Arrays.toString(arrTen));	
		System.out.println("Array 10 sorted? " + Boolean.toString(isSorted(arrTen, arrTen.length)));
		
		System.out.println("\n \n Array 100, unsorted sorted: ");
		System.out.println(Arrays.toString(arrHun));
		System.out.println("Array 100 sorted? " + Boolean.toString(isSorted(arrHun, arrHun.length)));
		ob.recursionCall(arrHun, 0, arrHun.length-1);
		System.out.println(Arrays.toString(arrHun));
		System.out.println("Array 100 sorted? " + Boolean.toString(isSorted(arrHun, arrHun.length)));
		
		
		System.out.println("\n \n Array 10000, unsorted sorted: ");
		System.out.println("Array 1000 sorted? " + Boolean.toString(isSorted(arrTenTho, arrTenTho.length)));
		ob.recursionCall(arrTenTho, 0, arrTenTho.length-1);
		System.out.println("Array 1000 sorted? " + Boolean.toString(isSorted(arrTenTho, arrTenTho.length)));
	}//main
	
	public int partitionCall(int[] array, int left, int right) {
        int pivot = array[left];
        
        while(left<=right) {
            while(array[left] < pivot)
                left++;
            while(array[right] > pivot)
                right--;
            if(left<=right) {
                int tmp = array[left];
                array[left] = array[right];
                array[right] = tmp;
                left++;
                right--;
            }
        }   
        return left;
    } //partitionCall
	
    public void recursionCall(int[] a, int low, int high) {

    	int idx = partitionCall(a, low, high);
      
    	if(low < idx-1) {
           recursionCall(a, low, idx-1);
        }
    	if(high > idx) {
           recursionCall(a, idx, high);
        }
    } //recursionCall
    
    public static int[] readBufferFiletoInt(String file, int size) throws FileNotFoundException {
		Scanner scannerTen = new Scanner(new File(file));
		int [] array = new int [size];
		int i = 0;
		while(scannerTen.hasNextInt())
		{
			array[i++] = scannerTen.nextInt();
		}
		
		scannerTen.close();
		return array;
    	
    }
    
    static boolean isSorted(int arr[], int n){
        if (arraySortedOrNot(arr, n) != 0)
            return true;
        else
            return false;
    }
    static int arraySortedOrNot(int arr[], int n)
    {
        if (n == 1 || n == 0)
            return 1;
        if (arr[n - 1] < arr[n - 2])
            return 0;
 
        // Last pair was sorted
        // Keep on checking
        return arraySortedOrNot(arr, n - 1);
    }
}