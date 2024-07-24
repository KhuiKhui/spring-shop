package com.example.spring_shop.response;

import org.json.JSONArray;
import org.json.JSONObject;

public class ResponseData {
    private String resData;
    private String resDesc;
    private int resCode;

    public ResponseData(String resData, String resDesc, int resCode) {
        this.resData = resData;
        this.resDesc = resDesc;
        this.resCode = resCode;
    }

    public String getResData() {
        return resData;
    }

    public void setResData(String resData) {
        this.resData = resData;
    }
    
    public String getResDesc() {
        return resDesc;
    }

    public Object getResCode() {
        return resCode;
    }

    public JSONObject getJsonData() {
        return new JSONObject(resData);
    }

    public JSONArray getJsonArrayData() {
        return new JSONArray(resData);
    }
}
