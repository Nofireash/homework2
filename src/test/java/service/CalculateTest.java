package service;

import junit.framework.TestCase;

public class CalculateTest extends TestCase {

    Calculate calculate=new CalculateImpl();

    public void testFourKindCalculate() {

    }

    public void testCalculate() {
        String calculate = this.calculate.calculate("1'1/8 * 3/4 + 2'2/3 / 4");
        System.out.println(calculate);
    }

    public void testTraversing() {
    }
}