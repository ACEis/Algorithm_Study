package cn.edu.cqu.nowcoder.stackandqueue;

import java.util.Stack;

public class Offer20 {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> stackmin = new Stack<>();
    public void push(int node) {
        stack.push(node);
        if (stackmin.empty()) {
            stackmin.push(node);
        }else {
            stackmin.push((node < stackmin.peek()) ? node : stackmin.peek());
        }
    }

    public void pop() {
        if (!stack.empty()) {
            stackmin.pop();
            stack.pop();
        }
    }

    public int top() {
        if (!stack.empty()){
            return stack.peek();
        }else {
            return -1;
        }
    }

    public int min() {
        if (!stackmin.empty()) {
            return stackmin.peek();
        }else {
            return -1;
        }
    }
}

class Offer21{
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        int j = 0;
        while (i < pushA.length) {
            stack.push(pushA[i++]);
            while (!stack.empty() && stack.peek() == popA[j]){
                stack.pop();
                j++;
            }
        }
        return stack.empty();
    }
}
