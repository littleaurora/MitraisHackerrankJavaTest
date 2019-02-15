import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 
 */
/**
 * @author Carolina_FE905
 *
 */

	//Time to write a great code
public class NumberOne {

	public static String longestEvenWord(String input) {
		
		String [] array = input.split(" ");
//		Arrays.sort(array, new Comparator<String>() {
//
//			@Override
//			public int compare(String o1, String o2) {
//				// TODO Auto-generated method stub
//				return o2.length()-o1.length();
//			}
//		});
//		
//		String result = "00";
//		
//		for (int i=0; i<array.length; i++) {
//			if (array[i].length()%2==0) {
//				result = array[i];
//				break;
//			}
//		}
		
		String result = "00";
		int max = Integer.MIN_VALUE;
		
		for (int i=0; i<array.length; i++) {
			if (array[i].length()%2==0) {
				if (max < array[i].length()) {
					max = array[i].length();
					result = array[i];
				}
			}
		}
		
		return result;
	}
		
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while (true) {
			System.out.println(longestEvenWord(scan.nextLine()));
		}
	}
}
