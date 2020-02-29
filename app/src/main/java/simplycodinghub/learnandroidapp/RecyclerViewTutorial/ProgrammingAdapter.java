package simplycodinghub.learnandroidapp.RecyclerViewTutorial;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import simplycodinghub.learnandroidapp.R;

public class ProgrammingAdapter extends RecyclerView.Adapter<ProgrammingAdapter.ProgramViewHolder> {
    // extend Recycler.Adapter
    // create view holder program Recycler.ViewHolder
    // getItemCount = data.length
    // onCreateViewHolder = LayoutInflater and View view
    // onBindViewholder = take data in string and add in holder.tv_text.setText();
    private String[] data;

    public ProgrammingAdapter(String[] data) {
        this.data = data;
    }


    @NonNull
    @Override
    public ProgramViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflater = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_layout,parent,false);
        return new ProgramViewHolder(inflater);
    }

    @Override
    public void onBindViewHolder(@NonNull ProgramViewHolder holder, int position) {
        String title = data[position];
        holder.tv_text.setText(title);
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class ProgramViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView tv_text;

        public ProgramViewHolder(@NonNull View itemView) {
            super(itemView);
            img = (ImageView) itemView.findViewById(R.id.img);
            tv_text = (TextView) itemView.findViewById(R.id.tv_text);
        }
    }

}
