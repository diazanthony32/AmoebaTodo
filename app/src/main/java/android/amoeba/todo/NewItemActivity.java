package android.amoeba.todo;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class NewitemActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newitem);
    }


    public class DatePickerFragment extends DialogFragment
            implements DatePickerDialog.OnDateSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            // Create a new instance of DatePickerDialog and return it
            return new DatePickerDialog(getActivity(), this, year, month, day);
        }

        public void onDateSet(DatePicker view, int year, int month, int day) {

            System.out.println("month=" + month+1 + " day=" + day + " year="
                    + year);

                TextView textElement = (TextView) findViewById(R.id.button2);

                year = year-2000;

                textElement.setText(month+1 + " / " + day + " / " + year);

        }

        }


    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getFragmentManager(), "datePicker");
    }

    public class TimePickerFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current time as the default values for the picker
            final Calendar c = Calendar.getInstance();
            int hour = c.get(Calendar.HOUR_OF_DAY);
            int minute = c.get(Calendar.MINUTE);

            // Create a new instance of TimePickerDialog and return it
            return new TimePickerDialog(getActivity(), this, hour, minute,
                    DateFormat.is24HourFormat(getActivity()));
        }

        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {


            System.out.println("Hour=" + hourOfDay + " Minute=" + minute);

            if (hourOfDay > 12){

                hourOfDay = hourOfDay - 12;

                TextView textElement = (TextView) findViewById(R.id.button);

                if ( minute < 10 ){

                    textElement.setText(hourOfDay + " : 0" + minute + " PM"); //leave this line to assign a string resource

                }

                else {

                    textElement.setText(hourOfDay + " : " + minute + " PM"); //leave this line to assign a string resource

                }

            }

            else {

                TextView textElement = (TextView) findViewById(R.id.button);

                if ( minute < 10 ){

                    textElement.setText(hourOfDay + " : 0" + minute + " AM"); //leave this line to assign a string resource

                }

                else {

                    textElement.setText(hourOfDay + " : " + minute + " AM"); //leave this line to assign a string resource

                }

            }

        }

    }

    public void showTimePickerDialog(View v) {
        DialogFragment newFragment = new TimePickerFragment();
        newFragment.show(getFragmentManager(), "timePicker");
    }

    public void sendFeedback(View button){



    }

}
