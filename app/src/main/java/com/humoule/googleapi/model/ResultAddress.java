package com.humoule.googleapi.model;

import java.util.List;

/**
 * Created by Farouk Touzi.
 */
public class ResultAddress {

    private List<AddressComponent> address_components;
    private String adr_address;
    private String formatted_address;
    private Geometry geometry;
    private String icon;
    private String id;
    private String name;
    private String place_id;
    private String reference;
    private String scope;
    private List<String> types;
    private String url;
    private String utc_offset;
    private String vicinity;

    public List<AddressComponent> getAddressComponents() {
        return address_components;
    }

    public void setAddressComponents(List<AddressComponent> address_components) {
        this.address_components = address_components;
    }

    public String getAdrAddress() {
        return adr_address;
    }

    public void setAdrAddress(String adr_address) {
        this.adr_address = adr_address;
    }

    public String getFormattedAddress() {
        return formatted_address;
    }

    public void setFormattedAddress(String formatted_address) {
        this.formatted_address = formatted_address;
    }

    public Geometry getGeometry() {
        return geometry;
    }

    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public List<String> getTypes() {
        return types;
    }

    public void setTypes(List<String> types) {
        this.types = types;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUtcOffset() {
        return utc_offset;
    }

    public void setUtcOffset(String utc_offset) {
        this.utc_offset = utc_offset;
    }

    public String getVicinity() {
        return vicinity;
    }

    public void setVicinity(String vicinity) {
        this.vicinity = vicinity;
    }
}
