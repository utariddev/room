package org.utarid.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface DaoWorker {
    @Query("SELECT * FROM worker")
    List<EntityWorker> getAllWorkers();

    @Query("SELECT * FROM worker WHERE id = :workerId")
    EntityWorker getWorkerById(int workerId);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long insertWorker(EntityWorker worker);

    @Delete
    void deleteWorker(EntityWorker worker);

    @Update
    void updateWorker(EntityWorker worker);
}
