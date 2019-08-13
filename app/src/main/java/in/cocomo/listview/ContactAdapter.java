package in.cocomo.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class ContactAdapter extends ArrayAdapter<Contact> {


    public ContactAdapter(Context context, int resource, List<Contact> objects) {
        super(context, resource, objects);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Contact contact=getItem(position);


        if(convertView==null)
            convertView= LayoutInflater.from(getContext()).inflate(R.layout.listitem,parent,false);

        TextView name = convertView.findViewById(R.id.tv_name);
        TextView tv_msg = convertView.findViewById(R.id.tv_msg);
        TextView tv_time = convertView.findViewById(R.id.tv_time);
        ImageView iv_dp = convertView.findViewById(R.id.iv_dp);

        name.setText(contact.getName());
        tv_msg.setText(contact.getMessage());
        tv_time.setText(contact.getTime());


         /*
            Steps to integrate Glide:

            1. Add internet permission in the manifest file

            2. Add android:usesCleartextTraffic="true" inside the application tag in manifest file

            3. Add the library dependency of glide library in the app level gradle file
               ref: https://github.com/bumptech/glide

            4. Use the below code to load image from the url into the imageview

         */
        Glide.with(getContext()).load(contact.getDpUrl()).into(iv_dp);

        return convertView;
    }
}
