package service;

import java.util.List;

/**
 * @author tms
 * @Date 2023/9/22
 */
public interface Expression {

    /**
     * 随机生成指定条,r以内的四则运算表达式
     *
     * @param n 指定条数
     * @param r 指定范围以内
     * @return 表达式集合
     */
    List<String> createExpression(Integer n,Integer r);

    /**
     * 将表达式集合写入文件中
     *
     * @param fileName 文件名
     */
    void writeToFile(String fileName);

    /**
     * 将答案集合写入文件中
     *
     * @param answerList 答案集合
     * @param fileName 文件名
     */
    void answerToFile(List<String> answerList,String fileName);
}
