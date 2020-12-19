package org.utarid.room;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

import org.utarid.room.databinding.ActivityMainBinding;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private DatabaseWorker databaseWorker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        databaseWorker = DatabaseWorker.getInstance(this);

        binding.btnInsertWorker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertWorker();
            }
        });

        binding.btnGetAllWorkers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getAllWorkers();
            }
        });
    }

    public void insertWorker() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                EntityWorker worker = new EntityWorker(binding.txtInsertWorkerName.getText().toString(), binding.txtInsertWorkerSurname.getText().toString(), binding.txtInsertWorkerAge.getText().toString());
                long newInsertedID = databaseWorker.daoWorker().insertWorker(worker);
                Snackbar snackbar = Snackbar.make(binding.mainLayout, "id : " + newInsertedID + " is added", Snackbar.LENGTH_LONG);
                snackbar.show();
            }
        }).start();
    }

    public void getAllWorkers() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                List<EntityWorker> workersList = databaseWorker.daoWorker().getAllWorkers();
            }
        }).start();

    }
}