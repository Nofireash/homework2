package service;

import constant.PriorityTable;
import entity.Fraction;
import exception.DivisionWrongException;
import exception.WrongOperationException;
import utils.FractionUtil;

import java.util.Stack;

public class CalculateImpl implements Calculate{


    @Override
    public Fraction fourKindCalculate(Fraction f1,Fraction f2, String operator) {
        Fraction result;
        switch (operator) {
            case "+":
                result = FractionUtil.add(f1,f2);
                break;
            case "-":
                result = FractionUtil.sub(f1,f2);
                break;
            case "*":
                result = FractionUtil.multiplication(f1,f2);
                break;
            case "/":
                // 除数不为0则返回结果，除数为0则报错
                if (f2.getDenominator() != 0) {
                    result = FractionUtil.div(f1,f2);
                } else {
                    throw new DivisionWrongException();
                }
                break;
            default:
                throw new WrongOperationException();
        }
        return result;
    }

    @Override
    public String calculate(String str) {
        String[] compute = str.split(" ");
        //存后缀表达式
        Stack<String> stack = new Stack<>();
        //放操作符
        Stack<String> optStack = new Stack<>();
        //放数字结果
        Stack<Fraction> numStack = new Stack<>();
        for (String s : compute) {
            // 带分数
            if (s.matches("^(\\d+)'(\\d+)\\/(\\d+)$")) {
               // 直接压入栈中，作为一个数来计算
                stack.push(s);
            }
            //匹配数字
            else if (s.matches("-?\\d+(\\.\\d+)?")) {
                stack.push(s);
            } else if (optStack.isEmpty()) {
                optStack.push(s);
            }
            //判断符号
            else if ("(".equals(s)) {
                optStack.push(s);
            } else if (")".equals(s)) {
                while (!"(".equals(optStack.peek())) {
                    stack.push(optStack.pop());
                }
                //找到(
                optStack.pop();
            }
            //加减乘除入栈
            else if ("+".equals(s) || "-".equals(s) || "*".equals(s)
                    || "/".equals(s)) {
                while ((!optStack.isEmpty()) && (PriorityTable.Priority(s) <= PriorityTable.Priority(optStack.peek()))) {
                    stack.push(optStack.pop());
                }
                optStack.push(s);
            }
            //数字小数点直接入栈
            else {
                stack.push(s);
            }
        }
        //当操作符栈不为空，将操作符全部弹入stack
        while (!optStack.isEmpty()) {
            stack.push(optStack.pop());
        }
        //numStack=
        Stack<Fraction> traversing = Traversing(stack, numStack);
        return traversing.pop().transferFraction();
    }

    @Override
    public Stack<Fraction> Traversing(Stack<String> stack,Stack<Fraction> numStack){
        for (String l : stack) {
            Fraction num1, num2;
            //正则表达式匹配分数
            if (l.matches("^(\\d+)(?:'(\\d+))?/(\\d+)$")){
                numStack.push(FractionUtil.Transform(l,false));
            } else if (l.matches("^\\d+$")){
                numStack.push(FractionUtil.Transform(l,true));
            }
            else {
                if(numStack.isEmpty()){
                    num1 = new Fraction(1,0);
                }
                else {
                    num1 = numStack.pop();
                }
                if(numStack.isEmpty()){
                    num2 = new Fraction(1,0);
                }
                else {
                    num2 = numStack.pop();
                }
                Fraction calculate = fourKindCalculate(num2,num1,l);
                numStack.push(calculate);
            }
        }
        return  numStack;
    }
}
