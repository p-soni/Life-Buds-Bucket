package mobileclass.puja.charu.lifebudsbucketlist;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Charu on 1/28/2017.
 */

public class BucketListAdapter extends RecyclerView.Adapter<BucketListAdapter.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView nameTextView;  //descriptiontextview
        public TextView nameDateView; //datetextview
        public CheckBox checkBoxView;
        public View rowView;

        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);
            rowView = itemView.findViewById(R.id.rowview);
            nameTextView = (TextView) itemView.findViewById(R.id.taskName);
            nameDateView = (TextView) itemView.findViewById(R.id.date);
            checkBoxView = (CheckBox) itemView.findViewById(R.id.checkBox1);
        }

    }

    // Store a member variable for the contacts
    private ArrayList<BucketItem> tasklist;
    // Store the context for easy access
    private Context mContext;

    // Pass in the contact array into the constructor
    public BucketListAdapter(Context context, ArrayList<BucketItem> items) {
        tasklist = items;
        mContext = context;
    }

    // Easy access to the context object in the recyclerview
    private Context getContext() {
        return mContext;
    }
//    private final View.OnClickListener

    // Usually involves inflating a layout from XML and returning the holder
    @Override
    public BucketListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View itemView = inflater.inflate(R.layout.item_bucket, parent, false);
//        itemView.setOnClickListener(mOnClickListener);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }

    // Involves populating data into the item through holder
    @Override
    public void onBindViewHolder(BucketListAdapter.ViewHolder viewHolder, int position) {
        // Get the data model based on position
        BucketItem item = tasklist.get(position);

        // Set item views based on your views and data model
        TextView textView = viewHolder.nameTextView;
        textView.setText(item.getTaskName());

        TextView dateview = viewHolder.nameDateView;
        dateview.setText(item.getDate().toString());
        final int position1 = position;

        CheckBox check = viewHolder.checkBoxView;
        View itemrow = viewHolder.rowView;
        itemrow.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                BucketItem item1 = tasklist.get(position1);
                ((BucketListActivity) mContext).editItem(v, item1, position1);
            }
        });

//        viewHolder.nameTextView.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view){
//                Intent intent = new Intent(view.getContext(),EditItemActivity.class);
//                intent.putExtra("position", tasklist.get(position)+"");
//                intent.putExtra("name",tasklist.get(position).getTaskName()+"");
//                intent.putExtra("des", tasklist.get(position).getDescription()+"");
//                intent.putExtra("long", tasklist.get(position).getLongitude()+"");
//                intent.putExtra("lat",tasklist.get(position).getLatitude()+"");
//                intent.putExtra("day",tasklist.get(position).getDate().getDay()+"");
//                intent.putExtra("month",tasklist.get(position).getDate().getMonth()+"");
//                intent.putExtra("year",tasklist.get(position).getDate().getYear()+"");
//                view.getContext().startActivity(intent);
//            }
//        });

        if(item.isComplete()){
            check.setChecked(true);
        }else{
            check.setChecked(false);
        }
        check.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                tasklist.get(position1).setComplete();
                notifyDataSetChanged();
                Collections.sort(tasklist);
            }
        });


    }

    // Returns the total count of items in the list
    @Override
    public int getItemCount() {
        return tasklist.size();
    }


    }
