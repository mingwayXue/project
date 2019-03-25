package com.mmall.common;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.springframework.util.StringUtils;

import java.io.Serializable;

/**高复用响应信息类
 * Created by Mingway on 2018/3/9.
 */
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)  //保证序列化json对象时，value为null时，key也会消失
public class ServerResponse<T> implements Serializable{

    /**
     * 状态码
     */
    private Integer status;

    /**
     * 具体信息
     */
    private String msg;

    /**
     * 数据
     */
    private T data;

    private ServerResponse(Integer status){
        this.status = status;
    }

    private ServerResponse(Integer status, String msg){
        this.status = status;
        this.msg = msg;
    }

    private ServerResponse(Integer status, String msg, T data){
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    private ServerResponse(Integer status, T data) {
        this.status = status;
        this.data = data;
    }

    @JsonIgnore //使之不序列化
    public boolean isSuccess() {
        return this.status == ResponseCode.SUCCESS.getCode();
    }

    public Integer getStatus() {
        return status;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }

    /**
     * 成功获取
     */
    public static  <T> ServerResponse<T> createBySuccess(){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode());
    }

    public static  <T> ServerResponse<T> createBySuccessMessage(String msg){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(), msg);
    }

    public static  <T> ServerResponse<T> createBySuccess(T data){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(), data);
    }

    public static  <T> ServerResponse<T> createBySuccess(String msg, T data){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(), msg, data);
    }

    /**
     * 失败获取
     */
    public static  <T> ServerResponse<T> createByError(){
        return new ServerResponse<T>(ResponseCode.ERROR.getCode(), ResponseCode.ERROR.getDesc());
    }

    public static  <T> ServerResponse<T> createByErrorMessage(String errorMessage){
        return new ServerResponse<T>(ResponseCode.ERROR.getCode(), errorMessage);
    }

    public static  <T> ServerResponse<T> createByErrorCodeMessage(Integer errorCode, String errorMessage){
        return new ServerResponse<T>(errorCode, errorMessage);
    }
}
