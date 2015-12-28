package com.fixello.android.app.ui.main.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.fixello.android.app.R;

/**
 * Created by knachiappan on 11/7/15.
 */

public class BaseGridAdapter extends BaseAdapter {

    protected String [] result;
    protected Context context;
    protected int [] imageId;
    protected static LayoutInflater inflater=null;

    public BaseGridAdapter(Activity activity, String[] deviceNameList, int[] deviceImages){
        result = deviceNameList;
        context = activity;
        imageId = deviceImages;
        inflater = ( LayoutInflater )context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return result.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class Holder
    {
        TextView tv;
        ImageView img;
    }

    public View getView(final int position, View convertView, ViewGroup parent) {
      throw new UnsupportedOperationException("getView not Overriden");
    }
}
