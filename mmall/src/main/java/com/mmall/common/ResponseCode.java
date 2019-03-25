package com.mmall.common;

/**响应编码枚举类
 * Created by Mingway on 2018/3/9.
 */
public enum ResponseCode {

    SUCCESS(0, "SUCCESS"),
    ERROR(1, ""),
    NEED_LOGIN(10, ""),
    ILLEGAL_ARGUMENT(2, ""),

    ;
    private final int code;
    private final String desc;

    ResponseCode(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
