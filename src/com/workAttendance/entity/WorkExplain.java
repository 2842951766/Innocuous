package com.workAttendance.entity;


import javax.persistence.*;

/*
* 加班，外勤说明(目前仅用于外勤)
* */

@Entity
@Table(name="workExplain")
public class WorkExplain {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "outWorkPic")
    String outWorkPic;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOutWorkPic() {
        return outWorkPic;
    }

    public void setOutWorkPic(String outWorkPic) {
        this.outWorkPic = outWorkPic;
    }
}
