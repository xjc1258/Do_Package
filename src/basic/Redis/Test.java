package basic.Redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/*
 * string,hash,set,list,zset
 */
public class Test {

	@org.junit.Test
	public void test1() {
		Jedis jedis = new Jedis("127.0.0.1", 6379);
		jedis.rpush("xjc", "xjc");
		jedis.rpush("xjc", "xjc2");
		jedis.rpush("xjc", "xjc3");
		jedis.rpush("xjc", "xjc4");
		String lpop = jedis.lpop("xjc");
		System.out.println(lpop);
		jedis.close();

	}

}
