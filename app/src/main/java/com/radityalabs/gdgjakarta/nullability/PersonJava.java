package com.radityalabs.gdgjakarta.nullability;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Objects;

public class PersonJava implements Parcelable {
    private String name;
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PersonJava)) return false;
        PersonJava that = (PersonJava) o;
        return Objects.equals(getName(), that.getName()) &&
                Objects.equals(getAddress(), that.getAddress());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAddress());
    }

    @Override
    public String toString() {
        return "PersonJava{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    protected PersonJava(Parcel in) {
        name = in.readString();
        address = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(address);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<PersonJava> CREATOR = new Creator<PersonJava>() {
        @Override
        public PersonJava createFromParcel(Parcel in) {
            return new PersonJava(in);
        }

        @Override
        public PersonJava[] newArray(int size) {
            return new PersonJava[size];
        }
    };
}
