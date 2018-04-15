package jedis;

import java.io.Serializable;

//所有对象要被Redis保存,必须实现Serializable(序列化)接口
public class Person implements Serializable {
	private int id;
	private String name;

	public Person(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}
}