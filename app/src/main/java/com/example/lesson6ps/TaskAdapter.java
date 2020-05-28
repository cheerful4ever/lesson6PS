package com.example.lesson6ps;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class TaskAdapter extends ArrayAdapter<Task> {
    private ArrayList<Task> tasks;
    private Context context;
    private TextView tvName, tvDescription;

    public TaskAdapter(Context context, int resource, ArrayList<Task> objects) {
        super(context, resource, objects);
        tasks = objects;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.row, parent, false);

        tvName = (TextView) rowView.findViewById(R.id.tvName);
        tvDescription = (TextView) rowView.findViewById(R.id.tvDescription);

        Task existTask = tasks.get(position);

        tvName.setText(existTask.getTask_name());
        tvDescription.setText(existTask.getDescription());

        return rowView;
    }
}