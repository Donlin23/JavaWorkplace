package CodingInterviewGuide.StackAndQueue_01;

import java.util.Stack;

/**
 * @Author:Donlin
 * @Description: 实现一个特殊的栈，在实现栈的基本功能的基础上，再实现返回栈中最小元素的操作
 * @Date: Created in 16:23 2018/3/28
 * @Version: 1.0
 */
public class MyStack1 { //方案一
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public MyStack1() {
        this.stackData = new Stack<Integer>();
        this.stackMin = new Stack<Integer>();
    }

    /**
     * 压栈，将数据压入栈中
     * @param newNum
     * @throws Exception
     */
    public void push(int newNum) {
        if (this.stackMin.empty()){
            this.stackMin.push(newNum);
        }else if (newNum <= this.stackMin.peek()){
            this.stackMin.push(newNum);
        }
        this.stackData.push(newNum);
    }

    /**
     * 出栈，将数据提出栈顶
     * @return
     */
    public int pop() {
        if (stackData.empty()){
            throw new RuntimeException("The stack is empty.");
        }
        int value = stackData.pop();
        if (value == this.stackMin.peek()){
            stackMin.pop();
        }
        return value;
    }

    public int getMin(){
        if (this.stackMin.empty()){
            throw new RuntimeException("The stack is empty.");
        }
        return stackMin.peek();
    }
}

class MyStack2{ //方案二
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    /**
     * 压栈
     * @param newNum
     */
    public void push(int newNum){
        stackData.push(newNum);

        if (stackMin.empty()){
            stackMin.push(newNum);
        }else if (newNum <= stackMin.peek()){
            stackMin.push(newNum);
        }else {
            stackMin.push(stackMin.peek());//重复压入最小值
        }

    }

    /**
     * 出栈
     * @return
     */
    public int pop(){
        if (stackData.empty()){
            throw new RuntimeException("The stack is empty.");
        }
        stackMin.pop();
        return stackData.pop();
    }

    public int getMin(){
        if (stackMin.empty()){
            throw new RuntimeException("The stack is empty");
        }
        return this.stackMin.peek();
    }
}
