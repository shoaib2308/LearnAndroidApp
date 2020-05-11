package simplycodinghub.learnandroidapp.singulList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import simplycodinghub.learnandroidapp.R;

public class Adapter extends RecyclerView.Adapter<Adapter.Viewholder> {
    List<Datum> dataListResponse = new ArrayList<>();
    Context context;
    TextView textView, textView2, textView3;
    LinearLayout linearLayout;
    onClickInterface onClickInterface;
    public Adapter(Context context, List<Datum> dataListResponse,onClickInterface onClickInterface) {
        this.dataListResponse = dataListResponse;
        this.context = context;
        this.onClickInterface = onClickInterface;
    }

    @NonNull
    @Override
    public Adapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_layout2, parent, false);
        Viewholder vh = new Viewholder(v); // pass the view to View Holder
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder v, final int position) {
        final Datum dataListRes = dataListResponse.get(position);
        textView.setText("org- " + dataListRes.getOrg().getId());
        textView2.setText("prop- " + dataListRes.getProperty().getId());
        textView3.setText("room- " + dataListRes.getRoom().getId());
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickInterface.setClick(dataListRes.getOrg().getId());

            }
        });
    }


    @Override
    public int getItemCount() {
        return dataListResponse.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_text);
            textView2 = itemView.findViewById(R.id.tv_text2);
            textView3 = itemView.findViewById(R.id.tv_text3);
            linearLayout = itemView.findViewById(R.id.linearLayout);
        }
    }
}
