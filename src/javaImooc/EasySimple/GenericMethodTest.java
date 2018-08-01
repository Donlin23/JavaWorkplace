package javaImooc.EasySimple;

/*
* 泛型（Generic）方法实例
 */

public class GenericMethodTest {
    public static <E> void printArray(E[] inputArray){
        //输出数组元素
        for(E element : inputArray){
            System.out.printf("%s ",element);
        }
        System.out.println();
    }

    public static void main(String args[]){
        Integer[] intArray = {1,2,3,4,5};
        Double[] doubleArray = {1.1,1.2,1.3,5.5};
        Character[] charArray = {'H','E','L','L','O'};

        System.out.println("第一组：");
        printArray(intArray);
        System.out.println("第二组：");
        printArray(doubleArray);
        System.out.println("第三组：");
        printArray(charArray);
    }
}
