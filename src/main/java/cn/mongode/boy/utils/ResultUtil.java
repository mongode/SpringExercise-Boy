package cn.mongode.boy.utils;

import cn.mongode.boy.domain.Result;
import cn.mongode.boy.enums.ResultEnum;

public class ResultUtil {
    
    public static Result success(Object object) {
        Result result = new Result();
        result.setCode(ResultEnum.SUCCESS.getCode());
        result.setMsg(ResultEnum.SUCCESS.getMsg());
        result.setInfo(object);
        return result;
    }
    
    public static Result success() {
        return success(null);
    }
    
    public static Result error(Integer code, String msg) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
