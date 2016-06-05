package com.humoule.googleapi.model;

import java.util.List;

public class Prediction {

    private String description;
    private String id;
    private List<MatchedSubstring> matched_substrings;
    private String place_id;
    private String reference;
    private List<Term> terms;
    private List<String> types;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<MatchedSubstring> getMatchedSubStrings() {
        return matched_substrings;
    }

    public void setMatchedSubStrings(List<MatchedSubstring> matched_substrings) {
        this.matched_substrings = matched_substrings;
    }

    public String getPlaceId() {
        return place_id;
    }

    public void setPlaceId(String place_id) {
        this.place_id = place_id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public List<String> getTypes() {
        return types;
    }

    public void setTypes(List<String> types) {
        this.types = types;
    }

    public List<Term> getTerms() {
        return terms;
    }

    public void setTerms(List<Term> terms) {
        this.terms = terms;
    }
}
