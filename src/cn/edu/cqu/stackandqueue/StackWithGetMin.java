package cn.edu.cqu.stackandqueue;

import java.util.Stack;

public class StackWithGetMin {
    public static void main(String[] args) {
        StackGetmin s = new StackGetmin();
        s.push(3);
        s.push(4);
        s.push(5);
        s.push(1);
        s.push(2);
        s.push(1);
        System.out.println(s.getMin());
        s.pop();
        System.out.println(s.getMin());
        s.pop();
        System.out.println(s.getMin());
        s.pop();
        System.out.println(s.getMin());
        s.pop();
        System.out.println(s.getMin());
        s.pop();
        System.out.println(s.getMin());
        s.pop();
    }


}

class StackGetmin{
    Stack<Integer> stack = new Stack();
    Stack<Integer> stackmin = new Stack();
    public int pop(){
        stackmin.pop();
        return stack.pop();
    }

    public void push(int element){
        if(stack.empty() || element < stackmin.peek()){
            stack.push(element);
            stackmin.push(element);
        }else{
            stack.push(element);
            stackmin.push(stackmin.peek());
        }
    }

    public int getMin(){
        return stackmin.peek();
    }
}
