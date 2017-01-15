package com.lazada.picturetest.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.lazada.picturetest.R;
import com.lazada.picturetest.helpers.Utils;

/**
 * Created by Harol Higuera on 1/15/17.
 */

public class ListOfCategoriesAdapter extends BaseAdapter {

    private static class ViewHolder {

        TextView Label;

    }

    private String[] items;
    private Context context;

    public ListOfCategoriesAdapter(String[] ix, Context cnt){

        items = ix;
        context = cnt;
    }



    @Override
    public int getCount() {
        return items.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View rowView = view;
        ViewHolder viewholder;

        if (rowView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService
                    (Context.LAYOUT_INFLATER_SERVICE);
            rowView = inflater.inflate(R.layout.item_list_categories, viewGroup, false);

            viewholder = new ViewHolder();

            viewholder.Label = (TextView) rowView.findViewById(R.id.txt_label);

            rowView.setTag(viewholder);

        } else {
            viewholder = (ViewHolder) view.getTag();
        }

        viewholder.Label.setText(items[i]);
        viewholder.Label.setTypeface(Utils.AdventProRegular);

        return rowView;
    }
}
