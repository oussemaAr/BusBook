package dev.foursquad.busbook.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import dev.foursquad.busbook.R;
import dev.foursquad.busbook.model.Horraire;

public class HorraireAdapter extends RecyclerView.Adapter<HorraireAdapter.MyViewHolder> {

    List<Horraire> horraires;

    public HorraireAdapter(List<Horraire> horraires) {
        this.horraires = horraires;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.travel_item, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Horraire horraire = horraires.get(position);
        holder.heures_aller_depart.setText(horraire.allerDepart);
        holder.heures_aller_arriver.setText(horraire.allerArriver);
        holder.heures_retour_arriver.setText(horraire.retourArrive);
        holder.heures_retour_depart.setText(horraire.retourDepart);
    }

    @Override
    public int getItemCount() {
        return horraires.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView heures_aller_depart, heures_aller_arriver, heures_retour_arriver, heures_retour_depart;

        public MyViewHolder(View itemView) {
            super(itemView);
            heures_aller_depart = itemView.findViewById(R.id.heures_aller_depart);
            heures_aller_arriver = itemView.findViewById(R.id.heures_aller_arriver);
            heures_retour_arriver = itemView.findViewById(R.id.heures_retour_arriver);
            heures_retour_depart = itemView.findViewById(R.id.heures_retour_depart);
        }
    }
}
