package entity;

import lombok.Data;

import java.util.LinkedList;
import java.util.List;

/**
 * @author tms
 * @description 结果
 * @date 2023/9/25
 */

@Data
public class Result {
    /**
     * 正确题数
     */
    private List<Integer> correctList = new LinkedList<>();
    /**
     * 错误题数
     */
    private List<Integer> wrongList = new LinkedList<>();


}
