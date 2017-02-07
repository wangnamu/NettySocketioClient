package com.ufo.NettySocketioClient;

import java.io.File;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

import com.google.gson.Gson;

public class NettySocketioClient {

	private final static String NEWS = "news";
	private final static String BROADCAST = "broadcast";
	private final static String NOTIFYOTHERPLATFORMS = "notifyotherplatforms";

	private static NettySocketioClient INSTANCE = null;
	private RedissonClient mRedisson;

	private NettySocketioClient() throws Exception {

		String path = this.getClass().getResource("/").getPath().toString() + "redis-config.json";
		Config redisConfig = Config.fromJSON(new File(path));
		mRedisson = Redisson.create(redisConfig);

	}

	public static NettySocketioClient getInstance() throws Exception {
		if (INSTANCE == null) {
			INSTANCE = new NettySocketioClient();
		}
		return INSTANCE;
	}

	public long sendNews(Message message) {
		Gson gson = new Gson();
		String json = gson.toJson(message);
		return mRedisson.getTopic(NEWS).publish(json);
	}

	public long broadcast(Message message) {
		Gson gson = new Gson();
		String json = gson.toJson(message);
		return mRedisson.getTopic(BROADCAST).publish(json);
	}

	public long notifyOtherPlatforms(Notify notify) {
		Gson gson = new Gson();
		String json = gson.toJson(notify);
		return mRedisson.getTopic(NOTIFYOTHERPLATFORMS).publish(json);
	}

}
