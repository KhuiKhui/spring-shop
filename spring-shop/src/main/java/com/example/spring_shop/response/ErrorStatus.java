package com.example.spring_shop.response;

public enum ErrorStatus {

    //    FAILED
    GET_METHOD_FAILED("HTTP Get method failed: Unable to find appropriate values.",5001),

    POST_METHOD_FAILED("HTTP Post method failed: Unable to find appropriate values.",5002),

    PUT_METHOD_FAILED("HTTP Put method failed: Unable to find and change appropriate values.",5003),

    DELETE_METHOD_FAILED("HTTP Delete method failed: Unable to find appropriate values.",5004),

    GET_METHOD_SUCCESS("HTTP Get method succeeded: Status OK",2001),

    POST_METHOD_SUCCESS("HTTP Post method succeeded: Status OK",2002),

    PUT_METHOD_SUCCESS("HTTP Put method succeeded: Status OK",2003),

    DELETE_METHOD_SUCCESS("HTTP Delete method succeeded: Status OK",2004);


    final String desc;
    final int code;
    ErrorStatus(String desc, int code) {
        this.desc = desc;
        this.code = code;
    }
    public String getDesc(){
        return desc;
    }
    public int getCode(){
        return code;
    }
}