package basic.Redis;



import org.apache.commons.lang.StringUtils;

import redis.clients.jedis.Jedis;
 
/**
 * 消息发布方
 * @author xjc
 */
public class Publisher {
 
    public static final String CHANNEL_KEY = "channel:message";
    private Jedis jedis;
 
    public Publisher() {
        jedis = MyJedisFactory.getJedis();
    }
 
    public void publishMessage(String message) {
        if(StringUtils.isBlank(message)) {
            return;
        }
        jedis.publish(CHANNEL_KEY, message);
    }
 
    public static void main(String[] args) {
        Publisher publisher = new Publisher();
        publisher.publishMessage("Hello Redis!");
    }
}
