package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import String.Person;

/*
 * @author xjc
 * @date 2021-05-18
 * @desc 移出元素,关于移出list中的元素的注意事项
 */
public class YiChuYuanSu {
	public static void main(String[] args) {
		int[] nums = { 1, 2, 2, 2, 2, 3, 4, 5, 6, 7, 8 };
		int num = 2;
		int removeElement = removeElement(nums, num);
		// System.out.println(removeElement);

		System.out.println(nums.length);
		arrayStudy();
		// study();
		functionHa();
	}

	public static int removeElement(int[] nums, int val) {
		if (nums == null || nums.length == 0)
			return 0;
		int j = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != val) {
				nums[j] = nums[i];
				j++;
			}
		}
		return j;
	}

	public static String arrayStudy() {
		// 基本数据类型的数组转换成集合,会将整个数组当作一个对象转换
		// 输出：[[I@2a139a55]
		int[] arr = { 11, 22, 33, 44, 55 };
		List<int[]> list = Arrays.asList(arr);
		System.out.println(list);
		// 将数组转换成集合,数组必须是引用数据类型
		// 输出：[11, 22, 33, 44, 55]
		Integer[] arr2 = { 11, 22, 33, 44, 55 };
		List<Integer> list2 = Arrays.asList(arr2);
		System.out.println(list2);
		return null;
	}

	public static void study() {// 这种方式是有问题的，不要用这中方式移除元素
		Integer[] arr2 = { 11, 22, 33, 44, 55 };
		List<Integer> list3 = Arrays.asList(arr2);
		Integer bb = 22;
		for (int i = 0; i < list3.size(); i++) {
			if (bb == list3.get(i)) {
				// list3.remove(i); //千万不要这样的移除
				list3.remove(bb);
			}
		}
		System.out.println(list3);
	}

	// 移除List<String>中指定的元素
	public static void remove(List<String> list, String target) {
		for (int i = list.size() - 1; i >= 0; i--) {
			String item = list.get(i);
			if (target.equals(item)) {
				list.remove(item);
			}
		}
	}//再测测2021-05-21

	/*
	 * 移除List<对象>中指定对象的时候，如果使用foreach循环好像有问题，使用iterator遍历应该最好。 使用for循环的时候好像会抛出
	 * ConcurrentModificationException 异常。
	 */
	public static void removeDutyList(List<Person> list, String target) {
		Iterator<Person> iterator = list.iterator();
		while (iterator.hasNext()) {
			Person dutyListVo = iterator.next();
			if (dutyListVo.getName().equals(target)) {
				iterator.remove();
			}

		}

	}

	public static void functionHa() {
		List<Integer> listInteger = new ArrayList<Integer>();
		listInteger.add(1);
		listInteger.add(2);
		listInteger.add(3);
		listInteger.add(4);
		System.out.println(listInteger);
		List<Integer> removeList = new ArrayList<Integer>();
		for (Integer i : listInteger) {
			if (i == 1 || i == 3) {
				// listInteger.remove(i);
				removeList.add(i);
			}
		}
		listInteger.removeAll(removeList);
		System.out.println(listInteger);

	}

}