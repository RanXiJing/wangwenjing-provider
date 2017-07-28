package com.bwei.MD5;

import org.jasypt.encryption.StringEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 染熙 on 2017/7/28.
 */
@RestController
public class Md5Controller {
    @Autowired
    StringEncryptor stringEncryptor;

    @RequestMapping("/encyptPwd")
    public String encryptPwd(){
        String encrypt = stringEncryptor.encrypt("123456");
        System.out.print(encrypt);
        return encrypt;
    }
}
