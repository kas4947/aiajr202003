package model;

public class Emp {
	
	private int empno;
	private String ename;
	private int sal;
	private String job;
	
	
	public Emp(int empno, String ename, int sal, String job) {
		this.empno = empno;
		this.ename = ename;
		this.sal = sal;
		this.job = job;
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
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	
	
	
	

}
