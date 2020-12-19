package org.utarid.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = EntityWorker.class, version = 1)
public abstract class DatabaseWorker extends RoomDatabase {
    private static final String DB_NAME = "worker.db";
    private static DatabaseWorker instance;

    public static synchronized DatabaseWorker getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), DatabaseWorker.class, DB_NAME)
                    .build();
        }
        return instance;
    }

    public abstract DaoWorker daoWorker();


}
