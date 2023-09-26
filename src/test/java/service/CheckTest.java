package service;

import org.junit.Test;

public class CheckTest {


    @Test
    public void con() throws Exception {
        CheckImpl check = new CheckImpl();
        System.out.println(check.checkPaper("D:\\homework2_2\\Answers.txt"));
    }

}
