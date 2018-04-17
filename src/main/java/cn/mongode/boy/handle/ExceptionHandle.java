package cn.mongode.boy.handle;

import cn.mongode.boy.domain.Result;
import cn.mongode.boy.enums.ResultEnum;
import cn.mongode.boy.exception.BoyException;
import cn.mongode.boy.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

public class ExceptionHandle {
    
    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);
    
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e) {
        if (e instanceof BoyException) {
            BoyException boyException = (BoyException) e;
            return ResultUtil.error(boyException.getCode(), boyException.getMessage());
        } else {
            logger.error("System Error : ", e);
            return ResultUtil.error(ResultEnum.UNKOWN_ERROR.getCode(), ResultEnum.UNKOWN_ERROR.getMsg());
        }
    }
}
