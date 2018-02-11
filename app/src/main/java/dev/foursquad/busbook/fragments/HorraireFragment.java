package dev.foursquad.busbook.fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.List;

import dev.foursquad.busbook.R;
import dev.foursquad.busbook.Utils.MyDB;
import dev.foursquad.busbook.adapter.HorraireAdapter;
import dev.foursquad.busbook.model.Horraire;
import dev.foursquad.busbook.model.Ville;

/**
 * A simple {@link Fragment} subclass.
 */
public class HorraireFragment extends Fragment implements AdapterView.OnItemSelectedListener {


    private MyDB db;
    private Spinner spinnerVille;
    private HorraireAdapter recyclerAdapter;
    private RecyclerView recyclerView;

    public HorraireFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_horraire, container, false);
        spinnerVille = rootView.findViewById(R.id.villes);
        recyclerView = rootView.findViewById(R.id.recycler);
        db = new MyDB(getContext());
        ArrayAdapter<Ville> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_expandable_list_item_1, db.getVille());
        spinnerVille.setAdapter(adapter);
        spinnerVille.setOnItemSelectedListener(this);

        return rootView;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        List<Horraire> horraires = db.horraireList(((Ville) spinnerVille.getSelectedItem()).id);
        recyclerAdapter = new HorraireAdapter(horraires);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(recyclerAdapter);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
