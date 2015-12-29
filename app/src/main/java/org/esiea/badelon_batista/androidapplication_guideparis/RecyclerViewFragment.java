package org.esiea.badelon_batista.androidapplication_guideparis;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.florent37.materialviewpager.MaterialViewPagerHelper;
import com.github.florent37.materialviewpager.adapter.RecyclerViewMaterialAdapter;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    boolean test = false;
    ItemData itemsData[];
    public static RecyclerViewFragment newInstance() {
        return new RecyclerViewFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_recyclerview, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);

        //permet un affichage sous forme liste verticale
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setHasFixedSize(true);

        //100 faux contenu
     //   mContentItems = new ArrayList<>();

       // for (int i = 0; i < 2; ++i)
       //     mContentItems.add(new Object());
        boolean test=getBoolean();
        Log.d("Mytag","test"+test);
        if(test==false) {
            ItemData itemsData[] = {new ItemData("Help", R.drawable.earth),
                    new ItemData("Delete", R.drawable.light),
                    new ItemData("Cloud", R.drawable.tennis),
                    new ItemData("Favorite", R.drawable.ticket),
                    new ItemData("Like", R.drawable.ic_menu_arrond),
                    new ItemData("Rating", R.drawable.paris_android)};


            //penser à passer notre Adapter (ici : TestRecyclerViewAdapter) à un RecyclerViewMaterialAdapter
            mAdapter = new RecyclerViewMaterialAdapter(new TestRecyclerViewAdapter(itemsData));
            mRecyclerView.setAdapter(mAdapter);
        }


        //notifier le MaterialViewPager qu'on va utiliser une RecyclerView
        MaterialViewPagerHelper.registerRecyclerView(getActivity(), mRecyclerView, null);
    }

    public int ArraySize(){

        return itemsData.length;
    }

    public void setBoolean(boolean testt){
        this.test=testt;

    }
    public boolean getBoolean(){
        return test;
    }
}