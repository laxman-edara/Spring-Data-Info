package com.laxman.redis.config;

import java.util.List;

import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSCredentialsProviderChain;
import com.amazonaws.auth.EnvironmentVariableCredentialsProvider;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.elasticache.AmazonElastiCacheClient;
import com.amazonaws.services.elasticache.AmazonElastiCacheClientBuilder;
import com.amazonaws.services.elasticache.model.CacheCluster;
import com.amazonaws.services.elasticache.model.DescribeCacheClustersRequest;
import com.amazonaws.services.elasticache.model.DescribeCacheClustersResult;

public class SampleInfo {

	public static void main(String[] args) {
		/*AWSCredentialsProvider credentialsProvider = new AWSCredentialsProviderChain(
				new EnvironmentVariableCredentialsProvider(), new ProfileCredentialsProvider());
		AmazonElastiCacheClient client = (AmazonElastiCacheClient) AmazonElastiCacheClientBuilder.standard()
				.withCredentials(credentialsProvider).withRegion("us-east-1").build();
		DescribeCacheClustersRequest dccRequest = new DescribeCacheClustersRequest();
		dccRequest.setShowCacheNodeInfo(true);
		DescribeCacheClustersResult clusterResult = client.describeCacheClusters(dccRequest);
		List<CacheCluster> clusters = clusterResult.getCacheClusters();
		System.out.println(clusters);*/
		RedisStandaloneConfiguration config = new RedisStandaloneConfiguration(
				"sample-test.577gj8.ng.0001.use1.cache.amazonaws.com", 6379);
		JedisConnectionFactory factory = new JedisConnectionFactory(config);
		System.out.println(factory);
		String str = "edara";
		String str1 = str.substring(0, 1);
		System.out.println(str1);
		

	}

}
