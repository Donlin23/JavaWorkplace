package javaImooc.JavaClass3.Colletions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * ��Ҫ��ɣ�
 * 1.ͨ��Collections.sort()��������Integer���͵�List��������
 * 2.��String���͵�List��������
 * 3.���������ͷ��͵�List����������StudentΪ����
 */
public class CollectionsTest {

	/**
	 * 1.ͨ��Collections.sort()��������Integer���͵�List��������
	 * ����һ��Integer���͵�List������ʮ��100���ڵĲ��ظ����������
	 * ����Collections.sort()���������������
	 */
	public void testSort1() {
		List<Integer> integerList = new ArrayList<Integer>();
		// ����ʮ��100���ڵĲ��ظ��������
		Random random = new Random();
		Integer k;
		for (int i = 0; i < 10; i++) {
			do {
				k = random.nextInt(100);
			} while (integerList.contains(k));
			integerList.add(k);
			System.out.println("�ɹ����������" + k);
		}
		System.out.println("-------------����ǰ--------------");
		for (Integer integer : integerList) {
			System.out.println("Ԫ�أ�" + integer);
		}
		Collections.sort(integerList);
		System.out.println("----------------�����-------------------");
		for (Integer integer : integerList) {
			System.out.println("Ԫ�أ�" + integer);
		}
	}
	
	/**
	 * 2.��String���͵�List��������
	 * ����String���͵�List��������������StringԪ�أ�
	 * ����sort�������ٴ����������˳��
	 */
	public void testSort2() {
		List<String> stringList = new ArrayList<String>();
		stringList.add("microsoft");
		stringList.add("google");
		stringList.add("lenovo");
		System.out.println("------------����ǰ-------------");
		for (String string : stringList) {
			System.out.println("Ԫ�أ�" + string);
		}
		Collections.sort(stringList);
		System.out.println("--------------�����---------------");
		for (String string : stringList) {
			System.out.println("Ԫ�أ�" + string);
		}
	}
	
	/**
	 * 3.���������ͷ��͵�List����������StudentΪ����
	 */
	public void testSort3() {
		List<Student> studentList = new ArrayList<Student>();
		Random random = new Random();
		studentList.add(new Student(random.nextInt(1000) + "", "Mike"));
		studentList.add(new Student(random.nextInt(1000) + "", "Angela"));
		studentList.add(new Student(random.nextInt(1000) + "", "Lucy"));
		studentList.add(new Student(10000 + "", "Beyonce"));
		System.out.println("--------------����ǰ---------------");
		for (Student student : studentList) {
			System.out.println("ѧ����" + student.id + ":" + student.name);
		}
		Collections.sort(studentList);
		System.out.println("----------------�����------------------");
		for (Student student : studentList) {
			System.out.println("ѧ����" + student.id + ":" + student.name);
		}
		Collections.sort(studentList, new StudentComparator());
		System.out.println("----------------�������������-----------------");
		for (Student student : studentList) {
			System.out.println("ѧ����" + student.id + ":" + student.name);
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CollectionsTest ct = new CollectionsTest();
//		ct.testSort1();
//		ct.testSort2();
		ct.testSort3();
	}

}
