package basic.Integer;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/*
 * @author xjc
 * @date 2021-06-21
 * @desc 自动拆箱解箱
 */
public class IntegerStudy {
	@Test
	public void testJianIngeter() {
		for (int i = 0; i < 150; i++) {
			Integer a = i;
			Integer b = i;
			System.out.println(i + " " + (a == b));
		}

	}

	@Test
	public void testHHHxjc() {
		Map<Integer, Integer> mapA = new HashMap<>();
		Map<Integer, Integer> mapB = new HashMap<>();
		for (int i = 0; i < 150; i++) {
			mapA.put(i, i);
			mapB.put(i, i);
		}
		for (int i = 0; i < 150; i++) {
			System.out.println(i + " " + (mapA.get(i) == mapB.get(i)));
		}

	}

	public static void main(String[] args) {
		// 自动拆箱解箱
		Integer a = 1;

		// 输出内存地址的方法
		int identityHashCode = System.identityHashCode(a);

		// Integer.class在装载（Java虚拟机启动）时，其内部类型IntegerCache的static块即开始执行，实例化并暂存数值在-128到127之间的Integer类型对象。
		// 当自动装箱int型值在-128到127之间时，即直接返回IntegerCache中暂存的Integer类型对象。

		// 为什么Java这么设计？我想是出于效率考虑，因为自动装箱经常遇到，尤其是小数值的自动装箱；而如果每次自动装箱都触发new，
		// 在堆中分配内存，就显得太慢了；所以不如预先将那些常用的值提前生成好，自动装箱时直接拿出来返回。哪些值是常用的？就是-128到127了
	}
}
