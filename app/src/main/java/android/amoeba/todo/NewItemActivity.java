package android.amoeba.todo;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.content.Intent;
import android.widget.Button;
import java.util.Calendar;

public class NewItemActivity extends Activity{
    protected Button saveItemButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newitem);
        saveItemButton = (Button)findViewById(R.id.saveItemButton);

        saveItemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final EditText titleData = (EditText)findViewById(R.id.title);
                String title = titleData.getText().toString();

                if (title == ""){
                    title = null;
                }

                final EditText reminderData = (EditText)findViewById(R.id.reminder);
                String reminder = reminderData.getText().toString();

                if (reminder == ""){
                    reminder = null;
                }

                final Button timeData = (Button)findViewById(R.id.button);
                String time = timeData.getText().toString();

                if (time == "Select Time"){
                    time = null;
                }

                final Button dateData = (Button)findViewById(R.id.button2);
                String date = dateData.getText().toString();

                if (date == "Select Date"){
                    date = null;
                }
                Intent myIntent = new Intent(getApplicationContext(), TodoActivity.class);

                myIntent.putExtra("title",titleData.getText().toString());
                myIntent.putExtra("reminder",reminderData.getText().toString());
                myIntent.putExtra("time",timeData.getText().toString());
                myIntent.putExtra("date",dateData.getText().toString());

                startActivity(myIntent);

                System.out.println("Title="+title + " Reminder=" + reminder + " Time=" + time + " Date=" + date);

            }
        });
    }

    public void showTimePickerDialog(View v) {
        DialogFragment newFragment = new TimePickerFragment();
        newFragment.show(getFragmentManager(), "timePicker");
    }

    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getFragmentManager(), "datePicker");
    }

}
