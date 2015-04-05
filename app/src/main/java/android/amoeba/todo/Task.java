package android.amoeba.todo;

import android.content.Intent;
import android.os.Bundle;
import android.text.format.Time;

import java.util.ArrayList;
import java.util.Date;

public class Task {

    public final String title;
    public final String reminder;
    public final String date;
    public final String time;

    public Task(String title, String reminder, String date, String time) {
        this.title = title;
        this.reminder = reminder;
        this.date = date;
        this.time = time;
    }
}
