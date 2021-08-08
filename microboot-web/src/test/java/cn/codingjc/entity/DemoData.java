package cn.codingjc.entity;

import java.util.Date;

/**
 * @author coding_jc
 * @date 2021/8/8
 */
public class DemoData {
    private String stringTitle;
    private Date dateTitle;
    private Double doubleTitle;

    public String getStringTitle() {
        return stringTitle;
    }

    public void setStringTitle(String stringTitle) {
        this.stringTitle = stringTitle;
    }

    public Date getDateTitle() {
        return dateTitle;
    }

    public void setDateTitle(Date dateTitle) {
        this.dateTitle = dateTitle;
    }

    public Double getDoubleTitle() {
        return doubleTitle;
    }

    public void setDoubleTitle(Double doubleTitle) {
        this.doubleTitle = doubleTitle;
    }

    @Override
    public String toString() {
        return "DemoData{" +
                "stringTitle='" + stringTitle + '\'' +
                ", dateTitle=" + dateTitle +
                ", doubleTitle=" + doubleTitle +
                '}';
    }
}
