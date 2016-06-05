package com.humoule.googleapi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.humoule.googleapi.adapter.AddressAdapter;
import com.humoule.googleapi.adapter.RestApiAdapter;
import com.humoule.googleapi.model.Prediction;
import com.humoule.googleapi.model.ResponseAddress;
import com.humoule.googleapi.model.ResponseDetail;
import com.humoule.googleapi.model.ResultAddress;
import com.humoule.googleapi.util.Constants;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements TextView.OnEditorActionListener {

    private final String TAG = MainActivity.class.getSimpleName();

    private ListView addressListView;
    private ProgressBar progressBar;
    private List<ResultAddress> resultAddressList;

    private int addressSize = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addressListView = (ListView) findViewById(R.id.address_list_view);
        progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        EditText addressEdit = (EditText) findViewById(R.id.address_et);
        addressEdit.setOnEditorActionListener(this);

        resultAddressList = new ArrayList<ResultAddress>();

    }

    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

        if (actionId == EditorInfo.IME_ACTION_SEARCH) {
            resultAddressList.clear();
            progressBar.setVisibility(View.VISIBLE);
            callGetListAddressWs(v.getText().toString());

            return false;
        }

        return false;
    }

    /**
     * Invoke Google API to get address
     *
     * @param address
     */
    private void callGetListAddressWs(String address) {

        Call<ResponseAddress> call = RestApiAdapter.getService().getListAddress(Constants.API_KEY, address);
        call.enqueue(new Callback<ResponseAddress>() {
            @Override
            public void onResponse(Call<ResponseAddress> call, Response<ResponseAddress> response) {
                Log.d(TAG, "onResponse");

                List<Prediction> predictionList = response.body().getPredictions();
                addressSize = predictionList.size();

                if (addressSize == 0) {
                    addressListView.setVisibility(View.GONE);
                    progressBar.setVisibility(View.GONE);
                    Toast.makeText(getApplicationContext(), "No result found", Toast.LENGTH_SHORT).show();
                }

                for (Prediction prediction : predictionList) {
                    getAddressDetails(prediction.getPlaceId());
                }

            }

            @Override
            public void onFailure(Call<ResponseAddress> call, Throwable t) {
                Log.e(TAG, "onFailure");
            }
        });

    }

    /**
     * Get detail for selected address
     *
     * @param placeId
     */
    private void getAddressDetails(String placeId) {
        Call<ResponseDetail> call = RestApiAdapter.getService().getDetailAddress(Constants.API_KEY, placeId);
        call.enqueue(new Callback<ResponseDetail>() {
            @Override
            public void onResponse(Call<ResponseDetail> call, Response<ResponseDetail> response) {
                Log.i(TAG, "onResponse");

                resultAddressList.add(response.body().getResult());

                if (resultAddressList.size() == addressSize) {
                    AddressAdapter addressAdapter = new AddressAdapter(getApplicationContext(), resultAddressList);
                    addressListView.setAdapter(addressAdapter);

                    progressBar.setVisibility(View.GONE);
                    addressListView.setVisibility(View.VISIBLE);
                }

            }

            @Override
            public void onFailure(Call<ResponseDetail> call, Throwable t) {
                Log.e(TAG, "onFailure");

            }
        });
    }
}
