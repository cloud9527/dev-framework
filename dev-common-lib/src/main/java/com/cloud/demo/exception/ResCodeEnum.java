package com.cloud.demo.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
  * 异常枚举 异常码规则为ABBBCCCC共8位
 * A：错误级别。如1代表系统级错误，2代表服务级错误，3请求错误
 * B: 项目或模块名称代码 共999个项目或模块
 * rmzk-data-gateway项目 001 系统级错误
 * rmzk-media-insight-auth 项目 002
 * rmzk-media-insight-user-service 项目 003
 *
 * 具体错误编号, 单个项目/模块有9999种错误异常
 * @author wangjing
 **/
@Getter
@AllArgsConstructor
public enum ResCodeEnum {
    /** 成功 */
    SUCCESS(0, "success"),
    FAILED(1, "fail"),

    /**
     * gateway 001
     */
    ERROR_SYSTEM(10010001, "前方拥挤，请稍后重试"),
    ERROR_DATA(10010002, "数据异常"),
    ERROR_SERVICE_NOT_FOUND(10010003, "未找服务,请检查服务是否可用"),
    ERROR_INTERFACE_DEPRECATED(10010004, "接口版本被废弃"),
    ERROR_PREMISS(10010005, "无权限操作,请联系管理员"),
    COMMON_FAIL(10010006, "操作失败"),
    TOKEN_ERROR(10010007, "未登录或Token已过期"),
    BASIC_REQUEST_VALIDATED_ERROR(10010014, "参数校验失败"),

    /**
     * 业务异常
     */
    /**
     * auth 002
     */
    AUTH_ACCOUNT_PASS_ERROR(20020001, "请输入正确的账号或密码"),
    AUTH_REFRESH_TOKEN_ERROR(20020002, "刷新token失效"),
    AUTH_COMMON_FAIL(20020003, "操作失败"),

    /**
     * user 003
     */
    USER_NOT_EXC(20030003, "用户不存在"),
    /**
     * shortVideo 004
     */
    ;

    /**
     * 错误码
     */
    private final int code;

    /**
     * 错误信息
     */
    private final String msg;

    public static ResCodeEnum getByCode(int code) {
        ResCodeEnum[] es = ResCodeEnum.values();
        for (ResCodeEnum e : es) {
            if (code == e.getCode()) {
                return e;
            }
        }
        return null;
    }
}
