package android.amoeba.todo;

import android.amoeba.todo.NewItemActivity;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonUtil {
    public static JSONObject toJSon(Task task){
        try {
            JSONObject jsonTask = new JSONObject();
            jsonTask.put("title", task.title);
            jsonTask.put("reminder", task.reminder);
            jsonTask.put("date", task.date);
            jsonTask.put("time", task.time);

//            JSONArray jsonTaskArr = new JSONArray();

            return jsonTask;
        }
        catch(JSONException error){
            Log.e("JSONUtil", "JSONException: " + error);
        }

        return null;
    }
}
