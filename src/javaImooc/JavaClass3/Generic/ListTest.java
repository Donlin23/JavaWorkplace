package javaImooc.JavaClass3.Generic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * ????γ???
 * @author Administrator
 *
 */
public class ListTest {

	/**
	 * ?????????γ??List
	 */
	public List coursesToSelect;
	
	public ListTest() {
		this.coursesToSelect = new ArrayList();
	}
	
	/**
	 * ??????coursesToSelect????????γ?
	 */
	public void testAdd() {
		//????????γ????????????add??????????????γ?List??
		Course cr1 = new Course("1" , "?????");
		coursesToSelect.add(cr1);
		Course temp = (Course) coursesToSelect.get(0);
		System.out.println("?????γ??" + temp.id + ":" + temp.name); 
		
		Course cr2 = new Course("2", "C????");
		coursesToSelect.add(0, cr2);
		Course temp2 = (Course) coursesToSelect.get(0);
		System.out.println("?????γ??" + temp2.id + ":" + temp2.name);
		
		coursesToSelect.add(cr1);
		Course temp0 = (Course) coursesToSelect.get(2);
		System.out.println("?????γ??" + temp.id + ":" + temp.name); 
		
		
		//???·?????????????±??????
//		Course cr3 = new Course("3", "test");
//		coursesToSelect.add(4, cr3);
		
		Course[] course = {new Course("3", "??????"), new Course("4", "???????")};
		coursesToSelect.addAll(Arrays.asList(course));
		Course temp3 = (Course) coursesToSelect.get(2);
		Course temp4 = (Course) coursesToSelect.get(3);
		
		System.out.println("?????????γ??" + temp3.id + ":" + 
				temp3.name + ";" + temp4.id + ":" + temp4.name);
		
		Course[] course2 = {new Course("5", "??????"), new Course("6", "??????")};
		coursesToSelect.addAll(2, Arrays.asList(course2));
		Course temp5 = (Course) coursesToSelect.get(2);
		Course temp6 = (Course) coursesToSelect.get(3);
		System.out.println("?????????γ??" + temp5.id + ":" + 
				temp5.name + ";" + temp6.id + ":" + temp6.name);
		
	}
	
	/**
	 * ???List?е????????
	 * @param args
	 */
	public void testGet() {
		int size = coursesToSelect.size();
		System.out.println("??????γ?????");
		for(int i= 0 ; i < size; i++) {
			Course cr = (Course) coursesToSelect.get(i);
			System.out.println("?γ??" + cr.id + ":" + cr.name);
		}
	}
	
	/**
	 * ???????????????List
	 * @param args
	 */
	public void testIterator() {
		//????????iterator???????????????????
		Iterator<Course> it = coursesToSelect.iterator();
		System.out.println("??????γ???(?????????????)??");
		while(it.hasNext()) {
			Course cr = it.next();
			System.out.println("?γ??" + cr.id + ":" + cr.name);
		}
	}
	
	/**
	 * ???for each??????????????
	 * @param args
	 */
	public void testForEach() {
		System.out.println("??????γ???(???for each????)??");
		for (Object obj : coursesToSelect) {
			Course cr = (Course) obj;
			System.out.println("?γ??" + cr.id + ":" + cr.name);
		}
	}
	
	/**
	 * ???List?е????
	 * @param args
	 */
	public void testModify() {
		coursesToSelect.set(4, new Course("7", "???"));
	}
	
	/**
	 * ???List?е????
	 * @param args
	 */
	public void testRemove() {
//		Course cr = (Course) coursesToSelect.get(4);
		System.out.println("???????4λ?ú?5λ?????γ??");
		Course[] courses = {(Course) coursesToSelect.get(4), (Course) coursesToSelect.get(5)};
		coursesToSelect.removeAll(Arrays.asList(courses));
		//		coursesToSelect.remove(4);
		System.out.println("???????γ??");
		testForEach();
	}
	
	/**
	 * ??List??????Щ???????
	 * @param args
	 */
	public void testType() {
		System.out.println("?????List??????Щ????????????");
		coursesToSelect.add("?????γ????????????????????????");
	}
	
	public static void main( String[] args) {
		ListTest lt = new ListTest();
		lt.testAdd();
		lt.testType();
		lt.testForEach();
//		lt.testGet();
//		lt.testIterator();
//		lt.testForEach();
//		lt.testModify();
//		lt.testForEach();
//		lt.testRemove();
	}
}
