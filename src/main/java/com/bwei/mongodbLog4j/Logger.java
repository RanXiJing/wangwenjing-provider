package com.bwei.mongodbLog4j;

import lombok.Data;

/**
 * Created by 染熙 on 2017/7/20.
 */
@Data
public class Logger {
    private String url;
    private String http_method;
    private String ip;
    private String class_method;
    private String args;

}
