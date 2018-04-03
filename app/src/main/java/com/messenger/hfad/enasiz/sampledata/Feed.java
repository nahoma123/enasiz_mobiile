package com.messenger.hfad.enasiz.sampledata;

        import com.google.gson.annotations.Expose;
        import com.google.gson.annotations.SerializedName;

        import java.util.List;

/**
 * Created by Nahom on 2018-03-31.
 */

public class Feed {

    @SerializedName("category")
    @Expose
    private String heading;

    @SerializedName("shit")
    @Expose
    private String shit;


    @SerializedName("data")
    @Expose
    private List<Info> infoList;

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public List<Info> getInfoList() {
        return infoList;
    }

    public void setInfoList(List<Info> infoList) {
        this.infoList = infoList;
    }

    public String getShit() {
        return shit;
    }

    public void setShit(String shit) {
        this.shit = shit;
    }

}