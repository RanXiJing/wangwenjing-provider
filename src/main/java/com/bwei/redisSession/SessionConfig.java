package com.bwei.redisSession;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;


/**
 * Session共享
 * Created by 染熙 on 2017/7/18.
 */

@Configuration
@EnableRedisHttpSession(maxInactiveIntervalInSeconds =3600*30 )
public class SessionConfig {
}

