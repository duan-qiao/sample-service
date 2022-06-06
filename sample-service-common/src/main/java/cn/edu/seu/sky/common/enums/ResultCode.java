package cn.edu.seu.sky.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author xiaotian on 2022/5/7
 */
@Getter
@AllArgsConstructor
public enum ResultCode {
    /**
     * 错误编码
     */
    SUCCESS(1, "成功"),
    FAIL(-1, "失败"),

    ILLEGAL_ARGUMENT(1001, "参数错误"),
    TIMEOUT(1002, "超时"),
    ;

    private final int code;
    private final String message;
}
