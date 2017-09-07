package mobileclass.puja.charu.lifebudsbucketlist;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Date;

public class AddItemActivity extends Activity {

    private EditText itemNameView;
    private EditText longitudeView;
    private EditText latitudeView;
    private EditText descriptionView;
    private DatePicker cv;
    private Button button;

    public void uphandler(View v){
        this.finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        //Intent intent = getIntent();

        this.itemNameView=(EditText)findViewById(R.id.addName);
        this.longitudeView=(EditText)findViewById(R.id.addLong);
        this.latitudeView=(EditText)findViewById(R.id.addLat);
        this.descriptionView=(EditText)findViewById(R.id.addDes);

        this.cv=(DatePicker)findViewById(R.id.addDate);
//        cv.getCalendarView().setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
//            @Override
//            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
//                date = new taskDate(year,month,dayOfMonth);
//            }
//        });

        this.button=(Button) findViewById(R.id.saveAdding);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name =itemNameView.getText().toString();
                String description = descriptionView.getText().toString();
                Integer day = cv.getDayOfMonth();
                Integer month = cv.getMonth()-1;
                Integer year = cv.getYear();

                Intent intent = new Intent();
                intent.putExtra("taskName", name+"");
                intent.putExtra("description", description+"");
                intent.putExtra("longitude", longitudeView.getText()+"");
                intent.putExtra("latitude", latitudeView.getText()+"");
                intent.putExtra("day", day.toString()+"");
                intent.putExtra("month", month.toString()+"");
                intent.putExtra("year", year.toString()+"");
                Log.d("test", year.toString()+"-"+month.toString()+"-"+day.toString());
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });


    }

//    public void loadInput(View view) {
//
//        //Long date =cv.getDate();
//       // Date d = new Date(date);
//      //  String taskD = (new taskDate(d.getYear(),d.getMonth(),d.getDay())).toString();
//
//    }
}//package mobileclass.puja.charu.lifebudsbucketlist;
//
//import android.app.Activity;
//import android.content.Intent;
//import android.support.v7.app.ActionBar;
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.support.v7.widget.Toolbar;
//import android.util.Log;
//import android.view.MenuItem;
//import android.view.View;
//import android.widget.Button;
//import android.widget.CalendarView;
//import android.widget.EditText;
//
//import java.util.Date;
//
//public class AddItemActivity extends Activity {
//
//    private EditText itemNameView;
//    private EditText longitudeView;
//    private EditText latitudeView;
//    private EditText descriptionView;
//    private CalendarView cv;
//    private Button button;
//    private taskDate date;
//
//    public void uphandler(View v){
//        this.finish();
//    }
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_add_item);
//
//        //Intent intent = getIntent();
//
//        this.itemNameView=(EditText)findViewById(R.id.addName);
//        this.longitudeView=(EditText)findViewById(R.id.addLong);
//        this.latitudeView=(EditText)findViewById(R.id.addLat);
//        this.descriptionView=(EditText)findViewById(R.id.addDes);
//        this.cv=(CalendarView)findViewById(R.id.addDate);
//        cv.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
//            @Override
//            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
//                date = new taskDate(year,month,dayOfMonth);
//            }
//        });
//        this.button=(Button) findViewById(R.id.saveAdding);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent();
//                intent.putExtra("taskName", itemNameView.getText());
//                intent.putExtra("description", descriptionView.getText());
//                intent.putExtra("longitude", longitudeView.getText()+"");
//                intent.putExtra("latitude", latitudeView.getText()+"");
//                intent.putExtra("date", date.toString());
//                Log.d("test",date.toString());
//                setResult(Activity.RESULT_OK, intent);
//                finish();
//            }
//        });
//
//
//    }
//
//    public void loadInput(View view) {
//        String name =itemNameView.getText().toString();
//        String description = descriptionView.getText().toString();
//        Long date =cv.getDate();
//        Date d = new Date(date);
//        String taskD = (new taskDate(d.getYear(),d.getMonth(),d.getDay())).toString();
//
//    }
//}
