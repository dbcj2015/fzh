
public class User {
	private String id;
	private String name;
	private String fav;
	private String addr;
	public User(String id, String name, String fav, String addr) {
		super();
		this.id = id;
		this.name = name;
		this.fav = fav;
		this.addr = addr;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFav() {
		return fav;
	}
	public void setFav(String fav) {
		this.fav = fav;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", fav=" + fav + ", addr="
				+ addr + "]";
	}
	
	
}
