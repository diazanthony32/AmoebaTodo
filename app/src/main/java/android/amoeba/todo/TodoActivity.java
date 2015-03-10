package android.amoeba.todo;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
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


public class TodoActivity extends Activity {

    protected Button addItemButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo);

        addItemButton = (Button)findViewById(R.id.addItemButton);

        addItemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), NewItemActivity.class);
                startActivity(intent);
            }
        });

        //create tasks here: read in json array
//        JSONArray jsonTaskArr = new JSONArray();

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

        JSONObject obj = new JSONObject();
        try {
            obj.put("Name", "crunchify.com");
            obj.put("Author", "App Shah");
        } catch (JSONException error) {

        }

        JSONArray jsonArray = new JSONArray();
        jsonArray.put("");
        jsonArray.put("Company: Paypal");
        jsonArray.put("Company: Google");
        try {
            obj.put("", jsonArray);
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
