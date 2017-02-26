package sync;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TypeTest {

	@Test
	public void test1(){
		People<Student> p1 = new People<Student>();
		p1.setT(new Student());
		p1.getT().score = 1;
		System.out.println(p1.getT().score);
		
		System.out.println(print(new Teacher(),new Student()));
		List<String> list = new ArrayList<String>();
 	}
	
	public static <T> String  print(Teacher teacher,T t) {
		return teacher.getSubject();
	}
}


class People<T> {
	private T t;
	String name;
	int age;
	
	public T getT() {
		return t;
	}
	public void setT(T t) {
		this.t = t;
	}
	
}

class Student{
	int score;
}

class Teacher implements Comparable<String>{

	private String subject;
	
	public int compareTo(String o) {
		
		return o.compareTo("a");
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	
}