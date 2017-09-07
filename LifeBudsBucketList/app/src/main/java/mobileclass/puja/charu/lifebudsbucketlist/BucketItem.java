package mobileclass.puja.charu.lifebudsbucketlist;

import java.nio.channels.ByteChannel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

/**
 * Created by Charu on 1/28/2017.
 */

public class BucketItem implements Comparable {
    private String taskName;
    private taskDate date;
    private String stringDate;
    public boolean complete;
    private String description;
    private double latitude;
    private double longitude;

    public BucketItem(String n, String desc, boolean c, taskDate dt, double lat, double lon) {
        taskName = n;
        description = desc;
        complete = c;
        date = dt;
        latitude=lat;
        longitude=lon;
    }
    public BucketItem(String n, String desc, boolean c, String dt, double lat, double lon) {
        taskName = n;
        description = desc;
        complete = c;
        stringDate = dt;
        latitude=lat;
        longitude=lon;
    }

    public void onClick(){

    }

    public String getTaskName() {
        return taskName;
    }
    public void setTaskName(String n) { taskName = n; }
    public String getDescription() { return description; }
    public void setDescription(String d) { description = d; }
    public taskDate getDate() {
        return date;
    }
    public void setDate(taskDate d) {
        date.setDay(d.getDay());
        date.setMonth(d.getMonth());
        date.setYear(d.getYear());
    }
    public double getLatitude() { return latitude; }
    public void setLatitude(double lt) { latitude = lt; }
    public double getLongitude() { return longitude; }
    public void setLongitude(double lg) { longitude = lg; }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(){
        complete= !complete;
    }
    //jhgkjh

    public int compareTo(Object o) {
        BucketItem b = (BucketItem) o;
        if (this.complete && b.complete || !this.complete && !b.complete) {
            //both are complete or notcomplete, so comapre their dates
            return this.getDate().compareTo(b.getDate());
        }
        //else one of them isn't complete and the other is
        else {
            if (!this.complete && b.complete) {
                return -1;
            } else if (this.complete && !b.complete) {
                return 1;
            }
            return 0;
        }
    }

    public static ArrayList<BucketItem> createInitialBucketList() {
        taskDate d1 = new taskDate(2017,3,17);
        taskDate d2 = new taskDate(2018,1,20);
        taskDate d3 = new taskDate(2017,2,16);

        ArrayList<BucketItem> items = new ArrayList<BucketItem>();

        BucketItem item1 = new BucketItem("Eat Bodos", "Get #1 ticket!", false, d1, 31.234, 42.345);
        BucketItem item2 = new BucketItem("Pickup cap and gown", "Pickup from Newcomb ballroom", true, d2, 0.0, 0.0);
        BucketItem item3 = new BucketItem("Jump Cville", "Go with Sam and Bob", false, d3, 23.435, 56.987);
        items.add(item1);
        items.add(item2);
        items.add(item3);
        Collections.sort(items);
        return items;
    }

}
