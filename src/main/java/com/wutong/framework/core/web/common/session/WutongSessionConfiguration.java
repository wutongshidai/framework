package com.wutong.framework.core.web.common.session;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.web.http.CookieHttpSessionStrategy;

@Configuration
@EnableRedisHttpSession
public class WutongSessionConfiguration {

	/**
	 * 注入自定义cookie机制
	 * @return
	 */
	@Bean
	public CookieHttpSessionStrategy cookieHttpSessionStrategy() {
		CookieHttpSessionStrategy cookieHttpSessionStrategy = new CookieHttpSessionStrategy();
		cookieHttpSessionStrategy.setCookieSerializer(new WutongCookieSerializer());
		return cookieHttpSessionStrategy;
	}
}
