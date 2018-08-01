package JVMDemo;

/**
 * @Author:Donlin
 * @Description: 一次对象的自我拯救的演示（不推荐使用）
 *                  说明：1.对象可以在被GC时自我拯救
 *                        2.这种自救的机会只有一次，因为一个对象的finalize()方法最多只会被系统自动调用一次，在gc()自动触发
 * @Date: Created in 21:23 2018/3/1
 * @Version: 1.0
 */
public class FinalizeEscapeGC {
    public static FinalizeEscapeGC SAVE_HOOK = null;

    public void isAlive(){
        System.out.println("Yes,I am still alive :)");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("Finalize method executed!");
        FinalizeEscapeGC.SAVE_HOOK = this;
    }

    public static void main(String[] args) throws InterruptedException {
        SAVE_HOOK = new FinalizeEscapeGC();

        //对象第一次成功拯救自己
        SAVE_HOOK = null;
        System.gc();
        //因为finalize()方法优先级很低，所以暂停0.5秒以等待它执行
        Thread.sleep(500);
        if (SAVE_HOOK != null){
            SAVE_HOOK.isAlive();
        }else {
            System.out.println("No,I am dead :(");
        }

        //下面这段代码与上面的完全相同，但这次自救却失败了
        SAVE_HOOK = null;
        System.gc();
        //因为finalize方法优先级很低，所以暂停0.5秒等待它执行
        Thread.sleep(500);
        if (SAVE_HOOK != null){
            SAVE_HOOK.isAlive();
        }else {
            System.out.println("No,I am dead :(");
        }
    }
}
