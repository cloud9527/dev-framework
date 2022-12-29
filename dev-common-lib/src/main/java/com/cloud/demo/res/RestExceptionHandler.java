package com.cloud.demo.res;

import com.cloud.demo.exception.CustomException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.validation.ConstraintViolationException;

/**
 * 统一异常处理
 * @author wangjing
 **/
@Slf4j
@RestControllerAdvice
public class RestExceptionHandler {

    /**
     * 捕获自定义异常
     *
     * @param exception exception
     * @return 响应
     */
    @ExceptionHandler(CustomException.class)
    @ResponseBody
    public GlobalResResult<Object> customExceptionHandler(CustomException exception) {
        log.error("捕获CustomSaasException:", exception);
        return GlobalResResult.failed(exception);
    }

    /**
     * 捕获Exception异常
     *
     * @param exception 异常
     * @return 响应
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity<Object> exceptionHandler(Exception exception) {
        log.error("捕获Exception:", exception);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(GlobalResResult.failed());
    }

    /**
     * 捕获Exception异常 参数验证失败
     *
     * @param exception 异常
     * @return 响应
     */
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseBody
    public ResponseEntity<Object> exceptionHandler(ConstraintViolationException exception) {
        log.error("参数验证失败ConstraintViolationException:", exception);
        String msg = "参数验证失败 " + exception.getMessage();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(GlobalResResult.failed(msg));
    }

    /**
     * 捕获Exception异常 参数异常
     *
     * @param exception 异常
     * @return 响应
     */
    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseBody
    public ResponseEntity<Object> exceptionHandler(MissingServletRequestParameterException exception) {
        log.error("参数异常MissingServletRequestParameterException:", exception);
        String msg = "参数异常 " + exception.getMessage();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(GlobalResResult.failed(msg));
    }

    /**
     * 捕获Exception异常 请求参数不合法
     *
     * @param exception 异常
     * @return 响应
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseBody
    public ResponseEntity<Object> exceptionHandler(HttpMessageNotReadableException exception) {
        log.error("请求参数不合法 HttpMessageNotReadableException:", exception);
        String msg = "请求参数不合法 " + exception.getMessage();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(GlobalResResult.failed(msg));
    }

    /**
     * 捕获Exception异常 请求方法不支持
     *
     * @param exception 异常
     * @return 响应
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseBody
    public ResponseEntity<Object> exceptionHandler(HttpRequestMethodNotSupportedException exception) {
        log.error("请求方法不支持 HttpRequestMethodNotSupportedException:", exception);
        String msg = "请求方法不支持 " + exception.getMessage();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(GlobalResResult.failed(msg));
    }

    /**
     * 捕获MethodArgumentTypeMismatchException异常 方法参数类型不匹配异常
     *
     * @param exception 异常
     * @return 响应
     */
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseBody
    public ResponseEntity<GlobalResResult<Object>> exceptionHandler(MethodArgumentTypeMismatchException exception) {
        log.error("方法参数类型不匹配 MethodArgumentTypeMismatchException:", exception);
        String msg = "方法参数类型不匹配 " + exception.getMessage();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(GlobalResResult.failed(msg));
    }

    /**
     * 捕获NoHandlerFoundException 404异常
     *
     * @param exception 异常
     * @return 响应
     */
    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseBody
    public ResponseEntity<GlobalResResult<Object>> exceptionHandler(NoHandlerFoundException exception) {
        log.error("404未找到 NoHandlerFoundException:", exception);
        String msg = "未找到 " + exception.getMessage();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(GlobalResResult.failed(msg));
    }
}
