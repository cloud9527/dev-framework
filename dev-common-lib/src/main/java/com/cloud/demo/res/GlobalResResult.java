package com.cloud.demo.res;

import com.cloud.demo.exception.CustomException;
import com.cloud.demo.exception.ResCodeEnum;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 统一返回
 * @author wangjing
 **/
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class GlobalResResult<T> implements Serializable {
    private static final long serialVersionUID = 572235155491705152L;
    /**
     * 响应的状态码
     */
    @Getter
    @Setter
    private int code;
    /***
     * 响应的信息
     */
    @Getter
    @Setter
    private String message;
    /**
     * 响应数据
     */
    @Getter
    @Setter
    private T data;

    public static <T> GlobalResResult<T> success() {
        GlobalResResult<T> gr = new GlobalResResult<>();
        gr.setCode(ResCodeEnum.SUCCESS.getCode());
        gr.setMessage(ResCodeEnum.SUCCESS.getMsg());
        return gr;
    }

    public static <T> GlobalResResult<T> success(T data) {
        GlobalResResult<T> gr = new GlobalResResult<>();
        gr.setCode(ResCodeEnum.SUCCESS.getCode());
        gr.setMessage(ResCodeEnum.SUCCESS.getMsg());
        gr.setData(data);
        return gr;
    }

    public static <T> GlobalResResult<T> success(T data, String msg) {
        GlobalResResult<T> gr = new GlobalResResult<>();
        gr.setCode(ResCodeEnum.SUCCESS.getCode());
        gr.setMessage(msg);
        gr.setData(data);
        return gr;
    }

    public static <T> GlobalResResult<T> failed() {
        GlobalResResult<T> gr = new GlobalResResult<>();
        gr.setCode(ResCodeEnum.FAILED.getCode());
        gr.setMessage(ResCodeEnum.FAILED.getMsg());
        return gr;
    }

    public static <T> GlobalResResult<T> failed(CustomException customSaasException) {
        GlobalResResult<T> gr = new GlobalResResult<>();
        gr.setCode(customSaasException.getCode());
        gr.setMessage(customSaasException.getMessage());
        return gr;
    }

    public static <T> GlobalResResult<T> failed(int code, String message) {
        GlobalResResult<T> gr = new GlobalResResult<>();
        gr.setCode(code);
        gr.setMessage(message);
        return gr;
    }

    public static <T> GlobalResResult<T> failed(String message) {
        GlobalResResult<T> gr = new GlobalResResult<>();
        gr.setCode(ResCodeEnum.FAILED.getCode());
        gr.setMessage(message);
        return gr;
    }

    public static <T> GlobalResResult<T> failed(T data, CustomException customDataException) {
        GlobalResResult<T> gr = new GlobalResResult<>();
        gr.setCode(customDataException.getCode());
        gr.setMessage(customDataException.getMessage());
        gr.setData(data);
        return gr;
    }

    public static <T> GlobalResResult<T> failed(T data, int code, String message) {
        GlobalResResult<T> gr = new GlobalResResult<>();
        gr.setCode(code);
        gr.setMessage(message);
        gr.setData(data);
        return gr;
    }
}
