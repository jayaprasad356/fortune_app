package com.app.fortuneappcompany.activities;


import static com.app.fortuneappcompany.helper.Constant.SUCCESS;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.app.fortuneappcompany.Adapter.RepayListAdapter;
import com.app.fortuneappcompany.R;
import com.app.fortuneappcompany.databinding.ActivityRepayListBinding;
import com.app.fortuneappcompany.helper.ApiConfig;
import com.app.fortuneappcompany.helper.Constant;
import com.app.fortuneappcompany.helper.Session;
import com.app.fortuneappcompany.model.RepayListModel;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RepayListActivity extends AppCompatActivity {

    private ActivityRepayListBinding binding;
    private RepayListAdapter adapter;
    Activity activity;
    Session session;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityRepayListBinding.inflate(getLayoutInflater());
        activity=RepayListActivity.this;
        session=new Session(activity);

        binding.imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        binding.recycler.setLayoutManager(new LinearLayoutManager(this));
        showWithdrawals();
        setContentView(binding.getRoot());
    }


    private void showWithdrawals()
    {
        Map<String, String> params = new HashMap<>();
        params.put(Constant.USER_ID,session.getData(Constant.USER_ID));
        ApiConfig.RequestToVolley((result, response) -> {
            if (result) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    if (jsonObject.getBoolean(SUCCESS)) {
                        JSONArray jsonArray = jsonObject.getJSONArray(Constant.DATA);
                        ArrayList<RepayListModel> repayListModels = new ArrayList<>();
                        Gson g = new Gson();
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                            if (jsonObject1 != null) {
                                RepayListModel group = g.fromJson(jsonObject1.toString(), RepayListModel.class);
                                repayListModels.add(group);
                            } else {
                                break;
                            }
                        }
                        adapter = new RepayListAdapter(repayListModels);
                        binding.recycler.setAdapter(adapter);

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, activity, Constant.MY_REPAYMENT_LIST_URL, params, true);


    }
}