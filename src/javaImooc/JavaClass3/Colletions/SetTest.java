package javaImooc.JavaClass3.Colletions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SetTest {

	public List<Course> coursesToSelect;
	
	private Scanner console;
	
	public Student student;
	
	public SetTest() {
		coursesToSelect = new ArrayList<Course>();
		console = new Scanner(System.in);
	}
	
	/**
	 * ������coursesToSelect����ӱ�ѡ�γ�
	 */
	public void testAdd() {
		//����һ���γ̶��󣬲�ͨ������add��������ӵ���ѡ�γ�List��
		Course cr1 = new Course("1" , "���ݽṹ");
		coursesToSelect.add(cr1);
		Course temp = (Course) coursesToSelect.get(0);
//		System.out.println("����˿γ̣�" + temp.id + ":" + temp.name); 
		
		Course cr2 = new Course("2", "C����");
		coursesToSelect.add(0, cr2);
		Course temp2 = (Course) coursesToSelect.get(0);
//		System.out.println("����˿γ̣�" + temp2.id + ":" + temp2.name);
		
//		coursesToSelect.add(cr1);
//		Course temp0 = (Course) coursesToSelect.get(2);
//		System.out.println("����˿γ̣�" + temp.id + ":" + temp.name); 
		
		
		//���·������׳������±�Խ���쳣
//		Course cr3 = new Course("3", "test");
//		coursesToSelect.add(4, cr3);
		
		Course[] course = {new Course("3", "��ɢ��ѧ"), new Course("4", "�������")};
		coursesToSelect.addAll(Arrays.asList(course));
		Course temp3 = (Course) coursesToSelect.get(2);
		Course temp4 = (Course) coursesToSelect.get(3);
		
//		System.out.println("��������ſγ̣�" + temp3.id + ":" + 
//				temp3.name + ";" + temp4.id + ":" + temp4.name);
		
		Course[] course2 = {new Course("5", "�ߵ���ѧ"), new Course("6", "��ѧӢ��")};
		coursesToSelect.addAll(2, Arrays.asList(course2));
		Course temp5 = (Course) coursesToSelect.get(2);
		Course temp6 = (Course) coursesToSelect.get(3);
//		System.out.println("��������ſγ̣�" + temp5.id + ":" + 
//				temp5.name + ";" + temp6.id + ":" + temp6.name);
		
	}
	
	/**
	 * ͨ��for each�������ʼ���Ԫ��
	 * @param args
	 */
	public void testForEach() {
		System.out.println("�����¿γ̴�ѡ(ͨ��for each����)��");
		for (Object obj : coursesToSelect) {
			Course cr = (Course) obj;
			System.out.println("�γ̣�" + cr.id + ":" + cr.name);
		}
	}
	
	/**
	 * ����List��contains����
	 */
	public void testListContains() {
		// ȡ�ñ�ѡ�γ����еĵ�0��Ԫ��
		Course course = coursesToSelect.get(0);
		// ��ӡ���coursesToSelected�Ƿ����course����
		System.out.println("ȡ�ÿγ̣�" + course.name);
		System.out.println("��ѡ�γ����Ƿ�����γ̣�" + course.name + ", " + 
				coursesToSelect.contains(course));
		// ��ʾ����γ�����
		System.out.println("������γ����ƣ�");
		String name = console.next();
		// ����һ���µĿγ̶���ID�����ƣ���course������ȫһ��
		Course course2 = new Course();
		course2.name = name;
		System.out.println("�´����γ̣�" + course2.name);
		System.out.println("��ѡ�γ����Ƿ�����γ̣�" + course2.name + ", " +
				coursesToSelect.contains(course2));
		// ͨ��indexOf������ȡ��ĳԪ�ص�����λ��
		if (coursesToSelect.contains(course2))
			System.out.println("�γ̣�" + course2.name + "������λ��Ϊ��" + 
					coursesToSelect.indexOf(course2));
	}
	
	// ����ѧ������ѡ��
	public void createStudentAndSelectCours() {
		//����һ��ѧ������
		student = new Student("1", "С��");
		System.out.println("��ӭѧ����" + student.name + "ѡ�Σ�");
		//����һ��Scanner�����������մӼ�������Ŀγ�ID
		Scanner console = new Scanner(System.in);
		
		for (int i = 0; i < 3; i++) {
			System.out.println("������γ�ID");
			String courseId = console.next();
			for (Course cr : coursesToSelect) {
				if(cr.id.equals(courseId)) {
					student.courses.add(cr);
					/**
					 * Set�У����ĳ������������Ӷ��ٴΣ�
					 * ����ֻ�ᱣ��һ���ö��󣨵����ã���
					 * ���ң��������ǵ�һ����ӵ���һ��
					 */
//					student.courses.add(null);
//					student.courses.add(cr);
				}
			}
		}
	}
	
	/**
	 * ����Set��contains����
	 */
	public void testSetContains() {
		// ��ʾ����γ�����
		System.out.println("������ѧ����ѡ�Ŀγ����ƣ�");
		String name = console.next();
		// ����һ���µĿγ̶���ID�����ƣ���course������ȫһ��
		Course course2 = new Course();
		course2.name = name;
		System.out.println("�´����γ̣�" + course2.name);
		System.out.println("��ѡ�γ����Ƿ�����γ̣�" + course2.name + ", " +
				student.courses.contains(course2));
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SetTest st = new SetTest();
		st.testAdd();
		st.testListContains();
		st.testForEach();

//		st.createStudentAndSelectCours();
//		st.testSetContains();
//		
//		st.testForEachForSet(student);
	}

	public void testForEachForSet(Student student) {
		//��ӡ�����ѧ����ѡ�Ŀγ̣�
		System.out.println("��ѡ���ˣ�" + student.courses.size() + "�ſγ̣�");
		for (Course cr : student.courses) {
			System.out.println("ѡ���˿γ̣�" + cr.id + ":" + cr.name);
		}
	}
	
}
