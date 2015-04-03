package android.amoeba.todo;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Writer;

import android.content.Intent;
import android.widget.Button;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class TodoActivity extends Activity implements OnClickListener {
    protected Button addItemButton;
//    protected Bundle extras;
    protected JSONArray jsonTaskArr;
    protected File file;
    public Writer writer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo);
        if (file == null) {
            file = new File(getApplicationContext().getFilesDir(), "JSONtask.json");
        }

//        String jsonTaskExtra = savedInstanceState.getString("jsonTask");
//        System.out.println("");
        addItemButton = (Button)findViewById(R.id.addItemButton);

        addItemButton.setOnClickListener(this);

        try {
            FileInputStream inputStream = new FileInputStream(file);
        }catch(FileNotFoundException e) {
            Log.e("TodoActivity", "FileNotFoundException: " + e);
        }


    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getApplicationContext(), NewItemActivity.class);
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode == RESULT_OK){
            if (jsonTaskArr == null) {
                jsonTaskArr = new JSONArray();
            }

            try {
                JSONObject tempTask = new JSONObject(data.getStringExtra("jsonTask"));
                System.out.println(tempTask);
                jsonTaskArr.put(tempTask);

            } catch (JSONException error) {
                Log.e("TodoActivity", "JSON Exception: " + error);
            } catch (Exception e) {
                Log.e("TodoActivity", "IOException: " + e);
            }


            String path = "/JSONtask.json";

            FileOutputStream outputStream;
            try{
                outputStream = openFileOutput("JSONtask.json", getApplicationContext().MODE_PRIVATE);
                System.out.println("Start Writings");
                outputStream.write(jsonTaskArr.toString().getBytes());
                outputStream.close();
                System.out.println("Finish Writings");
            }catch (Exception e){
                System.err.println("Error: " + e);
            }

         }
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



    }
}
