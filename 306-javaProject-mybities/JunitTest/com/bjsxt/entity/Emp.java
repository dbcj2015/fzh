package com.bjsxt.entity;

import java.util.Date;

public class Emp {
		private int empno;
		private String ename;
		private String job;
		private int mgr;
		private Date hiredate;
		private int sal;
		private int comm;
		private int deptno;
		private Dept d;
		//针对数据库中的sal_price字段,实体类中是无法使用相同的命名方式
		private int salPrice;
		public int getSalPrice() {
			return salPrice;
		}
		public void setSalPrice(int salPrice) {
			this.salPrice = salPrice;
		}
		public Dept getD() {
			return d;
		}
		public void setD(Dept d) {
			this.d = d;
		}
		public int getEmpno() {
			return empno;
		}
		public void setEmpno(int empno) {
			this.empno = empno;
		}
		public String getEname() {
			return ename;
		}
		public void setEname(String ename) {
			this.ename = ename;
		}
		public String getJob() {
			return job;
		}
		public void setJob(String job) {
			this.job = job;
		}
		public int getMgr() {
			return mgr;
		}
		public void setMgr(int mgr) {
			this.mgr = mgr;
		}
		public Date getHiredate() {
			return hiredate;
		}
		public void setHiredate(Date hiredate) {
			this.hiredate = hiredate;
		}
		public int getSal() {
			return sal;
		}
		public void setSal(int sal) {
			this.sal = sal;
		}
		public int getComm() {
			return comm;
		}
		public void setComm(int comm) {
			this.comm = comm;
		}
		public int getDeptno() {
			return deptno;
		}
		public void setDeptno(int deptno) {
			this.deptno = deptno;
		}
}
