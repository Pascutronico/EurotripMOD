package com.pascutron.eurotrip.comida;

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
public class ComidaView extends Fragment{

    private static final String COUNTRY = "country";

    public static ComidaView newInstance(int country){

        ComidaView fragment = new ComidaView();
        Bundle b = fragment.getArguments();
        if (b == null)
            b = new Bundle();

        b.putInt(COUNTRY, country);
        fragment.setArguments(b);

        return fragment;

    }

    public ComidaView(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_comida, container, false);
        TextView comida = (TextView) rootView.findViewById(R.id.comida);

        switch (getArguments().getInt(COUNTRY)){

            case Constants.MADRID:
                comida.setText(getResources().getString(R.string.comida_madrid));
                break;
            case Constants.BARCELONA:
                comida.setText(getResources().getString(R.string.comida_barce));
                break;
            case Constants.PARIS:
                comida.setText(getResources().getString(R.string.comida_paris));
                break;
            case Constants.LONDON:
                comida.setText(getResources().getString(R.string.comida_london));
                break;
        }

        return rootView;
    }


}
