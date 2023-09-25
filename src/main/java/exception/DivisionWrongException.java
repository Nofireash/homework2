package exception;

/**
 * @author tms
 * @Date 2023/9/22
 */
public class DivisionWrongException extends RuntimeException{
    public DivisionWrongException() {
        super("除法分母不能为0！");
    }
}
