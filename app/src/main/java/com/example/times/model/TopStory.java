package com.example.times.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Karishma on 13/4/18.
 */

@Entity
public class TopStory {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String section;
    private String subsection;
    private String title;
    @SerializedName("abstract")
    private String abst;
    private String url;

    @SerializedName("multimedia")
    private ArrayList<Multimedia> multimediaList;

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getSubsection() {
        return subsection;
    }

    public void setSubsection(String subsection) {
        this.subsection = subsection;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAbst() {
        return abst;
    }

    public void setAbst(String abst) {
        this.abst = abst;
    }

    public ArrayList<Multimedia> getMultimediaList() {
        return multimediaList;
    }

    public void setMultimediaList(ArrayList<Multimedia> multimediaList) {
        this.multimediaList = multimediaList;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
