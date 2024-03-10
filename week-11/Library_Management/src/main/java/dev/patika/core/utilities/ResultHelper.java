package dev.patika.core.utilities;

import dev.patika.core.result.Result;
import dev.patika.core.result.ResultWithData;
import dev.patika.dto.response.CursorResponse;
import org.springframework.data.domain.Page;

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

    public static  Result notFoundError(String msg){
        return new Result(false, msg, "404");
    }

    public static <T> ResultWithData<CursorResponse<T>> cursor(Page<T> pageData){
        CursorResponse<T> cursor = new CursorResponse<>();
        cursor.setItems(pageData.getContent());
        cursor.setPageNumber(pageData.getNumber());
        cursor.setPageSize(pageData.getSize());
        cursor.setTotalElements(pageData.getTotalElements());
        return ResultHelper.success(cursor);
    }
}
