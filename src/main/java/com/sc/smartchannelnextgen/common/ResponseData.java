package com.sc.smartchannelnextgen.common;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.logging.log4j.ThreadContext;

import java.io.Serializable;
import java.util.Date;

public class ResponseData<T> implements Serializable {
    private int code;

    private String message;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS", timezone = "GMT+7")
    private Date timestamp;

    private String uuid;

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    private long duration;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    private String path;

    private T data;

    public ResponseData() {
        this.timestamp = new Date();
    }

    public ResponseData<T> success(T data) {
        this.data = data;
        this.code = 0;
        this.message = "Success!";
        this.path = ThreadContext.get("path");
        this.uuid = ThreadContext.get("uuid");
//        long start = Long.parseLong(ThreadContext.get("startTime"));
//        this.duration = System.currentTimeMillis() - start;
        return this;
    }

    public ResponseData<T> error(int code, String message) {
        this.code = code;
        this.message = message;
        this.path = ThreadContext.get("path");
        this.uuid = ThreadContext.get("uuid");
        long start = Long.parseLong(ThreadContext.get("startTime"));
        this.duration = System.currentTimeMillis() - start;
        return this;
    }

    public ResponseData<T> error(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.path = ThreadContext.get("path");
        this.uuid = ThreadContext.get("uuid");
        long start = Long.parseLong(ThreadContext.get("startTime"));
        this.duration = System.currentTimeMillis() - start;
        return this;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getUuid() { return uuid; }
}
