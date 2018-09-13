package com.zzx.filterlistenerintercept.tool;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by Vivian on 2018/04/21.
 */
@Data
public class ResultWrapper implements Serializable{
    int code;
    String message;
    Object result;
    public ResultWrapper(){}

    public ResultWrapper(int code, String message, Object result){
        this.code = code;
        this.message = message;
        this.result = result;
    }

    public ResultWrapper(int code, String message){
        this.code = code;
        this.message = message;
        this.result = null;
    }
    public ResultWrapper build(int code, String message, Object result){
        return new ResultWrapper(code,message,result);
    }

    public ResultWrapper build(int code, String message){
        return new ResultWrapper(code,message);
    }
    @Override
    public String toString() {
        return "ResultWrapper{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", result=" + result +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        ResultWrapper that = (ResultWrapper) o;

        if (code != that.code) return false;
        if (message != null ? !message.equals(that.message) : that.message != null) return false;
        return result != null ? result.equals(that.result) : that.result == null;
    }

    @Override
    public int hashCode() {
        int result1 = super.hashCode();
        result1 = 31 * result1 + code;
        result1 = 31 * result1 + (message != null ? message.hashCode() : 0);
        result1 = 31 * result1 + (result != null ? result.hashCode() : 0);
        return result1;
    }
}
