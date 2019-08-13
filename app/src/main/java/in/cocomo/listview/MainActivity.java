package in.cocomo.listview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final String TAG="Whatsapp";

        final ArrayList<Contact> contacts = new ArrayList<>();
        final ContactAdapter adapter = new ContactAdapter(this, R.layout.listitem, contacts);
        final ListView lv_item = findViewById(R.id.llcontact);

        OkHttpClient okHttpClient=new OkHttpClient();
        Request request = new Request.Builder().url("http://104.211.25.140/whatsapp/getAll.php").build();

        okHttpClient.newCall(request).enqueue(new Callback() {

            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                Log.d(TAG,e.getMessage());
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {

                try{
                    String temp=response.body().string();
                    JSONArray jsonArray=new JSONArray(temp);

                    for(int i=0;i<jsonArray.length();i++) {
                        JSONObject jsonObject=jsonArray.getJSONObject(i);

                        String name=jsonObject.getString("name");
                        String dp_url=jsonObject.getString("dp_url");
                        String message=jsonObject.getString("message");
                        String time=jsonObject.getString("time");

                        contacts.add(new Contact(name, message,dp_url, time));
                    }

                    MainActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            lv_item.setAdapter(adapter);
                        }
                    });
                }
                catch (Exception e){
                    Log.d(TAG,e.getMessage()+" ");
                }

            }
        });
    }
}

