package com.mrcannady.testapplication;

import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.mrcannady.testapplication.model.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by irwan on 6/14/16.
 */
public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder>{

    private static final String TAG = DataAdapter.class.getSimpleName() ;

    private List<Model> test;
    private TitleClickListener clickListener;

    public DataAdapter(TitleClickListener click){
        test = new ArrayList<>();
        clickListener = click;
    }



    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_item, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final DataAdapter.ViewHolder holder, final int position) {

        Model model = test.get(position);

        holder.tv_name.setText(test.get(position).getTitle());
        holder.models = model;

    }

    @Override
    public int getItemCount() {
        return test.size();
    }

    public void addModel(Model model){
        Log.d(TAG, model.getTitle());
        test.add(model);
        notifyDataSetChanged();
    }

    public Model getSelected(int position) {
        return test.get(position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView tv_name;
        private CardView cardView;
        public Model models;


        public ViewHolder(View itemView) {
            super(itemView);

            cardView = (CardView) itemView.findViewById(R.id.cardview);
            tv_name = (TextView) itemView.findViewById(R.id.tv_title);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                   // Toast.makeText(view.getContext(),"test" + getAdapterPosition(),Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(view.getContext(), Detail.class);
                    intent.putExtra(TitleActivity.BODY, models.getBody());
                    view.getContext().startActivity(intent);
                }
            });

        }

        @Override
        public void onClick(View view) {
            clickListener.onClick(getLayoutPosition());
        }
    }

    public interface TitleClickListener{
        void onClick(int position);
    }
}


