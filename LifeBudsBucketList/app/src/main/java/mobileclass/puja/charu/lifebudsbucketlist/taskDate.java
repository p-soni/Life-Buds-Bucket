package mobileclass.puja.charu.lifebudsbucketlist;

import java.io.Serializable;

public class taskDate implements Comparable, Serializable {

    private int year;
    private int month;
    private int day;

    public taskDate(int y, int m, int d) {
        this.year=y;
        this.month=m;
        this.day=d;
    }

    public int getDay() { return day; }
    public void setDay(int day) { this.day = day; }
    public int getMonth() { return month; }
    public void setMonth(int month) { this.month = month; }
    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }

    @Override
    public String toString() {
        return (month) + "-" + day + "-" + year;
    }

    //how to sort by date. return 1 if this < passed in date.
    @Override
    public int compareTo(Object o) {
        taskDate d = (taskDate)o;
        if(this.getYear() == d.getYear()) {
            if(this.getMonth() == d.getMonth()) {
                if(this.getDay()==d.getDay()) {
                    return 0; //identical
                }
                else if(this.getDay() < d.getDay()) {
                    return -1;
                }
            }
            else if(this.getMonth() < d.getMonth()) {
                return -1;
            }
        }
        else if(this.getYear() < d.getYear()) {
            return -1;
        }
        return 1;
    }


}