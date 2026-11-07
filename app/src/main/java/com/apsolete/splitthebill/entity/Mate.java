package com.apsolete.splitthebill.entity;

//import android.os.Parcel;
//import android.os.Parcelable;

//import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "mates")
public class Mate /*implements Parcelable*/ {
    @PrimaryKey(autoGenerate = true)
    public long id;
    public String name;

    /*public Mate() {}

    protected Mate(Parcel in) {
        id = in.readLong();
        name = in.readString();
    }

    public static final Creator<Mate> CREATOR = new Creator<Mate>() {
        @Override
        public Mate createFromParcel(Parcel in) {
            return new Mate(in);
        }

        @Override
        public Mate[] newArray(int size) {
            return new Mate[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeLong(id);
        parcel.writeString(name);
    }*/
}
