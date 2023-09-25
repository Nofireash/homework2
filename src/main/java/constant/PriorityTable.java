package constant;

/**
 * @author tms
 * @Date 2023/9/22
 */
public class PriorityTable {

    /**
     * 运算符优先级
     *
     * @param opt 操作符
     * @return 优先级
     */
    public static int Priority(String opt) {
        int n = 0;
        switch (opt) {
            case "+":
            case "-":
                n = -1;
                break;
            case "*":
            case "/":
                n = 1;
                break;
            case "(":
                n = -2;
                break;
            case ")":
                n = 2;
            default:
                break;
        }
        return n;
    }
}
