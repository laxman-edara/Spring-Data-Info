package com.laxman.redis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@Configuration
@EnableRedisRepositories
public class AppDataConfig {

	@Bean
	public JedisConnectionFactory jedisConnectionFactory() {
		//Redis host and post
		RedisStandaloneConfiguration config = new RedisStandaloneConfiguration(
				"your Redis host", 6379);
		JedisConnectionFactory factory = new JedisConnectionFactory(config);
		return factory;

	}

	@Bean
	public RedisTemplate<String, Object> redisTemplate() {
		RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(jedisConnectionFactory());
		return redisTemplate;
	}

	
	
}
