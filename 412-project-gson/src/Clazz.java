
public class Clazz {
	private String cno;
	private String cname;
	private String loc;
	public Clazz(){
		
	}
	public Clazz(String cno, String cname, String loc) {
		super();
		this.cno = cno;
		this.cname = cname;
		this.loc = loc;
	}
	public String getCno() {
		return cno;
	}
	public void setCno(String cno) {
		this.cno = cno;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	@Override
	public String toString() {
		return "Clazz [cno=" + cno + ", cname=" + cname + ", loc=" + loc + "]";
	}
	
	
}
