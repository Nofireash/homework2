package utils;

import entity.Result;

import java.io.*;
import java.util.List;

/**
 * @author tms
 * @Date 2023/9/22
 */
public class FileUtil {
    /**
     * 将一个文件路径转为BufferedReader对象
     *
     */
    public static BufferedReader getBufferedReader(File file) throws Exception {
        if (null == file) {
            throw new Exception("文件名不能为空");
        } else if (file.isDirectory()) {
            throw new Exception("不支持读取文件夹，请输入文件路径");
        } else if (!file.exists()) {
            throw new Exception("该文件不存在");
        } else {
            return new BufferedReader(new FileReader(file));
        }
    }

    /**
     * 将正确和错误数量结果写入文件
     *
     */
    public static void writeCheckResultToFile(Result result) throws IOException {
        BufferedWriter resultWriter = new BufferedWriter(new FileWriter(System.getProperty("user.dir") + "/Grade.txt"));
        List correctList = result.getCorrectList();
        resultWriter.write("Correct:" + correctList.size());
        resultWriter.newLine();
        StringBuilder stringBuilder = new StringBuilder("(");
        for (int i = 0; i < correctList.size(); i++) {
            if ((i > 1 && (i + 1) % 10 == 0) || i == correctList.size() - 1) {
                stringBuilder.append(correctList.get(i)).append(")");
                resultWriter.write(stringBuilder.toString());
                resultWriter.newLine();
                stringBuilder = new StringBuilder("(");
            } else {
                stringBuilder.append(correctList.get(i)).append(",");
            }
        }
        List<Integer> wrongList = result.getWrongList();
        resultWriter.write("Wrong:" + wrongList.size());
        resultWriter.newLine();
        stringBuilder = new StringBuilder("(");
        for (int i = 0; i < wrongList.size(); i++) {
            if ((i > 1 && (i + 1) % 10 == 0) || i == wrongList.size() - 1) {
                stringBuilder.append(wrongList.get(i)).append(")");
                resultWriter.write(stringBuilder.toString());
                resultWriter.newLine();
                stringBuilder = new StringBuilder("(");
            } else {
                stringBuilder.append(wrongList.get(i)).append(",");
            }
        }
        resultWriter.flush();
    }

    /**
     * 将结果写入Exercises.txt文件
     *
     * @param list 表达式集合或答案集合
     * @param fileName Exercises.txt--表达式文件  Answers.txt--答案文件
     */
    public static void writeToFile(List<String> list,String fileName) {
        File checkFile = new File(fileName);
        FileWriter writer = null;
        try {
            //检查目标文件是否存在，不存在则创建
            if (!checkFile.exists()) {
                // 创建目标文件
                checkFile.createNewFile();
            }
            //向目标文件中写入内容
            // FileWriter(File file, boolean append)，append为true时为追加模式，false或缺省则为覆盖模式
            writer = new FileWriter(checkFile, false);
            for (String s : list) {
                writer.append(s);
                writer.append("\n");
            }
            writer.flush();
        } catch (IOException e) {
            System.out.println("创建结果文件错误！");

        } finally {
            if (null != writer) {
                try {
                    writer.close();
                } catch (IOException e) {
                    System.out.println("写入文件错误！");
                }
            }
        }
    }
}
