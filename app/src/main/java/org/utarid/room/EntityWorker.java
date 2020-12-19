package org.utarid.room;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "worker")
public class EntityWorker {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String firstName;
    public String lastName;
    public String age;

    public EntityWorker(String firstName, String lastName, String age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
