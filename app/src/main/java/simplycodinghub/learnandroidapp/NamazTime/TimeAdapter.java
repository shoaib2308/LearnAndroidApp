package simplycodinghub.learnandroidapp.NamazTime;

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

public class TimeAdapter extends RecyclerView.Adapter<TimeAdapter.Viewholder> {

    List<Item> timeListResponses = new ArrayList<>();
    Context context;

    public TimeAdapter(Context context,List<Item> timeListResponses) {
        this.timeListResponses = timeListResponses;
        this.context = context;
    }

    @NonNull
    @Override
    public TimeAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_layout,parent,false);
        return new TimeAdapter.Viewholder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull TimeAdapter.Viewholder holder, int position) {
        Item timeListResponse =  timeListResponses.get(position);
        holder.textView.setText(timeListResponse.getFajr());
        holder.textView2.setText(timeListResponse.getDhuhr());
    }

    @Override
    public int getItemCount() {
        return timeListResponses.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        TextView textView,textView2;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_text);
            textView2 = itemView.findViewById(R.id.tv_text2);
        }
    }
}
