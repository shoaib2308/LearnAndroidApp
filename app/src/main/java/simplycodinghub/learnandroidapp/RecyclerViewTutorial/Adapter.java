package simplycodinghub.learnandroidapp.RecyclerViewTutorial;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import simplycodinghub.learnandroidapp.R;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    List<GetListResponse> getListResponses = new ArrayList<>();
    Context context;
    onClickListener onClickListener;

    public Adapter(onClickListener onClickListener,List<GetListResponse> getListResponses) {
        this.getListResponses = getListResponses;
        this.onClickListener = onClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_layout,parent,false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, final int position) {
        final GetListResponse getListResponse =  getListResponses.get(position);
        holder.textView.setText(getListResponse.getJobId());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickListener.setOnClickListener(getListResponse.getJobId());
            }
        });
    }

    @Override
    public int getItemCount() {
        return getListResponses.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_text);
        }
    }

    public interface onClickListener{
        void setOnClickListener(String userId);
    }

}
