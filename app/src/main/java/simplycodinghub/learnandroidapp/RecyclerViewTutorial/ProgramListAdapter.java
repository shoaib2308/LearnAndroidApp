package simplycodinghub.learnandroidapp.RecyclerViewTutorial;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import simplycodinghub.learnandroidapp.R;

public class ProgramListAdapter extends RecyclerView.Adapter<ProgramListAdapter.ProgramViewHolder> {

   // private String[] data;
    public  List<GetListResponse> data = new ArrayList<>();
    public ProgramListAdapter(List<GetListResponse> getListResponses){
        this.data = getListResponses;
    }

    @NonNull
    @Override
    public ProgramViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View Inflater = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_layout,parent,false);
        return new ProgramViewHolder(Inflater);
    }

    @Override
    public void onBindViewHolder(@NonNull ProgramListAdapter.ProgramViewHolder holder, int position) {
        final GetListResponse getListResponse =  data.get(position);
          String title = getListResponse.getJobTitle();
          holder.tv_text.setText(title);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ProgramViewHolder extends RecyclerView.ViewHolder{
        TextView tv_text;
        public ProgramViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_text = (TextView) itemView.findViewById(R.id.tv_text);
        }
    }
}

