package org.esiea.badelon_batista.androidapplication_guideparis;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by Benjamin on 27/12/2015.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private ItemData[] itemsData;
    private TextView textViewName;
    private Context mcontext;

    public RecyclerViewAdapter(Context context, ItemData[] itemsData) {

        this.itemsData = itemsData;
        this.mcontext=context;
    }

    @Override
    public int getItemCount() {
        return itemsData.length;
    }

    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_card, parent, false);


        return new RecyclerViewAdapter.ViewHolder(view) {
        };

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.txtViewTitle.setText(itemsData[position].getTitle()); //definir le titre
        holder.txtViewDescr.setText(itemsData[position].getDescr());//definir la description
       Picasso.with(mcontext).load(itemsData[position].getImageUrl()).into(holder.imgViewIcon); //Utilisation de picasso pour definir l'image de l'article

    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView txtViewTitle;
        public ImageView imgViewIcon;
        public TextView txtViewDescr;

        public ViewHolder(View itemLayoutView) {
            super(itemLayoutView);
            txtViewTitle = (TextView) itemLayoutView.findViewById(R.id.title);
            txtViewDescr = (TextView) itemLayoutView.findViewById(R.id.description);
            imgViewIcon = (ImageView) itemLayoutView.findViewById(R.id.thumbnail);
        }
    }

}