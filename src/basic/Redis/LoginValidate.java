package basic.Redis;

import redis.clients.jedis.Jedis;

import java.util.List;

/**
 * Created by xjc 描述：用Redis和任意语言实现一段恶意登录保护的代码，限制1小时内每用户Id最多只能登录5次
 */
public class LoginValidate {
	final static int EXPIRE_TIME = 10;// 一个周期,10s，设置成10s是因为方便测试，可以改成1h
	final static int MOST_TIMES_IN_TIME_LIMIT = 5;// 一个周期内最多的操作次数

	public static void main(String[] args) {
		Jedis jedis = new Jedis("127.0.0.1", 6379);
		jedis.select(15);
		String userId = "ling1234";

		loginValidateWithQueue(jedis, userId);
		loginValidateWithQueue(jedis, userId);
		loginValidateWithQueue(jedis, userId);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		loginValidateWithQueue(jedis, userId);
		loginValidateWithQueue(jedis, userId);
		//已经登录了5次
		loginValidateWithQueue(jedis, userId);
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		loginValidateWithQueue(jedis, userId);
		loginValidateWithQueue(jedis, userId);
		List<String> values = jedis.lrange(userId, 0, -1);
		for (int i = 0; i < values.size(); i++) {
			System.out.printf(values.get(i) + "\n");
		}
		jedis.del(userId);
		jedis.close();
	}

	/**
	 * 用Redis和任意语言实现一段恶意登录保护的代码，限制1小时内每用户Id最多只能登录5次
	 * 
	 * @param jedis
	 * @param userId
	 * @return
	 */
	public static boolean loginValidateWithQueue(Jedis jedis, String userId) {
		
		/*
		 * llen是指列表的长度
		 */
		Long currentTime = System.currentTimeMillis() / 1000;
		if (jedis.llen(userId) < MOST_TIMES_IN_TIME_LIMIT) {
			jedis.rpush(userId, currentTime.toString());
			System.out.println(currentTime + " 登入成功！" + jedis.llen(userId));
		} else {
			/*
			 * Redis Lindex 命令用于通过索引获取列表中的元素。你也可以使用负数下标，以 -1 表示列表的最后一个元素， -2 表示列表的倒数第二个元素，以此类推
			 */
			String lastFourthTimeStr = jedis.lindex(userId, 0);
			Long lastFourthTime = Long.valueOf(lastFourthTimeStr);
			if (currentTime - lastFourthTime <= EXPIRE_TIME) {
				System.out.println(EXPIRE_TIME + " 秒内只能操作" + MOST_TIMES_IN_TIME_LIMIT + " 次");
				return false;
			} else {
				/*
				 * Redis Lpop 命令用于移除并返回列表的第一个元素
				 */
				jedis.lpop(userId);
				jedis.rpush(userId, currentTime.toString());
				System.out.println(currentTime + " 登入成功！" + jedis.llen(userId));
				return true;
			}
		}
		return true;
	}
}
