package service;

import entity.Fraction;
import utils.FileUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ExpressionImpl implements Expression {

    /**
     * 生成的表达式集合
     */
    ArrayList<String> expressionList = new ArrayList<>();
    /**
     * 写入文件的表达式的集合
     */
    ArrayList<String> expressionListToFile = new ArrayList<>();

    @Override
    public List<String> createExpression(Integer n, Integer r) {
        String[] operate = new String[]{"+", "-", "*", "/"};
        Random random = new Random();
        //随机产生的运算符个数
        int count;
        StringBuilder temp;
        String tempToFile;
        for (int i = 0; i < n; i++) {
            //[1,4)
            temp = new StringBuilder();
            count = random.nextInt(3) + 1;
            for (int j = 1; j <= count; j++) {
                Fraction fraction = new Fraction(random.nextInt(n), random.nextInt(n));
                String opt = operate[random.nextInt(4)];
                // 这里要判断是否分母可能为0，如果为0则按1来计算，分数类分母默认为1
                temp.append(fraction.transferFraction()).append(" ").append(opt).append(" ");
            }
            int x2 = random.nextInt(n);
            temp.append(x2);
            tempToFile = i+1+"、"+temp + "=";
            expressionList.add(temp.toString());
            expressionListToFile.add(tempToFile);
        }
        return expressionList;
    }

    @Override
    public void writeToFile(String fileName) {
        FileUtil.writeToFile(expressionListToFile,fileName);
    }

    @Override
    public void answerToFile(List<String> answerList, String fileName) {
        FileUtil.writeToFile(answerList,fileName);
    }
}