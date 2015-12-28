package com.fixello.android.app.ui.main.adapters;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.fixello.android.app.R;
import com.fixello.android.app.ui.main.fragments.DeviceModelFragment;

/**
 * Created by knachiappan on 12/10/15.
 */
public class DeviceModelAdapter extends BaseGridAdapter{

    public DeviceModelAdapter(Activity activity, String[] deviceNameList, int[] deviceImages) {
        super(activity,deviceNameList, deviceImages);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        Holder holder=new Holder();
        View rowView;

        rowView = inflater.inflate(R.layout.device_type_layout, null);
        holder.tv=(TextView) rowView.findViewById(R.id.deviceTypeText);
        holder.img=(ImageView) rowView.findViewById(R.id.deviceTypeImage);

        holder.tv.setText(result[position]);
        holder.img.setImageResource(imageId[position]);

        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Change this to make call to DeviceModelFragment
                Toast.makeText(context, "You Clicked " + result[position], Toast.LENGTH_LONG).show();
            }
        });

        return rowView;
    }
}
