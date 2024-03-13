package dev.patika.vet_management.core.result;


import lombok.Getter;

@Getter
public class ResultWithData<T> extends Result{
    private T data;
    public ResultWithData(boolean status, String message, String code, T data) {
        super(status, message, code);
        this.data = data;
    }
}
