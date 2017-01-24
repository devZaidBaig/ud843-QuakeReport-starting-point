package com.example.android.quakereport;

import android.app.Activity;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Zaid on 1/13/2017.
 */

public class WordAdapter extends ArrayAdapter<Data> {

    public WordAdapter(Activity context, ArrayList<Data> data){
        super(context,0, data);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_view_recourse,parent,false);
        }
        Data obj = getItem(position);

        TextView textView1 = (TextView)listItemView.findViewById(R.id.mag);
        GradientDrawable gradientDrawable = (GradientDrawable)textView1.getBackground();
        int color = getMagColor(obj.getMag());
        gradientDrawable.setColor(color);
        Log.v("Tag", String.valueOf(color));
        String magnitude = formatMagnitude(obj.getMag());
        textView1.setText(magnitude);

        String string = obj.getPlace();
        String[] part = string.split("(?<=f)");
        TextView textView2 = (TextView)listItemView.findViewById(R.id.place);
        textView2.setText(" "+part[0]);

        TextView textView = (TextView)listItemView.findViewById(R.id.loc);
        textView.setText(part[1]);

        Date date = new Date(obj.getDate());

        TextView textView3 = (TextView)listItemView.findViewById(R.id.time);
        String formattedDate = formatDate(date);
        textView3.setText(formattedDate);

        TextView textView4 = (TextView)listItemView.findViewById(R.id.date);
        String formattedTime = formatTime(date);
        textView4.setText(formattedTime);

        return listItemView;
    }

    private int getMagColor(double mag) {
        int color;
        int floor = (int) Math.floor(mag);
        Log.v("color", String.valueOf(floor));
        switch (floor){
            case 1 : color = R.color.magnitude1;
                break;
            case 2 : color = R.color.magnitude2;
                break;
            case 3 : color = R.color.magnitude3;
                break;
            case 4 : color = R.color.magnitude4;
                break;
            case 5 : color = R.color.magnitude5;
                break;
            case 6 : color = R.color.magnitude6;
                break;
            case 7 : color = R.color.magnitude7;
                break;
            case 8 : color = R.color.magnitude8;
                break;
            case 9 : color = R.color.magnitude9;
                break;
            case 10 : color = R.color.magnitude10plus;
                break;
            default: color = R.color.magnitude1;
                break;
        }
        return ContextCompat.getColor(getContext(),color);
    }

    private String formatTime(Date date) {
        SimpleDateFormat dateFormate = new SimpleDateFormat("LLL dd,yyyy");
        return dateFormate.format(date);
    }

    private String formatDate(Date date) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(date);
    }

    private String formatMagnitude(double magnitude) {
        DecimalFormat magnitudeFormat = new DecimalFormat("0.0");
        return magnitudeFormat.format(magnitude);
    }
}
