package cn.edu.cqu.stackandqueue;

import java.util.Stack;

public class QueueWithTwoStack {
    public static void main(String[] args) {

    }
}

class QueueWithStack{
    Stack<Integer> stackPush = new Stack();
    Stack<Integer> stackPop = new Stack();
    public void add(int element){
        stackPush.push(element);
    }

    public int poll(){
        if(stackPop.empty()){
            while (!stackPush.empty()){
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.pop();
    }

    public int peek(){
        if(stackPop.empty()){
            while (!stackPush.empty()){
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.peek();
    }
}
