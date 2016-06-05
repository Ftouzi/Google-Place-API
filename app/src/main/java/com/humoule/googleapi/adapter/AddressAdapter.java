package com.humoule.googleapi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.humoule.googleapi.R;
import com.humoule.googleapi.model.AddressComponent;
import com.humoule.googleapi.model.ResultAddress;

import java.util.List;

/**
 * Created by Farouk Touzi.
 */
public class AddressAdapter extends BaseAdapter {
    private Context context;
    private List<ResultAddress> resultAddressList;
    private LayoutInflater inflater;

    public AddressAdapter(Context context, List<ResultAddress> resultAddressList) {
        this.context = context;
        this.resultAddressList = resultAddressList;

        inflater = LayoutInflater.from(context);

    }

    @Override
    public int getCount() {
        return resultAddressList.size();
    }

    @Override
    public Object getItem(int position) {
        return resultAddressList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        DrawerItemHolder drawerHolder;
        View view = convertView;

        if (view == null) {
            // LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            drawerHolder = new DrawerItemHolder();

            view = inflater.inflate(R.layout.item_address, parent, false);
            drawerHolder.addressName = (TextView) view.findViewById(R.id.name_tv);
            drawerHolder.addressNumber = (TextView) view.findViewById(R.id.number_tv);
            drawerHolder.addressStreet = (TextView) view.findViewById(R.id.street_tv);
            drawerHolder.addressPostalCode = (TextView) view.findViewById(R.id.postal_code_tv);
            drawerHolder.addressTown = (TextView) view.findViewById(R.id.city_tv);
            drawerHolder.addressLatitude = (TextView) view.findViewById(R.id.latitude_tv);
            drawerHolder.addressLongitude = (TextView) view.findViewById(R.id.longitude_tv);

            view.setTag(drawerHolder);

        } else {
            drawerHolder = (DrawerItemHolder) view.getTag();
        }

        ResultAddress addressItem = (ResultAddress) this.resultAddressList.get(position);

        if (addressItem != null) {
            drawerHolder.addressName.setText(addressItem.getName());

            // Number, street and postal code
            for (AddressComponent addressComponent : addressItem.getAddressComponents()) {
                if (addressComponent.getTypes().size() > 0) {
                    if (addressComponent.getTypes().get(0).contains("street_number")) {
                        drawerHolder.addressNumber.setText(addressComponent.getShortName());
                    }
                    if (addressComponent.getTypes().get(0).contains("route")) {
                        drawerHolder.addressStreet.setText(addressComponent.getShortName());
                    }
                    if (addressComponent.getTypes().get(0).contains("postal_code")) {
                        drawerHolder.addressPostalCode.setText(addressComponent.getShortName());
                    }
                }
            }

            drawerHolder.addressTown.setText(addressItem.getVicinity());
            drawerHolder.addressLatitude.setText("" + addressItem.getGeometry().getLocation().getLat());
            drawerHolder.addressLongitude.setText("" + addressItem.getGeometry().getLocation().getLng());

        }

        return view;
    }

    private static class DrawerItemHolder {
        protected TextView addressName;
        protected TextView addressNumber;
        protected TextView addressStreet;
        protected TextView addressPostalCode;
        protected TextView addressTown;
        protected TextView addressLatitude;
        protected TextView addressLongitude;
    }

}
