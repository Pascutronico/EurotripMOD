package com.pascutron.eurotrip.viaje;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pascutron.eurotrip.utils.Constants;

import pascutron.eurotrip.R;

/**
 * Created by spascual on 07/01/2015.
 */
public class ViajeView extends Fragment{

    private static final String COUNTRY = "country";

    public static ViajeView newInstance(int country){

        ViajeView fragment = new ViajeView();
        Bundle b = fragment.getArguments();
        if (b == null)
            b = new Bundle();

        b.putInt(COUNTRY, country);
        fragment.setArguments(b);

        return fragment;

    }

    public ViajeView(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_viaje, container, false);
        TextView viaje = (TextView) rootView.findViewById(R.id.viaje);

        switch (getArguments().getInt(COUNTRY)){

            case Constants.MADRID:
                viaje.setText(getResources().getString(R.string.viaje_madrid));
                break;
            case Constants.BARCELONA:
                viaje.setText(getResources().getString(R.string.viaje_barce));
                break;
            case Constants.PARIS:
                viaje.setText(getResources().getString(R.string.viaje_paris));
                break;
            case Constants.LONDON:
                viaje.setText(getResources().getString(R.string.viaje_london));
                break;
        }

        return rootView;
    }



}
