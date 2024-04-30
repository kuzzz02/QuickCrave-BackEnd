package com.quickcravebackend.utils;

import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Setter
@Getter
public class ResultResponse<T> implements Serializable {
    @Serial
    private static final long serialVersionUID = -6605638333527137742L;

//    状态码
    private Integer code;
//    响应数据
    private T data;

    public static <T> ResultResponse<T> success(T data) {
        ResultResponse<T> response = new ResultResponse<>();
        response.setCode(200);
        response.setData(data);
        return response;
    }
    public static <T> ResultResponse<T> error(T data) {
        ResultResponse<T> response = new ResultResponse<>();
        response.setCode(500);
        response.setData(data);
        return response;
    }
}