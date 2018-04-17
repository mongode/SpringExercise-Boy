package cn.mongode.boy.enums;

public enum ResultEnum {
    UNKOWN_ERROR(-1, "Unkown Error."),
    SUCCESS(0, "Successfully!"),
    AGE_TOO_SMALL(100, "The age is too small."),
    AGE_TOO_BIG(900, "The age is too big.")
    ;
    
    private Integer code;
    
    private String msg;
    
    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    
    public Integer getCode() {
        return code;
    }
    
    public String getMsg() {
        return msg;
    }
}
