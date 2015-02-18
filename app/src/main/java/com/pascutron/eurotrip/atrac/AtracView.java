package com.pascutron.eurotrip.atrac;

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
public class AtracView extends Fragment {

    private static final String COUNTRY = "country";

    public static AtracView newInstance(int country){

        AtracView fragment = new AtracView();
        Bundle b = fragment.getArguments();
        if (b == null)
            b = new Bundle();

        b.putInt(COUNTRY, country);
        fragment.setArguments(b);

        return fragment;

    }

    public AtracView(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_atrac, container, false);
        TextView atrac = (TextView) rootView.findViewById(R.id.atrac);

        switch (getArguments().getInt(COUNTRY)){

            case Constants.MADRID:
                atrac.setText(getResources().getString(R.string.atrac_madrid));
                break;
            case Constants.BARCELONA:
                atrac.setText(getResources().getString(R.string.atrac_barce));
                break;
            case Constants.PARIS:
                atrac.setText(getResources().getString(R.string.atrac_paris));
                break;
            case Constants.LONDON:
                atrac.setText(getResources().getString(R.string.atrac_london));
                break;
        }

        return rootView;
    }

}
