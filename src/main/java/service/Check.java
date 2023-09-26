package service;

import entity.Result;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public interface Check {

    /**
     * 读取题目和答案文件
     *
     * @param answerFile    答案文件
     * @return exercises集合
     */
    Map<String,String> readFile(File answerFile) throws Exception;

    /**
     * 对给定的题目文件和答案文件，判定答案中的对错并进行数量统计
     *
     */
    Result checkAnswer(Map<String,String> map) throws IOException;

    /**
     * 对给定的题目文件和答案文件，判定答案中的对错并进行数量统计
     */
    Result checkPaper(String answerFile);

}
