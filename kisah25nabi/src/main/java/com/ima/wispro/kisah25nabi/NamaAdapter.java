package com.ima.wispro.kisah25nabi;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ftinc.kit.adapter.BetterRecyclerAdapter;
import com.ima.wispro.kisah25nabi.model.NamaNabi;

import butterknife.ButterKnife;
import butterknife.Bind;

/**
 * Created by r0adkll on 1/11/15.
 */
public class NamaAdapter extends BetterRecyclerAdapter<NamaNabi, NamaAdapter.NamaViewHolder> {

    @Override
    public NamaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_item, parent, false);
        return new NamaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NamaViewHolder viewHolder, int i) {
        super.onBindViewHolder(viewHolder, i);
        NamaNabi nama = getItem(i);
        viewHolder.title.setText(nama.name);
        //viewHolder.description.setText(nama.description);
    }

    public static class NamaViewHolder extends RecyclerView.ViewHolder{
        @Bind(R.id.title)         public TextView title;
        //@Bind(R.id.description)   public TextView description;

        public NamaViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
