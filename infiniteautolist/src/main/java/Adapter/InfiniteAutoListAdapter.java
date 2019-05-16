package Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public abstract class InfiniteAutoListAdapter extends RecyclerView.Adapter<InfiniteAutoListAdapter.Holder> {

    private Context context;
    private ArrayList<String> data;
    public int position;
    public int state;
    private Boolean isCrop;

    public InfiniteAutoListAdapter(Context context, ArrayList<String> arrayList, Boolean isCrop) {
        this.context = context;
        this.data=arrayList;
        position=arrayList.size();
        this.isCrop=isCrop;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=onCreateView(viewGroup, i);
     //  LayoutInflater layoutInflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
     //   View view=layoutInflater.inflate(R.layout.slides,viewGroup,false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int i) {
        onBindView(holder,i);
      //  Glide.with(context).load(data.get(i%position)).into(holder.iv);
    }

    @Override
    public int getItemCount() {
        return Integer.MAX_VALUE;
    }

    public class Holder extends RecyclerView.ViewHolder {
      //  ImageView iv;
        public Holder(@NonNull View itemView) {
            super(itemView);
            onHolderBind(itemView);
         //   iv=itemView.findViewById(R.id.iv_image);
        }
    }
    public abstract void onBindView(Holder holder,int position);
    public abstract View onCreateView(ViewGroup viewGroup,int i);
    public abstract void onHolderBind(View itemview);
}
