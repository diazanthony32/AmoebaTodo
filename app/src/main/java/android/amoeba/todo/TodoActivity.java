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
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.TimePicker;

import java.util.ArrayList;
import java.util.Calendar;
import android.content.Intent;
import android.widget.Button;

import org.json.JSONArray;


public class TodoActivity extends Activity {

    protected Button addItemButton;
    private ArrayList<String> items;
    private ArrayAdapter<String> itemsAdapter;
    private ListView listView2;
    private String title="";
    private String reminder="";
    private String time="";
    private String date="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo);
        if(getIntent().getStringExtra("title")!= null){
            title = getIntent().getStringExtra("title");
        }
        if(getIntent().getStringExtra("reminder")!= null){
            title = getIntent().getStringExtra("reminder");
        }
        if(getIntent().getStringExtra("time")!= null){
            title = getIntent().getStringExtra("time");
        }
        if(getIntent().getStringExtra("date")!= null){
            title = getIntent().getStringExtra("date");
        }
        // ADD HERE
        listView2 = (ListView) findViewById(R.id.listView2);
        items = new ArrayList<String>();
        itemsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
        listView2.setAdapter(itemsAdapter);
        items.add("First Item");
        items.add("Second Item");
        items.add(title);
        items.add(reminder);
        items.add(time);
        items.add(date);

        addItemButton = (Button)findViewById(R.id.addItemButton);

        addItemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), NewItemActivity.class);
                startActivity(intent);
            }
        });

        //create tasks here: read in json array
        //JSONArray jsonTaskArr = new JSONArray();

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

}
