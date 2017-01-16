package com.lazada.picturetest.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lazada.picturetest.R;
import com.lazada.picturetest.helpers.Utils;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Harol Higuera on 1/16/17.
 */

public class PhotoListAdapter extends RecyclerView.Adapter<PhotoListAdapter.ViewHolder> {

    private ArrayList<String> photos = new ArrayList<>();
    private ArrayList<String> authors = new ArrayList<>();
    private ArrayList<String> titles = new ArrayList<>();
    private ArrayList<String> avatar = new ArrayList<>();

    private Context context;
    private Picasso picasso;
    private int heightx;
    private int widthx;


    /**
     *
     *
     *
     *
     *
     */

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView holder_author;
        private TextView holder_title;
        private ImageView holder_photo;
        private CircleImageView holder_avatar;

        ViewHolder(View itemView) {
            super(itemView);


            holder_author = (TextView) itemView.findViewById(R.id.txt_author);
            holder_title = (TextView) itemView.findViewById(R.id.txt_title);
            holder_photo = (ImageView) itemView.findViewById(R.id.img_photo);
            holder_avatar = (CircleImageView) itemView.findViewById(R.id.img_avatar);

        }


        TextView getHolder_author() {
            return holder_author;
        }

        TextView getHolder_title() {
            return holder_title;
        }

        ImageView getHolder_photo() {
            return holder_photo;
        }

        ImageView getHolder_avatar() {
            return holder_avatar;
        }
    }

    /**
     *
     *
     *
     *
     *
     *
     *
     *
     *
     */

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list_photos, parent, false);

        return new ViewHolder(v);
    }


    /**
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     */

    public PhotoListAdapter(Context cnt, Picasso picasso) {

        this.context = cnt;
        this.picasso = picasso;

        DisplayMetrics metrics = cnt.getResources().getDisplayMetrics();
        widthx = Math.round(metrics.widthPixels);
        heightx = Math.round(widthx / 5);


    }

    /**
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     */


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.getHolder_author().setText(authors.get(position));
        holder.getHolder_author().setTypeface(Utils.AdventProRegular);

        holder.getHolder_title().setText(titles.get(position));
        holder.getHolder_title().setTypeface(Utils.AdventProRegular);

        picasso.load(photos.get(position))
                .resize(widthx, Utils.pxFromDp(context, 150))
                .centerCrop()
                .into(holder.getHolder_photo());

        picasso.load(avatar.get(position))
                .resize(Utils.pxFromDp(context, 40), Utils.pxFromDp(context, 40))
                .centerCrop()
                .into(holder.getHolder_avatar());

    }

    /**
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     */
    @Override
    public int getItemCount() {

        if (photos == null)
            return 0;
        return photos.size();
    }

    /**
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     */
    public void UpdateEntries(ArrayList<String> p, ArrayList<String> a, ArrayList<String> t, ArrayList<String> av) {
        photos = new ArrayList<>(p);
        authors = new ArrayList<>(a);
        titles = new ArrayList<>(t);
        avatar = new ArrayList<>(av);
        notifyDataSetChanged();

    }
}
