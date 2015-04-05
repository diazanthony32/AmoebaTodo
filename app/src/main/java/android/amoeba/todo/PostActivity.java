package android.amoeba.todo;

import java.util.ArrayList;


public class PostActivity {

    private static PostActivity postActivity;
    public static ArrayList<Task> tasks;

    //This constructor will initialize your singleton object, but it
    //can only be called within this class, to create the object
    //use the get() function.
    private PostActivity() {
        tasks = new ArrayList<Task>();
    }

    //Creates your singleton object. You also need to access this object
    //using this get function
    public static PostActivity get() {
        if(tasks == null) {
            postActivity = new PostActivity();
        }
        return postActivity;
    }

    //Add a new task to the ArrayList for storage.
    public static void add(Task newTask) {
        tasks.add(newTask);
    }

}