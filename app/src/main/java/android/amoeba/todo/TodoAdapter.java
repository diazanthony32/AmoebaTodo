package android.amoeba.todo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

public class TodoAdapter extends ArrayAdapter<Task> {

    public TodoAdapter(Context context, ArrayList<Task> posts){super(context,0,posts);}

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Task task = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);
        }

        TextView textView = (TextView) convertView.findViewById(android.R.id.text1);
        textView.setText(task.title);

//        TextView textView1 = (TextView) convertView.findViewById(R.id.todoReminder);
//        textView1.setText(task.reminder);
//
//        TextView textView2 = (TextView) convertView.findViewById(R.id.todoTime);
//        textView2.setText(task.time.toString());
//
//        TextView textView3 = (TextView) convertView.findViewById(R.id.todoDate);
//        textView3.setText(task.date.toString());

        return convertView;
    }
}
