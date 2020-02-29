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

    public Adapter(Context context,List<GetListResponse> getListResponses) {
        this.getListResponses = getListResponses;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_layout,parent,false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {
        GetListResponse getListResponse =  getListResponses.get(position);
        holder.textView.setText(getListResponse.getJobId());
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
}
