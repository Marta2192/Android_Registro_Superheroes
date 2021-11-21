package com.liceolapaz.dam.registrosuperhroes;

import android.os.Parcel;
import android.os.Parcelable;

public class Superheroe implements Parcelable {

    private String nome;
    private String alterEgo;
    private String bio;
    private float ratio;


    public Superheroe(String nome, String alterEgo, String bio, float ratio) {
        this.nome = nome;
        this.alterEgo = alterEgo;
        this.bio = bio;
        this.ratio = ratio;
    }

    protected Superheroe(Parcel in) {
        nome = in.readString();
        alterEgo = in.readString();
        bio = in.readString();
        ratio = in.readFloat();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nome);
        dest.writeString(alterEgo);
        dest.writeString(bio);
        dest.writeFloat(ratio);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Superheroe> CREATOR = new Creator<Superheroe>() {
        @Override
        public Superheroe createFromParcel(Parcel in) {
            return new Superheroe(in);
        }

        @Override
        public Superheroe[] newArray(int size) {
            return new Superheroe[size];
        }
    };

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAlterEgo() {
        return alterEgo;
    }

    public void setAlterEgo(String alterEgo) {
        this.alterEgo = alterEgo;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public float getRatio() {
        return ratio;
    }

    public void setRatio(float ratio) {
        this.ratio = ratio;
    }
}
