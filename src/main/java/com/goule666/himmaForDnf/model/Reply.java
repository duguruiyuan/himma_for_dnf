package com.goule666.himmaForDnf.model;

import java.io.Serializable;

/**
 * @author niewenlong
 * @Date: 2017/10/25 14:04
 * @Description: 返回参数的封装
 */
public class Reply<T>{
    private T results;
    private Integer statusCode;
    private String statusMsg;

    public Reply(T results) {
        this.results = results;
        this.statusCode = 200;
    }

    public Reply(T results, Integer statusCode) {
        this.results = results;
        this.statusCode = statusCode;
    }

    public T getResults() {
        return results;
    }

    public void setResults(T results) {
        this.results = results;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusMsg() {
        return statusMsg;
    }

    public void setStatusMsg(String statusMsg) {
        this.statusMsg = statusMsg;
    }

    public Reply(Integer statusCode, String statusMsg){
        this.statusCode = statusCode;
        this.statusMsg = statusMsg;
    }

    public Reply() {
    }

    @Override
    public String toString() {
        return "Reply{" +
                "results=" + results +
                ", statusCode=" + statusCode +
                ", statusMsg='" + statusMsg + '\'' +
                '}';
    }
}
