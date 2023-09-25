package service;

import entity.Fraction;

import java.util.Stack;

/**
 * @author tms
 * @Date 2023/9/22
 */
public interface Calculate {
    /**
     * 加减乘除四则运算
     *
     * @param f1 数字1
     * @param f2 数字2
     * @param operator 操作符
     * @return 计算结果
     */
    Fraction fourKindCalculate(Fraction f1,Fraction f2, String operator);

    /**
     * 计算四则运算表达式
     *
     * @param str 四则运算表达式字符串
     * @return 答案字符串
     */
    String calculate(String str);

    /**
     * 遍历后缀表达式
     *
     * @param stack 后缀表达式
     * @param numStack 数字结果栈
     * @return 结果栈（仅有一个最后结果）
     */
    Stack<Fraction> Traversing(Stack<String> stack, Stack<Fraction> numStack);
}
