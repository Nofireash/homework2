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
//    /**
//     * 传入文件绝对路径，读出txt文件，将文件内容转化为String字符串输出
//     *
//     * @param textPath 文件路径
//     * @return 文件内容
//     */
//    public static String readFromText(String textPath) {
//        //文件返回内容--字符串
//        String s = "";
//        String strLine;
//        // 将 txt文件按行读入s中
//        File file = new File(textPath);
//        //文件输入流
//        FileInputStream fileInputStream = null;
//        try {
//            fileInputStream = new FileInputStream(file);
//            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
//            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
//            // 字符串拼接
//            while ((strLine = bufferedReader.readLine()) != null) {
//                s += strLine;
//            }
//            // 关闭所有资源
//            inputStreamReader.close();
//            bufferedReader.close();
//            fileInputStream.close();
//        } catch (IOException e) {
//            System.out.println("读取文件内容失败！");
//        }
//        return s;
//    }

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
