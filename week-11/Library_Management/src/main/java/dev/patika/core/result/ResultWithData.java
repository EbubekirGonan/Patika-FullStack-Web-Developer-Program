package dev.patika.core.result;

import lombok.Getter;

import java.util.List;

@Getter
public class ResultWithData<T> extends Result{
    private T data;
    //private List<T> list;
    public ResultWithData(boolean status, String message, String code, T data) {
        super(status, message, code);
        this.data = data;
    }
/*
    public ResultWithData(boolean status, String message, String code, T data, List<T> list) {
        super(status, message, code);
        this.data = data;
        this.list = list;
    }

 */
}
