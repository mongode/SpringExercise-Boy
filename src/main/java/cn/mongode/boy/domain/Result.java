package cn.mongode.boy.domain;

public class Result<T> {
    
    /* 错误码 */
    private Integer code;
    
    /* 提示信息 */
    private String msg;
    
    /* 错误信息 */
    private T info;
    
    public Result() {}
    
    public Integer getCode() {
        return code;
    }
    
    public void setCode(Integer code) {
        this.code = code;
    }
    
    public String getMsg() {
        return msg;
    }
    
    public void setMsg(String msg) {
        this.msg = msg;
    }
    
    public T getInfo() {
        return info;
    }
    
    public void setInfo(T info) {
        this.info = info;
    }
}
