package cn.edu.cqu.stackandqueue;

import java.util.Stack;

public class StackReverse {
    public static void main(String[] args) {

    }

    public static void reverse(Stack<Integer> stack){
        if(stack.empty()){
            return;
        }
        int result = get(stack);
        reverse(stack);
        stack.push(result);
    }


    //移除栈顶元素并返回
    public static int get(Stack<Integer> stack){
        int result = stack.pop();
        if (stack.empty()){
            return result;
        }else {
            int next = get(stack);
            stack.push(result);
            return next;
        }
    }
}
