package org.esiea.badelon_batista.androidapplication_guideparis;

import android.content.IntentFilter;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.github.florent37.materialviewpager.MaterialViewPagerHelper;
import com.github.florent37.materialviewpager.adapter.RecyclerViewMaterialAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class RecyclerViewFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    String UrlJSON;
    public static final String ARRINFO_UPDATE = "ARRINFO_UPDATE";




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

        //Création du contenue

        ArrondissementsActivity act= (ArrondissementsActivity)getActivity();
        UrlJSON=act.urlString; //On récupere le lien pour l'url de l'arrondissement (petit probleme lors de l'envoie)

        GetArrInfoServices.startActionArrInfo(getActivity(), UrlJSON); //On recupere le JSON en ligne et on le copie dans le cache
        IntentFilter intentFilter = new IntentFilter(ARRINFO_UPDATE);

        JSONArray test = getArrInfoFromFile(); //On recupere le json du cache

        if( UrlJSON!="null") { //S'il n'y a pas d'Url , il n'y a pas d'article
            try {
                ItemData[] itemsData = new ItemData[test.length()];
                for(int i=0;i<test.length();i++) {
                    JSONObject object = test.getJSONObject(i);
                    itemsData[i] = new ItemData(object.getString("title"), object.getString("image"),object.getString("best_thing_to_do")); //On recupere les données du JSON
                }


                mAdapter = new RecyclerViewMaterialAdapter(new RecyclerViewAdapter(getActivity(),itemsData));
                mRecyclerView.setAdapter(mAdapter);
            } catch (JSONException e) {

                e.printStackTrace();
            }
        }
        else {
                Toast.makeText(getActivity().getApplicationContext(), "Aucun article n'est disponible pour le département", Toast.LENGTH_LONG).show();
//Toast pour indiquer a l'utilisateur
            ItemData itemsData[] = {new ItemData("Aucun article", "http://cdn.grid.fotosearch.com/CSP/CSP339/k19967291.jpg","Aucun article")};
            mAdapter = new RecyclerViewMaterialAdapter(new RecyclerViewAdapter(getActivity(),itemsData));
            mRecyclerView.setAdapter(mAdapter);

        }



        MaterialViewPagerHelper.registerRecyclerView(getActivity(), mRecyclerView, null);
    }




    public JSONArray getArrInfoFromFile(){
        try {
            InputStream is = new FileInputStream(getActivity().getCacheDir() + "/" + "arr.json");
            byte[] buffer = new byte[is.available()];
            is.read(buffer);
            is.close();
            return new JSONArray(new String(buffer, "UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
            return new JSONArray();
        } catch (JSONException e) {
            e.printStackTrace();
            return new JSONArray();
        }
    }

}