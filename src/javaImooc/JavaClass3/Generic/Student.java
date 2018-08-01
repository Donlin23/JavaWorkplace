package javaImooc.JavaClass3.Generic;

import java.util.HashSet;
import java.util.Set;

/**
 * ѧ����
 * @author Administrator
 *
 */
public class Student {

	public String id;
	
	public String name;
	
	public Set<Course> courses;

	public Student(String id, String name) {
		this.id = id;
		this.name = name;
		this.courses = new HashSet<Course>();
	}
}
