package service;

import entity.Result;
import utils.FileUtil;

import java.io.BufferedReader;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;

public class CheckImpl implements Check{

    private final Calculate calculate = new CalculateImpl();

    @Override
    public Map<String, String> readFile(File answerFile) throws Exception {
        BufferedReader answerReader = FileUtil.getBufferedReader(answerFile);
        String answer;
        // 存放问题+答案
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        while ((answer = answerReader.readLine()) != null) {
            String[] s = answer.split("=");
            // 放入map中 问题 -- 答案
            map.put(s[0],s[1]);
         //   System.out.printf("question=%s\n", s[0]);
         //   System.out.printf("answer=%s\n", s[1]);
        }
        return map;
    }

    @Override
    public Result checkAnswer(Map<String, String> map) {

        Result result = new Result();
        int count = 1;

        for (String s : map.keySet()){
            if (map.get(s).equals(calculate.calculate(s))){
                // 说明正确
                result.getCorrectList().add(count);
            } else {
                result.getWrongList().add(count);
            }
            count++;
        }

        return result;
    }


    @Override
    public Result checkPaper(String answerFile) {
        try {
            Map<String, String> answerMap = readFile(new File(answerFile));
            Result result = checkAnswer(answerMap);
            FileUtil.writeCheckResultToFile(result);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}
