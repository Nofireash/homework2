package main;

import service.Calculate;
import service.CalculateImpl;
import service.Expression;
import service.ExpressionImpl;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Expression expression = new ExpressionImpl();
        Calculate calculate = new CalculateImpl();
        String answerTemp;
        List<String> expression1 = expression.createExpression(10000, 10);
        List<String> answerList = new ArrayList<>();
        expression.writeToFile("Exercises.txt");
        for (String s : expression1) {
            String result = calculate.calculate(s);
            answerTemp = s + " =" + result;
            System.out.println(answerTemp);
            answerList.add(answerTemp);
        }
        expression.answerToFile(answerList, "Answers.txt");
    }
}
