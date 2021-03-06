package JVMDemo;

/**
 * @Author:Donlin
 * @Description: 单分派、多分派演示
 * @Date: Created in 11:12 2018/3/14
 * @Version: 1.0
 */
public class Dispatch {

    static class QQ{}
    static class _360{}

    public static class Father{
        public void hardChoice(QQ arg){
            System.out.println("Father choose QQ");
        }
        public void hardChoice(_360 arg){
            System.out.println("Father choose 360");
        }
    }

    public static class Son{
        public void hardChoice(QQ arg){
            System.out.println("Son choose QQ");
        }
        public void hardChoice(_360 arg){
            System.out.println("Son choose 360");
        }
    }

    public static void main(String[] args) {
        Father father = new Father();
        Son son = new Son();
        father.hardChoice(new _360());
        son.hardChoice(new QQ());
    }
}
