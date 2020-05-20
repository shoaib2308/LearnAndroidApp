package simplycodinghub.learnandroidapp.FullScreenPopUp;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Response;
import simplycodinghub.learnandroidapp.R;
import simplycodinghub.learnandroidapp.RecyclerViewTutorial.GetListResponse;
import simplycodinghub.learnandroidapp.RecyclerViewTutorial.ProgramListAdapter;
import simplycodinghub.learnandroidapp.RegisterRetrofit.ApiClient;
import simplycodinghub.learnandroidapp.RegisterRetrofit.IRestservice;

public class FullscreenDialog extends DialogFragment implements View.OnClickListener {

    IRestservice service;
    ProgramListAdapter adapter;
    List<GetListResponse> getListResponses = new ArrayList<>();

    private Callback callback;

    static FullscreenDialog newInstance() {
        return new FullscreenDialog();
    }

    public void setCallback(Callback callback) {
        this.callback = callback;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL, R.style.FullScreenDialogStyle);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fullscreen_dialog, container, false);
        ImageButton close = view.findViewById(R.id.fullscreen_dialog_close);
        TextView action = view.findViewById(R.id.fullscreen_dialog_action);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.programmableList);

        adapter = new ProgramListAdapter(getListResponses);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        getList();


        close.setOnClickListener(this);
        action.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        switch (id) {

            case R.id.fullscreen_dialog_close:
                dismiss();
                break;

            case R.id.fullscreen_dialog_action:
                callback.onActionClick("Whatever");
                 dismiss();
                break;

        }

    }

    public interface Callback {

        void onActionClick(String name);

    }


    public void getList() {
        service = ApiClient.getRetrofit().create(IRestservice.class);
        service.getJobList().enqueue(new retrofit2.Callback<List<GetListResponse>>() {
            @Override
            public void onResponse(Call<List<GetListResponse>> call, Response<List<GetListResponse>> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(getActivity(), "success", Toast.LENGTH_SHORT).show();
                    getListResponses.addAll(response.body());
                    adapter.notifyDataSetChanged();
                }
                else {
                    Toast.makeText(getActivity(), "Server returned an error", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<List<GetListResponse>> call, Throwable error) {
                Toast.makeText(getActivity(), "", Toast.LENGTH_SHORT).show();
                if (error instanceof IOException) {
                    Log.d("aaaa",""+error);
                    //inform the user and possibly retry
                    Toast.makeText(getActivity(), "this is an actual network failure "+error, Toast.LENGTH_SHORT).show();
                    // logging probably not necessary
                } else {
                    Toast.makeText(getActivity(), "conversion issues :("+error, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public void methodCallFromActivity(){
        Log.i("tag", "Method call directly from activity");
    }

}
