package org.esiea.badelon_batista.androidapplication_guideparis;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Benjamin on 27/12/2015.
 */
public class TestRecyclerViewAdapter extends RecyclerView.Adapter<TestRecyclerViewAdapter.ViewHolder> {

    private ItemData[] itemsData;
    private TextView textViewName;

    public TestRecyclerViewAdapter(ItemData[] itemsData) {

        this.itemsData = itemsData;
    }

    @Override
    public int getItemCount() {
        return itemsData.length;
    }

    @Override
    public TestRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
       /* View itemLayoutView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_card, null);

        // create ViewHolder
        ViewHolder viewHolder = new ViewHolder(itemLayoutView);
        return viewHolder;*/

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_card, parent, false);


        return new TestRecyclerViewAdapter.ViewHolder(view) {
        };

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.txtViewTitle.setText(itemsData[position].getTitle());
        holder.imgViewIcon.setImageResource(itemsData[position].getImageUrl());

    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView txtViewTitle;
        public ImageView imgViewIcon;

        public ViewHolder(View itemLayoutView) {
            super(itemLayoutView);
            txtViewTitle = (TextView) itemLayoutView.findViewById(R.id.item_title);
            imgViewIcon = (ImageView) itemLayoutView.findViewById(R.id.item_icon);
        }
    }

}