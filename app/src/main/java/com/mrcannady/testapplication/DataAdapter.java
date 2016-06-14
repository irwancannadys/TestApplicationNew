package com.mrcannady.testapplication;

import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mrcannady.testapplication.model.Model;

import java.util.ArrayList;

/**
 * Created by irwan on 6/14/16.
 */
public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder>{

    private ArrayList<Model> test;

    public DataAdapter(ArrayList<Model> test){
        this.test = test;
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
        holder.version = model;
    }

    @Override
    public int getItemCount() {
        return test.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView tv_name;
        private CardView cardView;
        public Model version;


        public ViewHolder(View itemView) {
            super(itemView);

            cardView = (CardView) itemView.findViewById(R.id.cardview);
            tv_name = (TextView) itemView.findViewById(R.id.tv_name);

//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    Intent intent = new Intent(view.getContext(), Main2Activity.class);
//                    intent.putExtra(MainActivity.VERSION, version.getApi());
//                    intent.putExtra(MainActivity.NAME, version.getName());
//                    view.getContext().startActivity(intent);
//                }
//            });

        }
    }
}


