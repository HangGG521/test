package cn.xaele.vue.bean;

// 用于接收后端如何接收这个 JS 对象呢？我们很自然地想到在需要创建一个形式上一致的 Java 类
public class User {
	
	private int id;
	private String username;
	private String password;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
