package com.anonymousx.infiniteautolist;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

public abstract class InfiniteAutoListAdapter extends RecyclerView.Adapter<InfiniteAutoListAdapter.Holder> {

    private Context context;
    private ArrayList data;
    public int position;
    private Boolean isCrop;

    public InfiniteAutoListAdapter(Context context, ArrayList arrayList, Boolean isCrop) {
        this.context = context;
        this.data=arrayList;
        position=arrayList.size();
        this.isCrop=isCrop;
    }
    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //View view=onCreateView(viewGroup, i);
        LayoutInflater layoutInflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(onSetView(),viewGroup,false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int i) {
        onBindView(holder,i%data.size());
    }

    @Override
    public int getItemCount() {
        return Integer.MAX_VALUE;
    }

    public class Holder extends RecyclerView.ViewHolder {

    public Holder(@NonNull View itemView) {
            super(itemView);
        }

    }

    public abstract int onSetView();

    public abstract void onBindView(Holder holder,int position);

}