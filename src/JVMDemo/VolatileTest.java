package JVMDemo;

/**
 * @Author:Donlin
 * @Description: volatile关键字的使用
 * @Date: Created in 20:31 2018/3/15
 * @Version: 1.0
 */
public class VolatileTest {
    public static volatile int race = 0;

    public static void increase(){
        race++;
    }

    private static final int THREAD_COUNT = 20;

    public static void main(String[] args) {
        Thread[] threads = new Thread[THREAD_COUNT];
        for (int i = 0; i < THREAD_COUNT; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 10000; j++) {
                        increase();
                    }
                }
            });
            threads[i].start();
        }

        //等待所有累加的线程都结束
        while(Thread.activeCount() > 1){
            Thread.yield();
        }

        System.out.println("race:" + race);
    }
}
