package java_programs;

public class Bublesort {

	public static void main(String[] args) {
//		
//		int arr[]={0,7,0,4,0,9,1,0,2,3,0,2};
//		for (int i = 0; i < arr.length; i++) {
//			for (int j = i+1; j < arr.length; j++) {
//				
//				if(arr[i]>arr[j]) {
//					int temp=arr[i];
//					arr[i]=arr[j];
//					arr[j]=temp;
//				}
//			}
//		}
//		for (int i : arr) {
//			System.out.print(i);
//		}
//		int arr[]={-1,4,9,8,5,54,65,2,34,46};
//		int max=arr[0];
//		int min=arr[0];
//		for (int i = 0; i < arr.length; i++) {
//			
//			if(max<arr[i]) {			
//				max=arr[i];
//			}else if (min>arr[i]) {
//				min=arr[i];
//			}
//		}
//		
//		System.out.println(min+"  "+max);
		int arr[]={12, 34, 45, 9, 8, 90, 3};
		;
	int[] ar=rearrangeEvenAndOdd(arr,arr.length);
	for (int i : ar) {
		System.out.println(i);
	}
	}
	
	static int[] rearrangeEvenAndOdd(int arr[], int n)
    {
        // variables
        int temp;
     
        // quick sort method
        for (int i =0,j= 0; i < n; i++) {
     
            // if array of element
            // is odd then swap
            if (arr[i] % 2 == 0) {
     
     
                // swap the element
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
        }
		return arr;
        
    }

}
