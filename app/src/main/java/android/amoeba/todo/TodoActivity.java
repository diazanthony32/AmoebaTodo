package android.amoeba.todo;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import android.content.Intent;
import android.widget.Button;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;


public class TodoActivity extends Activity {

    protected Button addItemButton;
    protected Bundle extras;
    protected JSONArray jsonTaskArr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo);

        String jsonTaskExtra = savedInstanceState.getString("jsonTask");
        System.out.println("");
       addItemButton = (Button)findViewById(R.id.addItemButton);

        addItemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), NewItemActivity.class);
                startActivity(intent);
            }
        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.todo, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPause() {
        super.onPause();

            if (jsonTaskArr == null) {
                jsonTaskArr = new JSONArray();
            }


            try {
                JSONObject tempTask = new JSONObject(getIntent().getStringExtra("jsonTask"));
                tempTask.put("", "blah");
                System.out.println(tempTask);
                jsonTaskArr.put(tempTask);
            } catch (JSONException error) {
                Log.e("TodoActivity", "JSON Exception: " + error);
            }




            JSONObject obj = new JSONObject();

            try {
                obj.put("", jsonTaskArr);
            } catch (JSONException error) {

            }

            FileWriter file = null;
            try {
                file = new FileWriter("/Users/<username>/Documents/file1.txt");
                file.write(obj.toString());
                System.out.println("Successfully Copied JSON Object to File...");
                System.out.println("\nJSON Object: " + obj.toString());

            } catch (IOException e) {
                e.printStackTrace();

            }

            try {
                file.flush();
                file.close();
            } catch (IOException close) {


        }
    }
}
