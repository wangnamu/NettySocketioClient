package com.ufo.NettySocketioClient;

import java.io.File;
import java.io.IOException;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

import com.google.gson.Gson;

public class NettySocketioClient {

	private final static String SEND = "send";
	private final static String BROADCAST = "broadcast";

	private static NettySocketioClient INSTANCE = null;
	private RedissonClient mRedisson;

	private NettySocketioClient() {
		try {
			String path = this.getClass().getResource("/").getPath().toString() + "redis-config.json";
			Config redisConfig = Config.fromJSON(new File(path));
			mRedisson = Redisson.create(redisConfig);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static NettySocketioClient getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new NettySocketioClient();
		}
		return INSTANCE;
	}

	public long send(Message message) {
		Gson gson = new Gson();
		String json = gson.toJson(message);
		return mRedisson.getTopic(SEND).publish(json);
	}

	public long broadcast(Message message) {
		Gson gson = new Gson();
		String json = gson.toJson(message);
		return mRedisson.getTopic(BROADCAST).publish(json);
	}

}
