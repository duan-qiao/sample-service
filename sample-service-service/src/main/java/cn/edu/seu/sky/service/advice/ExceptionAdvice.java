package cn.edu.seu.sky.service.advice;

import cn.edu.seu.sky.common.result.BaseResult;
import cn.edu.seu.sky.common.enums.ResultCode;
import cn.edu.seu.sky.common.exception.SampleException;
import cn.edu.seu.sky.api.service.RpcParam;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.stream.Collectors;

/**
 * @author xiaotian on 2022/5/7
 */
@Aspect
@Component
public class ExceptionAdvice {

    @Pointcut("execution(* cn.edu.seu.sky.service.impl..*.*(..))")
    public void exceptionAdvice() {
        // ignore
    }

    @Around("exceptionAdvice()")
    public Object around(ProceedingJoinPoint pjp) {
        Object[] args = pjp.getArgs();
        try {
            checkArgs(args);

        } catch (IllegalArgumentException e) {
            return BaseResult.failure(ResultCode.ILLEGAL_ARGUMENT.getCode(), e.getMessage());
        }
        try {
            return pjp.proceed();

        } catch (ConstraintViolationException e) {
            String message = e.getConstraintViolations().stream()
                    .map(ConstraintViolation::getMessage)
                    .collect(Collectors.joining(","));
            return BaseResult.failure(ResultCode.ILLEGAL_ARGUMENT.getCode(), message);

        } catch (SampleException e) {
            return BaseResult.failure(ResultCode.FAIL.getCode(), e.getMessage());

        } catch (Throwable e) {
            return BaseResult.failure(ResultCode.FAIL);
        }
    }

    void checkArgs(Object[] args) {
        if (args.length == 0) {
            return;
        }
        for (Object arg : args) {
            if (arg instanceof RpcParam) {
                ((RpcParam) arg).check();
            }
        }
    }
}
