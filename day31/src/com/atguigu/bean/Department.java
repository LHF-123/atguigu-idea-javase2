package com.atguigu.bean;

/**
 * @author LHF
 * @create 2020-09-05-21:11
 */
public class Department {
    private Integer did;
    private String dname;
    private String description;

    public Department(Integer did, String dname, String description) {
        this.did = did;
        this.dname = dname;
        this.description = description;
    }

    public Department() {
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Department{" +
                "did=" + did +
                ", dname='" + dname + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
