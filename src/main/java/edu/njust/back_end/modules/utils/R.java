package edu.njust.back_end.modules.utils;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 返回前端数据的包装类
 * @param <T>
 */
@Data
public class R<T> implements Serializable {
    @ApiModelProperty("返回状态(OK:成功; ERROR:失败)")
    private Status status;

    @ApiModelProperty("返回code")
    private Integer code;

    @ApiModelProperty("返回状态描述")
    private String message;

    @ApiModelProperty("返回数据")
    private T data;

    @ApiModelProperty("时间戳")
    private Long date;

    @Override
    public String toString() {
        return "R(status=" + getStatus() + ", code=" + getCode() + ", message=" + getMessage() + ", data=" + getData() + ", date=" + getDate() + ")";
    }
    public enum Status {
        OK, ERROR;
    }

    public static <T> R<T> ok() {
        return new R<>();
    }

    public static <T> R<T> ok(T data) {
        R<T> r = new R<>();
        r.setData(data);
        return r;
    }

    public static <T> R<T> ok(String message, T data) {
        R<T> r = new R<>();
        r.setMessage(message);
        r.setData(data);
        return r;
    }

    public static <T> R<T> error(int code, String message) {
        R<T> r = new R<>();
        r.setStatus(Status.ERROR);
        r.setCode(Integer.valueOf(code));
        r.setMessage(message);
        return r;
    }

    public R() {
        this.status = Status.OK;
        this.code = 20000;
        this.message = PlatformCodeEnum.SUCCESS.getMsg();
        this.date = (new Date()).getTime();
    }

    public static <T> R<T> error() {
        return error(PlatformCodeEnum.ERROR.getCode().intValue(), "未知异常，请联系管理员");
    }

    public static <T> R<T> error(String msg) {
        return error(PlatformCodeEnum.ERROR.getCode().intValue(), msg);
    }
}

