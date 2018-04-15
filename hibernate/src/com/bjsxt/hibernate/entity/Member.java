package com.bjsxt.hibernate.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
@Entity //说明这是一个实体类
@Table(name="t_member") //对应t_member表
public class Member {
	@Id //这是主键
	@Column(name="member_id")
	@GenericGenerator(name="kg" , strategy="native") //定义了一个主键生成器,名字是kg,策略采用natvie(自动选择)
	@GeneratedValue(generator="kg" , strategy=GenerationType.AUTO) //利用已经定义好的生成器为memberId生成主键
	private Integer memberId;
	//默认情况下,Hibernate会将属性名作为字段名进行自动映射
	private String username;
	private String nickname;
	private String password;
	private String salt;
	@Column(name="reg_date")
	private Date regDate;
	private Integer state;
	
	public Integer getMemberId() {
		return memberId;
	}
	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	
}
