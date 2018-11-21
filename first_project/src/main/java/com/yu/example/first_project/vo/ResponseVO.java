package com.yu.example.first_project.vo;

public class ResponseVO {

    private boolean result;

    private String message;

    private Object content;

    public static ResponseVO buildSuccess(Object content){
        ResponseVO responseVO = new ResponseVO();
        responseVO.setResult(true);
        responseVO.setContent(content);
        return responseVO;
    }

    public static ResponseVO buildfailure(String message){
        ResponseVO responseVO = new ResponseVO();
        responseVO.setResult(true);
        responseVO.setMessage(message);
        System.out.println(message);
        return responseVO;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }
}
