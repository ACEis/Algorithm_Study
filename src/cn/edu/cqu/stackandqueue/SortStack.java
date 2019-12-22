package cn.edu.cqu.stackandqueue;
/**
 * 将栈进行排序，只允许使用一个栈
 */

import java.util.Stack;

public class SortStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(2);
        stack.push(1);
        stack.push(5);
        stack.push(4);
        stack.push(3);
        sortStack(stack);
        while (!stack.empty()){
            System.out.println(stack.pop());
        }
    }

    public static void sortStack(Stack<Integer> stack){
        Stack<Integer> help = new Stack<>();
        while(!stack.empty()){
            int curr = stack.pop();
            int count = 0;
            while (!help.empty() && curr > help.peek()){
                stack.push(help.pop());
                count++;
            }
            help.push(curr);
            while (count != 0){
                help.push(stack.pop());
                count--;
            }
        }
        while (!help.empty()){
            stack.push(help.pop());
        }
    }
}
