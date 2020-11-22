package com.atguigu.bean;

import java.util.Date;

/**
 * @author LHF
 * @create 2020-09-05-21:15
 *
 * 以后的JavaBean中使用包装类
 * 因为数据库中的所有类型，包括整数等类型都可能是null，而Java中只有引用数据类型才可以赋值为null
 */
public class Employee {
    private Integer eid;
    private String ename;
    private String tel;
    private String gender;//mysql就算char类型，也当是String处理
    private Double salary;
    private Double commissionPct;//故意写的和数据库的字段名不一样
    private Date birthday;
    private Date hiredate;
    private Integer jobId;
    private String email;
    private Integer mid;
    private String address;
    private String nativePlace;
    private Integer did;

    public Employee(Integer eid, String ename, String tel, String gender, Double salary, Double commissionPct, Date birthday, Date hiredate, Integer jobId, String email, Integer mid, String address, String nativePlace, Integer did) {
        this.eid = eid;
        this.ename = ename;
        this.tel = tel;
        this.gender = gender;
        this.salary = salary;
        this.commissionPct = commissionPct;
        this.birthday = birthday;
        this.hiredate = hiredate;
        this.jobId = jobId;
        this.email = email;
        this.mid = mid;
        this.address = address;
        this.nativePlace = nativePlace;
        this.did = did;
    }

    public Employee() {
    }

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Double getCommissionPct() {
        return commissionPct;
    }

    public void setCommissionPct(Double commissionPct) {
        this.commissionPct = commissionPct;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNativePlace() {
        return nativePlace;
    }

    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "eid=" + eid +
                ", ename='" + ename + '\'' +
                ", tel='" + tel + '\'' +
                ", gender='" + gender + '\'' +
                ", salary=" + salary +
                ", commissionPct=" + commissionPct +
                ", birthday=" + birthday +
                ", hiredate=" + hiredate +
                ", jobId=" + jobId +
                ", email='" + email + '\'' +
                ", mid=" + mid +
                ", address='" + address + '\'' +
                ", nativePlace='" + nativePlace + '\'' +
                ", did=" + did +
                '}';
    }
}
