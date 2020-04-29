package com.leetcode.zh3ng.solutions.April30Days;

import java.util.Stack;

/*
 * created by zhangxingang on 2020/04/10
 */
public class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (minStack.size() == 0||minStack.peek() > x){
            minStack.push(x);
        }else{
            minStack.push(minStack.peek());
        }
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();

        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);

        System.out.println(minStack.getMin());

        minStack.pop();


        System.out.println(minStack.top());
        System.out.println(minStack.getMin());

    }
}
