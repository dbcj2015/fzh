package jedis;

import static org.junit.Assert.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import redis.clients.jedis.Jedis;

public class jedis {
	Jedis jedis = null;
	public jedis(){
		jedis = new Jedis("127.0.0.1" , 6379);
		jedis.auth("123456");
		jedis.select(3);
		//jedis.flushDB();//清空当前数据库
	}
	
	//Redis 5中类型  string  hash list set ordered-set
	@Test
	public void testString() {
		jedis.set("name", "齐毅");
		jedis.mset("name" , "张三" , "age" , "29" , "sex" , "male");
		Set<String> keys = jedis.keys("*");
		System.out.println(keys);
	}
	
	@Test
	public void testSetMap(){
		Map goods = new LinkedHashMap();
		goods.put("title", "雅培3段进口奶粉");
		goods.put("price", "87.5");//redis只认识string
		jedis.hmset("GOODS:1", goods);
		System.out.println(jedis.hget("GOODS:1", "title"));
	}
	
	@Test
	public void testGetMap(){
		Map<String,String> goods = jedis.hgetAll("GOODS:1");
		System.out.println(goods);
	}
	
	@Test
	public void testList(){
		jedis.lpush("list", "5");
		jedis.lpush("list", "4");
		jedis.rpush("list", "6");
		jedis.lpush("list", "3");
		jedis.lpush("list", "2");
		jedis.lpush("list", "1");
		jedis.rpush("list", "7");
		List<String> list = jedis.lrange("list", 0, -1);
		System.out.println(list);
	}
	
	@Test
	public void testSet(){
		jedis.sadd("language", "JAVA");
		jedis.sadd("language", "PHP");
		jedis.sadd("language", "C");
		jedis.sadd("language", "C++");
		jedis.sadd("language", "PYTHON");
		jedis.sadd("language", "PYTHON");
		jedis.sadd("language", "ANDROID");
		Set<String> ls = jedis.smembers("language");
		System.out.println(ls);
	}
	
	@Test
	public void testSetObject(){
		Person p = new Person(100 , "齐毅");
		jedis.set("PERSON:100".getBytes(), SerializableUtils.serialize(p));
		
	}
	
	@Test
	public void testGetObject(){
		byte[] bs = jedis.get("PERSON:100".getBytes() );
		Person p = (Person)SerializableUtils.unserialize(bs);
		System.out.println(p.getName());
	}
}
