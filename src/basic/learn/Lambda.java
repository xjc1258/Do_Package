package learn;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
/*
 * lambda表达式的使用
 */
public class Lambda {

	public static void main(String[] args) {
		//1.
		List<Student> list = Stream.of(new Student("xjc",22,176),
				new Student("xjw",23,175),
				new Student("xjd",25,174)
				).collect(Collectors.toList());
		System.out.println(list);
		
		//2
		//filter就是过滤的意思，内部是predicate接口
		List<Student> list2 = new ArrayList<Student>(3);
		list2.add(new Student("xjw",24,178));
		list2.add(new Student("xjw",25,178));
		list2.add(new Student("xjw",26,175));
		
		List<Student> list3 = list2.stream().
				filter(stu ->stu.height < 178).
				collect(Collectors.toList());
		System.out.println(list3);
		
		//3.map的使用----将student对象转换为String对象，获取student的名字
		List<String> nameList = list2.stream().map(student -> student.getName()).collect(Collectors.toList());
		System.out.println(nameList);
		
		
		//4.flatMap---将多个Stream和成一个Stream
		/*
		List<Student> studentList = Stream.of(list2,
            asList(new Student("艾斯", 25, 183),
                    new Student("雷利", 48, 176)))
            .flatMap(students1 -> students1.stream()).collect(Collectors.toList());
        System.out.println(studentList);
        */
        
        //5.集合中求最大或最小值，使用流就很方便。及早求值
        Optional<Student> max = list2.stream()
        		.max(Comparator.comparing(stu -> stu.getAge()));
        Optional<Student> min = list2.stream()
        		.min(Comparator.comparing(stu -> stu.getAge()));
        //判断是否有值
        if (max.isPresent()) {
        	System.out.println(max.get());
        }
        if (min.isPresent()) {
        	System.out.println(min.get());
        }
        
        //6.count的功能
        
        long count = list.stream().filter(pre -> pre.getAge() <18).count();
        System.out.println(count);
        //7.reduce操作：reduce操作可以实现一组值中生成一个值
        Integer reduce = Stream.of(1,2,3,4,5,6).reduce(0,(acc,x) -> acc+ x);
        System.out.println(reduce);
	}
}
