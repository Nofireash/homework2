package exception;

/**
 * @author tms
 * @Date 2023/9/22
 */
public class WrongOperationException extends RuntimeException{
    public WrongOperationException(String operation) {
        super("操作符号错误！"+operation+"操作符暂不提供！");
    }

    public WrongOperationException() {
        super("该算式表达式无法计算！");
    }
}
