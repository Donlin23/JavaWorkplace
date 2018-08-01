package CodingInterviewGuide.StackAndQueue_01;

import java.util.Stack;

/**
 * @Author:Donlin
 * @Description: 编写一个类，用两个栈实现队列，支持队列的基本操作（add，poll，peek）
 * @Date: Created in 16:54 2018/3/29
 * @Version: 1.0
 */
public class TwoStackQueue {
    private Stack<Integer> stackPop;
    private Stack<Integer> stackPush;

    /**
     * 入队列操作
     * @param pushInt
     */
    public void add(int pushInt){
        this.stackPush.push(pushInt);
    }

    /**
     * 出队列操作
     * @return
     */
    public int poll(){
        if (stackPush.empty() && stackPop.empty()){
            throw new RuntimeException("The queue is empty.");
        }else if (stackPop.empty()){   //如果出队列的栈为空，那么入队列的栈全部压到出队列的栈中
            while(!stackPush.empty()){
                stackPop.push(stackPush.pop());
            }
        }
        return this.stackPop.pop();
    }

    /**
     * 取队列前头的值
     * @return
     */
    public int peek(){
        if (stackPush.empty() && stackPop.empty()){
            throw new RuntimeException("The queue is empty.");
        }else if (stackPop.empty()){
            while(!stackPush.empty()){
                stackPop.push(stackPush.pop());
            }
        }
        return this.stackPop.peek();
    }
}
