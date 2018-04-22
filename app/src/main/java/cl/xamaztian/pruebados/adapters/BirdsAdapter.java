package cl.xamaztian.pruebados.adapters;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import cl.xamaztian.pruebados.R;
import cl.xamaztian.pruebados.data.Queries;
import cl.xamaztian.pruebados.models.Bird;
import cl.xamaztian.pruebados.views.MainActivity;
import cl.xamaztian.pruebados.views.details.BirdDetailActivity;

/**
 * Created by Xamaztian on 19-04-2018.
 */

public class BirdsAdapter extends RecyclerView.Adapter<BirdsAdapter.ViewHolder> {
    private List<Bird> birds = Queries.toWatchList();
    private BirdClickListener listener;

    public BirdsAdapter(BirdClickListener listener) {
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_bird, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Bird bird = birds.get(position);
        holder.nameTv.setText(bird.getName());
        holder.scientificNameTv.setText(bird.getScientificName());
        holder.isWatchedCb.setChecked(bird.isWatched());
        holder.pricipalLl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int auxPos = holder.getAdapterPosition();
                Bird auxBird = birds.get(auxPos);
                listener.clickedBird(auxBird.getId());
            }
        });
        holder.isWatchedCb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                int auxPos = holder.getAdapterPosition();
                Bird auxBird = birds.get(auxPos);
                auxBird.setWatched(b);
                update(auxBird);
            }
        });
    }

    @Override
    public int getItemCount() {
        return birds.size();
    }

    public void update(Bird bird) {
        bird.save();
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        CheckBox isWatchedCb;
        TextView nameTv;
        TextView scientificNameTv;
        LinearLayout pricipalLl;

        public ViewHolder(View itemView) {
            super(itemView);

            pricipalLl = itemView.findViewById(R.id.principalLl);
            isWatchedCb = itemView.findViewById(R.id.isWatchedCheck);
            nameTv = itemView.findViewById(R.id.nameTv);
            scientificNameTv = itemView.findViewById(R.id.scientificNameTv);
        }
    }
}
