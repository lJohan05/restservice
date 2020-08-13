package com.sophossolutions.utils;

public enum MsgError {

    MSG_CODE_ERROR("Status no equals, expect \"%s\", actual \"%s\""),
    MSG_VALUE_ERROR("Value no found, expect \"%s\", actual \"%s\"");

    private String msg;

    private MsgError(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
