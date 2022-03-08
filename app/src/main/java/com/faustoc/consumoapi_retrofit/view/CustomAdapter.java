package com.faustoc.consumoapi_retrofit.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.faustoc.consumoapi_retrofit.R;
import com.faustoc.consumoapi_retrofit.model.Testimonio;

import java.util.List;

public class CustomAdapter extends BaseAdapter {

    Context context;
    List<Testimonio> lst;

    public CustomAdapter(Context context, List<Testimonio> lst) {
        this.context = context;
        this.lst = lst;
    }

    @Override
    public int getCount() {
        return lst.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImageView user_image,quote_image;
        TextView tvname,tvdesignation,tvmessage;

        Testimonio ts = lst.get(i);

        if (view == null)
            view = LayoutInflater.from(context).inflate(R.layout.listview_item,null);

        //recuperamos los objetos de la vista
        user_image = view.findViewById(R.id.imageViewUser);
        quote_image = view.findViewById(R.id.imageViewQuotes);
        tvname = view.findViewById(R.id.textViewName);
        tvdesignation = view.findViewById(R.id.textViewDesignation);
        tvmessage = view.findViewById(R.id.textViewMessage);

        //asignación de valores
        //Imagenes
        user_image.setImageResource(R.drawable.user_icon);
        quote_image.setImageResource(R.drawable.quotes_icon);

        //Informacion
        tvname.setText(ts.getName());
        tvdesignation.setText(ts.getDesignation());
        tvmessage.setText(ts.getMessage());


        return view;

    }
}
