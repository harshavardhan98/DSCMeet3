package in.cocomo.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        String dp_url1="https://upload.wikimedia.org/wikipedia/en/d/d7/Harry_Potter_character_poster.jpg";
        String dp_url2="https://upload.wikimedia.org/wikipedia/en/d/d3/Hermione_Granger_poster.jpg";


        ArrayList<Contact> contacts = new ArrayList<>();
        contacts.add(new Contact("Logesh","hi",dp_url1,"05:50AM"));
        contacts.add(new Contact("Harsha","Hello",dp_url2,"05:50AM"));
        contacts.add(new Contact("Tarun","Good Morning",dp_url1,"05:50AM"));
        contacts.add(new Contact("Ezhil","Bye!!",dp_url2,"05:50AM"));
        contacts.add(new Contact("Kaushik","Hey!",dp_url1,"05:50AM"));

        ContactAdapter adapter = new ContactAdapter(this, R.layout.listitem, contacts);

        ListView lv_item = findViewById(R.id.llcontact);
        lv_item.setAdapter(adapter);
    }
}

