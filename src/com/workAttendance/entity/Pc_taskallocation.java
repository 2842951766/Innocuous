package com.workAttendance.entity;

import javax.persistence.*;

//存放收集工作的任务分配信息
@Entity
@Table(name="pc_taskallocation")
public class Pc_taskallocation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Column(name = "report_number")
    private String report_number;

    //    报案编号
    @Column(name = "caseno")
    private String caseno;

//    任务内容
    @Column(name = "caseinfo")
    private String caseinfo;
//    车牌号
    @Column(name = "car_number")
    private String car_number;
//    驾驶员
    @Column(name = "driverid")
    private int driverid;
//    收集员
    @Column(name = "collectorid")
    private int collectorid;
//    监督员
    @Column(name = "supervisorid")
    private int supervisorid;
//保险员
    @Column(name = "insurersid")
    private int insurersid;
//发送任务给驾驶员的时间
    @Column(name = "driver_time1")
    private String driver_time1;
//驾驶员回复的内容（是或否）
    @Column(name = "driver_response")
    private String driver_response;
//驾驶员回复的时间
    @Column(name = "driver_time2")
    private String driver_time2;
//发送任务给收集员的时间
    @Column(name = "collector_time1")
    private String collecto_time1;
//收集员回复的内容
    @Column(name = "collector_response")
    private String collector_response;
//收集员回复的时间
    @Column(name = "collector_time2")
    private String collector_time2;
//发送任务给监督员的时间
    @Column(name = "supervisor_time1")
    private String supervisor_time1;
//监督员的回复
    @Column(name = "supervisor_response")
    private String supervisor_response;
//监督员回复的时间
    @Column(name = "supervisor_time2")
    private String supervisor_time2;
//发送任务给保险员的时间
    @Column(name = "insurers_time1")
    private String insurers_time1;
//保险员的回复
    @Column(name = "insurers_response")
    private String insurers_response;
//保险员回复的时间
    @Column(name = "insurers_time2")
    private String insurers_time2;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReport_number() {
        return report_number;
    }

    public void setReport_number(String report_number) {
        this.report_number = report_number;
    }

    public String getCaseinfo() {
        return caseinfo;
    }

    public void setCaseinfo(String caseinfo) {
        this.caseinfo = caseinfo;
    }

    public String getCar_number() {
        return car_number;
    }

    public void setCar_number(String car_number) {
        this.car_number = car_number;
    }

    public String getCaseno() {
        return caseno;
    }

    public void setCaseno(String caseno) {
        this.caseno = caseno;
    }

    public int getDriverid() {
        return driverid;
    }

    public void setDriverid(int driverid) {
        this.driverid = driverid;
    }

    public int getCollectorid() {
        return collectorid;
    }

    public void setCollectorid(int collectorid) {
        this.collectorid = collectorid;
    }

    public int getSupervisorid() {
        return supervisorid;
    }

    public void setSupervisorid(int supervisorid) {
        this.supervisorid = supervisorid;
    }

    public int getInsurersid() {
        return insurersid;
    }

    public void setInsurersid(int insurersid) {
        this.insurersid = insurersid;
    }

    public String getDriver_time1() {
        return driver_time1;
    }

    public void setDriver_time1(String driver_time1) {
        this.driver_time1 = driver_time1;
    }

    public String getDriver_response() {
        return driver_response;
    }

    public void setDriver_response(String driver_response) {
        this.driver_response = driver_response;
    }

    public String getDriver_time2() {
        return driver_time2;
    }

    public void setDriver_time2(String driver_time2) {
        this.driver_time2 = driver_time2;
    }

    public String getCollecto_time1() {
        return collecto_time1;
    }

    public void setCollecto_time1(String collecto_time1) {
        this.collecto_time1 = collecto_time1;
    }

    public String getCollector_response() {
        return collector_response;
    }

    public void setCollector_response(String collector_response) {
        this.collector_response = collector_response;
    }

    public String getCollector_time2() {
        return collector_time2;
    }

    public void setCollector_time2(String collector_time2) {
        this.collector_time2 = collector_time2;
    }

    public String getSupervisor_time1() {
        return supervisor_time1;
    }

    public void setSupervisor_time1(String supervisor_time1) {
        this.supervisor_time1 = supervisor_time1;
    }

    public String getSupervisor_response() {
        return supervisor_response;
    }

    public void setSupervisor_response(String supervisor_response) {
        this.supervisor_response = supervisor_response;
    }

    public String getSupervisor_time2() {
        return supervisor_time2;
    }

    public void setSupervisor_time2(String supervisor_time2) {
        this.supervisor_time2 = supervisor_time2;
    }

    public String getInsurers_time1() {
        return insurers_time1;
    }

    public void setInsurers_time1(String insurers_time1) {
        this.insurers_time1 = insurers_time1;
    }

    public String getInsurers_response() {
        return insurers_response;
    }

    public void setInsurers_response(String insurers_response) {
        this.insurers_response = insurers_response;
    }

    public String getInsurers_time2() {
        return insurers_time2;
    }

    public void setInsurers_time2(String insurers_time2) {
        this.insurers_time2 = insurers_time2;
    }
}
