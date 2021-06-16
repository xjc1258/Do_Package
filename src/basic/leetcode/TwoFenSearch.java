package basic.leetcode;
import java.util.Arrays;
public class TwoFenSearch {
		public static void main(String[] args) {
			int[] array = {2, 5, 12, 34, 56, 98, 99, 100, 101, 102, 212, 500};
			int targetElement = 99;
			System.out.println("要操作的数组： " + Arrays.toString(array));
			int result = binarySearch(array, targetElement);
			System.out.println(targetElement + "在数组" + Arrays.toString(array) + "中的角标为： " + result);
		}
		public static int binarySearch(int[] array, int targetElement) {
			int leftIndex = 0, rightIndex = array.length - 1, middleIndex = (leftIndex + rightIndex) / 2;
			while(leftIndex <= rightIndex) {
				int middleElement = array[middleIndex];
				if(targetElement < middleElement) {
					rightIndex = middleIndex - 1;
				}else if(targetElement > middleElement) {
					leftIndex = middleIndex + 1;
				}else {
					return middleIndex;
				}
				middleIndex = (leftIndex + rightIndex) / 2;
			}
			return -1;
		}
}	