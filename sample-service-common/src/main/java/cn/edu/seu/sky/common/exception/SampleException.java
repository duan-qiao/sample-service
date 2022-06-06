package cn.edu.seu.sky.common.exception;

/**
 * @author xiaotian on 2022/5/7
 */
public class SampleException extends RuntimeException {

    private static final long serialVersionUID = -1018739491032846749L;

    public SampleException(Throwable throwable) {
        super(throwable.getMessage(), throwable);
    }

    public SampleException(String message) {
        super(message);
    }

    public SampleException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
