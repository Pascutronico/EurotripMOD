package com.pascutron.eurotrip.country;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


import com.pascutron.eurotrip.atrac.AtracView;
import com.pascutron.eurotrip.comida.ComidaView;
import com.pascutron.eurotrip.hotel.HotelView;
import com.pascutron.eurotrip.viaje.ViajeView;


import pascutron.eurotrip.R;

/**
 * Created by spascual on 06/01/2015.
 */
public class CountryView extends Fragment{

    private static final String COUNTRY = "country";

    public static CountryView newInstance(int country){

        CountryView fragment = new CountryView();
        Bundle b = fragment.getArguments();
        if (b == null)
            b = new Bundle();

        b.putInt(COUNTRY, country);
        fragment.setArguments(b);

        return fragment;

    }


    public CountryView() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_country, container, false);

        //Crear y asignar boton1

        int i = getArguments().getInt(COUNTRY);

        Button button1 = (Button)rootView.findViewById(R.id.button_hoteles);
        onClickWithParameters(HotelView.newInstance(i), button1);

        //Crear y asignar boton2

        Button button2 = (Button)rootView.findViewById(R.id.button_viajes);
        onClickWithParameters(ViajeView.newInstance(i), button2);

        //Crear y asignar boton3

        Button button3 = (Button)rootView.findViewById(R.id.button_itinerario);
        onClickWithParameters(ComidaView.newInstance(i), button3);

        //Crear y asignar boton4

        Button button4 = (Button)rootView.findViewById(R.id.button_notas);
        onClickWithParameters(AtracView.newInstance(i), button4);

        return rootView;
    }

    private void onClickWithParameters(final Fragment f, Button b){

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, f).addToBackStack(null).commit();
            }
        });

    }

}
