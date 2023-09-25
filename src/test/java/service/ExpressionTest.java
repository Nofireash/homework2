package service;

import entity.Fraction;
import junit.framework.TestCase;

import java.util.List;

public class ExpressionTest extends TestCase {

    Expression expression=new ExpressionImpl();

    public void testCreateExpression() {
        List<String> expression = this.expression.createExpression(5, 5);
        for (String s : expression) {
            System.out.println(s);
        }
    }

    public void testWriteToFile() {
        String s = new Fraction(0, 4).transferFraction();
        System.out.println(s);
    }

    public void testAnswerToFile() {
    }
}