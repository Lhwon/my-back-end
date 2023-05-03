package com.myframework.mybackend.framework.response;

import java.util.*;

import org.springframework.stereotype.Service;


@Service
public class ResponseService {

	public enum CommonResponse {
        SUCCESS(200, "�����Ͽ����ϴ�.");

        int code;
        String msg;

        CommonResponse(int code, String msg) {
            this.code = code;
            this.msg = msg;
        }

        public int getCode() {
            return code;
        }

        public String getMsg() {
            return msg;
        }
    }
    
    // ���ϰ� ����� ó���ϴ� �޼ҵ�
    public <T> SingleResult<T> getSingleResult(T data) {
        SingleResult<T> result = new SingleResult<>();
        result.setData(data);
        setSuccessResult(result);
        return result;
    }
    
    // ���߰� ����� ó���ϴ� �޼ҵ�
    public <T> ListResult<T> getListResult(List<T> list) {
        ListResult<T> result = new ListResult<>();
        result.setList(list);
        setSuccessResult(result);
        return result;
    }
    
    // ���� ����� ó���ϴ� �޼ҵ�
    public CommonResult getSuccessResult() {
        CommonResult result = new CommonResult();
        setSuccessResult(result);
        return result;
    }
    
    // ���� ����� ó���ϴ� �޼ҵ�
    public CommonResult getFailResult(int code, String msg) {
        CommonResult result = new CommonResult();
        result.setSuccess(false);
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
    
    // map ����� ó���ϴ� �޼ҵ�
    public <T> MapResult<T, T> getMapResult(Map<T, T> map) {
    	MapResult<T, T> result = new MapResult<T, T>();
        result.setMap(map);
        
        //setSuccessResult(map); --> map type �Ķ���ͷ� �ȳѾ. Ȯ���ʿ�
        result.setSuccess(true);
        result.setCode(CommonResponse.SUCCESS.getCode());
        result.setMsg(CommonResponse.SUCCESS.getMsg());
        
        return result;
    }
    
    // ��� �𵨿� api ��û ���� �����͸� �������ִ� �޼ҵ�
    private void setSuccessResult(CommonResult result) {
        result.setSuccess(true);
        result.setCode(CommonResponse.SUCCESS.getCode());
        result.setMsg(CommonResponse.SUCCESS.getMsg());
    }
}