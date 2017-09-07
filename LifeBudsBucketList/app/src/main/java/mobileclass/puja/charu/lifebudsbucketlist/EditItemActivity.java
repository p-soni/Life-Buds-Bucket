package mobileclass.puja.charu.lifebudsbucketlist;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Date;


public class EditItemActivity extends AppCompatActivity {


    public EditText edititemNameView;
    public EditText editlongitudeView;
    public EditText editlatitudeView;
    public EditText editdescriptionView;
    public int itemPosition;
    public DatePicker Editcv;
    private Button button;
    public taskDate editdate;

    public void editUphandler(View v){
        this.finish();
    }

//    public void setEdititemNameView(EditText edititemNameView) {
//        this.edititemNameView = edititemNameView;
//    }
//
//    public void setEditcv(CalendarView editcv) {
//        Editcv = editcv;
//    }
//
//    public void setEditlongitudeView(EditText editlongitudeView) {
//        this.editlongitudeView = editlongitudeView;
//    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String description = intent.getStringExtra("des");
        String longi = intent.getStringExtra("long");
        String lati = intent.getStringExtra("lat");
        String day = intent.getStringExtra("day");
        String month = intent.getStringExtra("month");
        String year = intent.getStringExtra("year");
        itemPosition = Integer.parseInt(intent.getStringExtra("position"));


        this.edititemNameView=(EditText)findViewById(R.id.editName);
        this.edititemNameView.setText(name);
        this.editdescriptionView=(EditText)findViewById(R.id.editDes);
        this.editdescriptionView.setText(description);
        this.editlatitudeView=(EditText)findViewById(R.id.editLat);
        this.editlatitudeView.setText(lati);
        this.editlongitudeView=(EditText)findViewById(R.id.editLong);
        this.editlongitudeView.setText(longi);

        this.Editcv = (DatePicker)findViewById(R.id.editCal);
        this.Editcv.updateDate(Integer.parseInt(year), Integer.parseInt(month)-1, Integer.parseInt(day));
//        datePicker.init(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), new DatePicker.OnDateChangedListener() {

//        this.Editcv.init(Editcv.getYear(),Editcv.getMonth(),Editcv.getDayOfMonth(),new DatePicker.OnDateChangedListener(){
//            @Override
//            public void OnDateChanged(DatePicker view, int year, int month, int day){
//                editdate = new taskDate(year, month, day);
//            }
//        });
////        this.Editcv.getCalendarView().setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
////            @Override
////            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
////                editdate = new taskDate(year,month,dayOfMonth);
////            }
////        });


//        BucketListActivity.globalIntent =

        this.button=(Button) findViewById(R.id.saveEdit);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name =edititemNameView.getText().toString();
                String description = editdescriptionView.getText().toString();
                Intent intent = new Intent();
                intent.putExtra("taskName", name+"");
                intent.putExtra("description", description+"");
                intent.putExtra("longitude", editlongitudeView.getText()+"");
                intent.putExtra("latitude", editlatitudeView.getText()+"");
                intent.putExtra("day", Editcv.getDayOfMonth()+"");
                intent.putExtra("month", (Editcv.getMonth()-1)+"");
                intent.putExtra("year", Editcv.getYear()+"");
                intent.putExtra("position",itemPosition+"");
//                intent.putExtra("method","startOnActivityResult");
//                Intent i = new Intent(v.getContext(),BucketListActivity);
//                onResume(i);
//                onActivityResult(3,Activity.RESULT_OK,intent);
                //setResult(3,intent);
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });
    }
}
