package utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * @author tms
 * @Date 2023/9/22
 */
public class FileUtil {

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
