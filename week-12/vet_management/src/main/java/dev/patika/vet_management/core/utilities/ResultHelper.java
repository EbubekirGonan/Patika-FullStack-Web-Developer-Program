package dev.patika.vet_management.core.utilities;

import dev.patika.vet_management.core.result.Result;
import dev.patika.vet_management.core.result.ResultWithData;
import dev.patika.vet_management.dto.CursorResponse;
import org.springframework.data.domain.Page;

import java.awt.*;

public class ResultHelper {
    public static <T> ResultWithData<T> created(T data){
        return new ResultWithData<>(true, Msg.CREATED, "201", data);
    }

    public static <T> ResultWithData<T> validateError(T data){
        return new ResultWithData<>(false, Msg.VALIDATE_ERROR, "400", data);
    }

    public static <T> ResultWithData<T> success(T data){
        return new ResultWithData<>(true, Msg.OK, "200", data);
    }

    public static Result ok(){
        return new Result(true, Msg.OK, "200");

    }
    public static Result invalidVaccine(){
        return new Result(false, Msg.INVALID_OPERATION, "400");
    }

    public static Result notFound(String message){
        return new Result(false, message, "404");
    }

    public static <T> ResultWithData<CursorResponse<T>> cursor(Page<T> pageData){
        CursorResponse<T> cursor = new CursorResponse<>();
        cursor.setItems(pageData.getContent());
        cursor.setPageNumber(pageData.getNumber());
        cursor.setPageSize(pageData.getSize());
        cursor.setTotalElement((int) pageData.getTotalElements());
        return ResultHelper.success(cursor);
    }



}
