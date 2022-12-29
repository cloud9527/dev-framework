package com.cloud.demo.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 自定义异常
 *
 * @author wangjing
 **/
@Data
@ToString
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class CustomException extends RuntimeException {

    private static final long serialVersionUID = -2379572886647456411L;

    private int code;
    private String message;

    /**
     * 根据code码和消息生成异常
     *
     * @param sce saasCode 枚举
     * @param mg  消息
     */
    public CustomException(ResCodeEnum sce, String mg) {
        super(mg);
        message = mg;
        code = sce.getCode();
    }

    /**
     * 根据code码生成异常
     *
     * @param sce saasCode 枚举
     */
    public CustomException(ResCodeEnum sce) {
        super(sce.getMsg());
        message = sce.getMsg();
        code = sce.getCode();
    }
}
