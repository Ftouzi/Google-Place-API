package com.humoule.googleapi.model;

import java.util.List;

/**
 * Created by Farouk Touzi.
 */
public class ResponseDetail {

    private List<String> html_attributions;
    private ResultAddress result;
    private String status;

    public List<String> getHtmlAttributions() {
        return html_attributions;
    }

    public void setHtmlAttributions(List<String> html_attributions) {
        this.html_attributions = html_attributions;
    }

    public ResultAddress getResult() {
        return result;
    }

    public void setResult(ResultAddress result) {
        this.result = result;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
