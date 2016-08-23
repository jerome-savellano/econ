package com.example.econ.Fragment;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.econ.Adapter.RVAdapter;
import com.example.econ.GlobalWarming;
import com.example.econ.Model.Lessons;
import com.example.econ.OverPopulation;
import com.example.econ.Pollution;
import com.example.econ.R;
import com.example.econ.ResourceDepletion;

import java.util.ArrayList;
import java.util.List;

import Utils.Strings;

/**
 * Created by jerome on 8/11/2016.
 */
public class Learn extends Fragment {

    private List<Lessons> lessons;
    private RecyclerView rv;

    public Learn(){
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_learn, container, false);

        rv = (RecyclerView) rootView.findViewById(R.id.rv);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(llm);
        rv.setHasFixedSize(true);

        initializeData();
        initializeAdapter();
        alertDialog();
        return rootView;
    }

    private void initializeData(){

        Intent intentPollution = new Intent(getActivity(), Pollution.class);
        Intent intentGlobalWarming = new Intent(getActivity(), GlobalWarming.class);
        Intent intentOverPopulation = new Intent(getActivity(), OverPopulation.class);
        Intent intentResourceDepletion = new Intent(getActivity(), ResourceDepletion.class);

        lessons = new ArrayList<>();
        lessons.add(new Lessons("Pollution", R.string.pollution, R.drawable.pollution, intentPollution));
        lessons.add(new Lessons("Resource depletion", R.string.resource_depletion, R.drawable.resdep, intentResourceDepletion));
        lessons.add(new Lessons("Global warming", R.string.global_warming, R.drawable.gb, intentGlobalWarming));

    }

    private void initializeAdapter(){
        RVAdapter adapter = new RVAdapter(lessons);
        rv.setAdapter(adapter);
    }

    private void  alertDialog(){
        new AlertDialog.Builder(getActivity())
                .setMessage(Strings.learn)
                .setPositiveButton("Got it!", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }

                })
                .show();
    }

}
