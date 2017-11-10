package com.goule666.himmaForDnf.model;

import java.io.Serializable;

/**
 * @author niewenlong
 * @Date: 2017/10/25 14:04
 * @Description: 返回参数的封装
 */
public class Reply implements Serializable {
    private static final long serialVersionUID = -5200183948618627504L;
    private Object results;
    private Integer statusCode;
    private String statusMsg;

    public Reply(Object results) {
        this.results = results;
        this.statusCode = 200;
    }

    public Reply(Object results, Integer statusCode) {
        this.results = results;
        this.statusCode = statusCode;
    }

    public Object getResults() {
        return results;
    }

    public void setResults(Object results) {
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
