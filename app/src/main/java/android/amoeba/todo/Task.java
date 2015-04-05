package android.amoeba.todo;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

public class Task {

    public final String title;
    public final String reminder;
    public final Date date;
    public final android.text.format.Time time;

    public Task(String title, String reminder, Date date, android.text.format.Time time) {
        this.title = title;
        this.reminder = reminder;
        this.date = date;
        this.time = time;
    }
}
