package com.android.serialport.entity;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.File;

/**
 * @author F1ReKing
 * @date 2019/10/31 18:47
 * @Description
 */
public class Device implements Parcelable {

    private String name;
    private String root;
    private File file;

    public Device(String name, String root, File file) {
        this.name = name;
        this.root = root;
        this.file = file;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoot() {
        return root;
    }

    public void setRoot(String root) {
        this.root = root;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    @Override
    public int describeContents() { return 0; }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.root);
        dest.writeSerializable(this.file);
    }

    protected Device(Parcel in) {
        this.name = in.readString();
        this.root = in.readString();
        this.file = (File) in.readSerializable();
    }

    public static final Parcelable.Creator<Device> CREATOR = new Parcelable.Creator<Device>() {
        @Override
        public Device createFromParcel(Parcel source) {return new Device(source);}

        @Override
        public Device[] newArray(int size) {return new Device[size];}
    };
}