package org.utarid.room;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterWorker extends RecyclerView.Adapter<AdapterWorker.WorkerViewHolder> {

    private Context context;
    private List<EntityWorker> workersList;

    public AdapterWorker(Context context, List<EntityWorker> workersList) {
        this.context = context;
        this.workersList = workersList;
    }

    @NonNull
    @Override
    public WorkerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.worker_list_row, parent, false);
        return new WorkerViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull WorkerViewHolder holder, int position) {
        EntityWorker worker = workersList.get(position);
        holder.tv_name_surname.setText(worker.getFirstName() + " " + worker.getLastName());
        holder.tv_id.setText(String.valueOf(worker.getId()));
        holder.tv_age.setText(worker.getAge());
    }

    @Override
    public int getItemCount() {
        return workersList.size();
    }

    public class WorkerViewHolder extends RecyclerView.ViewHolder {

        public TextView tv_id;
        public TextView tv_name_surname;
        public TextView tv_age;

        public WorkerViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_age = itemView.findViewById(R.id.tv_age);
            tv_name_surname = itemView.findViewById(R.id.tv_name_surname);
            tv_id = itemView.findViewById(R.id.tv_id);
        }
    }
}
