package com.xykj.base.commom;

import java.io.Serializable;

public class RsyResponse implements Serializable {
	private static final long serialVersionUID = 1L;
	private boolean success = true;
    private String message = "";
    private Integer errorCode;
    private Object data;
    private String rsyCode;

    private RsyResponse(boolean success, String message, Object data, Integer errorCode) {
        this.success = success;
        this.message = message;
        this.data = data;
        this.errorCode = errorCode;
    }

    public RsyResponse(boolean success, String message, Integer errorCode, Object data, String rsyCode) {
        this.success = success;
        this.message = message;
        this.errorCode = errorCode;
        this.data = data;
        this.rsyCode = rsyCode;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return this.data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Integer getErrorCode() {
        return this.errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getRsyCode() {
        return this.rsyCode;
    }

    public void setRsyCode(String rsyCode) {
        this.rsyCode = rsyCode;
    }

    public static RsyResponse success() {
        return new RsyResponse(true, "", (Object)null, (Integer)null);
    }

    public static RsyResponse success(String message) {
        return new RsyResponse(true, message, (Object)null, (Integer)null);
    }

    public static RsyResponse success(String message, Object data) {
        return new RsyResponse(true, message, data, (Integer)null);
    }

    public static RsyResponse success(String message, String rsyCode, Object data) {
        return new RsyResponse(true, message, (Integer)null, data, rsyCode);
    }

    public static RsyResponse error(String message) {
        return new RsyResponse(false, message, (Object)null, (Integer)null);
    }

    public static RsyResponse error(String message, String rsyCode) {
        return new RsyResponse(false, message, (Integer)null, (Object)null, rsyCode);
    }

    public static RsyResponse error(String message, Object data) {
        return new RsyResponse(false, message, data, (Integer)null);
    }
    
}
