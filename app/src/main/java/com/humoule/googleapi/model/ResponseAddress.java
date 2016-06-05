package com.humoule.googleapi.model;

import java.util.List;

/**
 * Created by Farouk Touzi.
 */
public class ResponseAddress {

    private List<Prediction> predictions;
    private String status;

    public List<Prediction> getPredictions() {
        return predictions;
    }

    public void setPredictions(List<Prediction> predictions) {
        this.predictions = predictions;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
