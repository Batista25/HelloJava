package cn.chenshi.helloJava.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ClassUtil {
	/**
	 * ��ӡ�����Ϣ��ֻ������ĳ�Ա����
	 * @param Object obj 
	 */
	public static void printClassMethodMessage(Object obj) {
		//Ҫ��ȡ�����Ϣ������Ҫ��ȡ���������
		Class<?> c = obj.getClass();//���ݵ����ĸ�����Ķ���c���Ǹ������������
		//��ȡ�������
		System.out.println("��������ǣ�"+c.getName());
		
		/**
		 * Method�࣬��������
		 * һ����Ա��������һ��Method����
		 * getMethods()��ȡ�������е�public��������������̳ж�����
		 * getDeclaredMethods()��ȡ���������Լ������ķ��������ʷ���Ȩ��
		 */
		Method[] methods = c.getMethods();//c.getDeclaredMethods();
		for (Method method : methods) {
			//�õ������ķ���ֵ���͵�������
			Class<?> returnType = method.getReturnType();
			System.out.print(returnType.getSimpleName()+" ");
			//�õ�����������
			System.out.print(method.getName()+"(");
			//��ȡ�������ͣ��õ����ǲ����б�����͵�������
			Class<?>[] paramTypes = method.getParameterTypes();
			for (Class<?> class1 : paramTypes) {
				System.out.print(class1.getName()+",");
			}
			System.out.println(")");
		}
		
	}

	/**
	 * ��ӡ���Ա��������Ϣ
	 * @param Object obj 
	 */
	public static void printFieldMessage(Object obj) {
		Class<?> c = obj.getClass();
		/*
		 * ��Ա����Ҳ�Ƕ���
		 * java.lang.reflect.Field��װ�˹��ڳ�Ա�����Ĳ���
		 * getFields()��ȡ�������е�public�ĳ�Ա������Ϣ
		 * getDeclaredFields()��ȡ���Ǹ����Լ������ĳ�Ա������Ϣ
		 */
		//Field[] fields = c.getFields();
		Field[] fields = c.getDeclaredFields();
		for (Field field : fields) {
			//�õ���Ա���������͵�������
			Class<?> fieldType = field.getType();
			String typeName = fieldType.getName();
			String fieldName = field.getName();
			System.out.println(typeName+" "+fieldName);
		}
	}
	
	/**
	 * ��ӡ����Ĺ��캯������Ϣ
	 * @param obj
	 */
	public static void printConMessage(Object obj) {
		Class<?> c = obj.getClass();
		/*
		 * ���캯��Ҳ�Ƕ���
		 * java.lang.Constructor�з�װ�˹��캯������Ϣ
		 * getConstructors()��ȡ���е�public���캯��
		 * getDeclaredConstructors()��ȡ���еĹ��캯��
		 */
		//Constructor<?>[] constructors = c.getConstructors();
		Constructor<?>[] constructors = c.getDeclaredConstructors();
		for (Constructor<?> constructor : constructors) {
			System.out.print(constructor.getName()+"(");
			//��ȡ���캯���Ĳ����б��õ����ǲ����б��������
			Class<?>[] paramTypes = constructor.getParameterTypes();
			for (Class<?> class1 : paramTypes) {
				System.out.print(class1.getName()+",");
			}
			System.out.println(")");
		}
		
		
	}

}
