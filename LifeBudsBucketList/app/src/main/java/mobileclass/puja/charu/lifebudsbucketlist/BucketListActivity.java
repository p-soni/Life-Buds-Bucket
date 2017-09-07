package mobileclass.puja.charu.lifebudsbucketlist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

import static mobileclass.puja.charu.lifebudsbucketlist.BucketItem.createInitialBucketList;

public class BucketListActivity extends AppCompatActivity {
    ArrayList<BucketItem> allItems;

    TextView newTaskDate;
    Button button1;
    RecyclerView taskList;
    BucketListAdapter adapter;
    public Intent globalIntent = new Intent();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bucket_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        taskList = (RecyclerView) findViewById(R.id.taskList);

        allItems = BucketItem.createInitialBucketList();
        //Collections.sort(allItems);

       // Toast.makeText(getApplicationContext(), "Heyyy we just sorted successfully", Toast.LENGTH_SHORT).show();
        adapter = new BucketListAdapter(this, allItems);
        taskList.setAdapter(adapter);
        taskList.setLayoutManager(new LinearLayoutManager(this));
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BucketListActivity.this, AddItemActivity.class);
                startActivityForResult(intent, 2);// Activity is started with requestCode 2
            }
        });

    }

    public void editItem(View v, BucketItem item, int position){
        Intent intent = new Intent(this, EditItemActivity.class);
        intent.putExtra("name",item.getTaskName()+"");
        intent.putExtra("des", item.getDescription()+"");
        intent.putExtra("long", item.getLongitude()+"");
        intent.putExtra("lat",item.getLatitude()+"");
        intent.putExtra("day",item.getDate().getDay()+"");
        intent.putExtra("month",item.getDate().getMonth()+"");
        intent.putExtra("year",item.getDate().getYear()+"");
        intent.putExtra("position", position+"");
        startActivityForResult(intent, 3);

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        // check if the request code is same as what is passed  here it is 2
        if(requestCode==2 && resultCode == Activity.RESULT_OK)
        {
            taskDate date = new taskDate(Integer.parseInt(data.getStringExtra("year")),Integer.parseInt(data.getStringExtra("month"))+2,Integer.parseInt(data.getStringExtra("day")));
            BucketItem item = new BucketItem(data.getStringExtra("taskName"), data.getStringExtra("description"), false, date,
                    Double.parseDouble(data.getStringExtra("latitude")), Double.parseDouble(data.getStringExtra("longitude")));//create new bucket list object
            Log.d("test",item.getDate().toString());
            //add to allitems
            allItems.add(item);
            //sort all items
            Collections.sort(allItems);
            //
            adapter.notifyDataSetChanged();

        }
        else if(requestCode==3 && resultCode==Activity.RESULT_OK){
            //boolean bool = allItems.get(Integer.parseInt(data.getStringExtra("position"))).isComplete();
            //allItems.remove(data.getStringExtra("position"));
            taskDate date = new taskDate(Integer.parseInt(data.getStringExtra("year")),Integer.parseInt(data.getStringExtra("month"))+2,Integer.parseInt(data.getStringExtra("day")));
//            BucketItem item = new BucketItem(data.getStringExtra("taskName"), data.getStringExtra("description"), bool, date,
//                    Double.parseDouble(data.getStringExtra("latitude")), Double.parseDouble(data.getStringExtra("longitude")));

            String name = data.getStringExtra("taskName");
            String descr = data.getStringExtra("description");
            Double lat = data.getDoubleExtra("latitude", 0);
            Double lng = data.getDoubleExtra("longitude", 0);

            int position = Integer.parseInt(data.getStringExtra("position"));

            BucketItem item = allItems.get(position);
            item.setDate(date);
            item.setTaskName(name);
            item.setDescription(descr);
            item.setLongitude(lng);
            item.setLatitude(lat);


           // allItems.add(item);
            Collections.sort(allItems);
            adapter.notifyDataSetChanged();

        }
    }

//    public void onResume(){
//
//    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_bucket_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
