package android.amoeba.todo;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import android.content.Intent;
import android.widget.Button;

public class TodoActivity extends Activity {

    protected Button addItemButton;
    private ArrayList<String> items;
    private ArrayAdapter<String> itemsAdapter;
    private ListView listView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo);

        // ADD HERE
        listView2 = (ListView) findViewById(R.id.listView2);
        //the id of the list view of your layout might be different
        items = new ArrayList<String>();
        itemsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
        listView2.setAdapter(itemsAdapter);
        //"this" refers to your activity's context
        TodoAdapter adapter = new TodoAdapter(this, PostActivity.get().tasks);
        //set the adapter so that it can display on the list view
        listView2.setAdapter(adapter);

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
