package cn.edu.seu.sky.common.result;

import cn.edu.seu.sky.common.enums.ResultCode;
import lombok.Data;

import java.io.Serializable;

/**
 * @author xiaotian on 2022/5/7
 */
@Data
public final class BaseResult<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private int code;

    private String message;

    private T data;

    public boolean isSuccess() {
        return ResultCode.SUCCESS.getCode() == code;
    }

    public static <T> BaseResult<T> success(T data) {
        BaseResult<T> result = new BaseResult<>();
        result.setCode(ResultCode.SUCCESS.getCode());
        result.setMessage(ResultCode.SUCCESS.getMessage());
        result.setData(data);
        return result;
    }

    public static <T> BaseResult<T> success() {
        BaseResult<T> result = new BaseResult<>();
        result.setCode(ResultCode.SUCCESS.getCode());
        result.setMessage(ResultCode.SUCCESS.getMessage());
        return result;
    }

    public static <T> BaseResult<T> failure(int errorCode, String errorMsg) {
        BaseResult<T> result = new BaseResult<>();
        result.setCode(errorCode);
        result.setMessage(errorMsg);
        return result;
    }

    public static <T> BaseResult<T> failure(ResultCode resultCode) {
        BaseResult<T> result = new BaseResult<>();
        result.setCode(resultCode.getCode());
        result.setMessage(resultCode.getMessage());
        return result;
    }
}
