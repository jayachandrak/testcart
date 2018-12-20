package com.example.nirosha.testcart;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        RecyclerView bestRecyclerView = (RecyclerView)findViewById(R.id.product_list);
        LinearLayoutManager mGrid = new LinearLayoutManager(CartActivity.this);
        mGrid.setOrientation(LinearLayoutManager.VERTICAL);
        bestRecyclerView.setLayoutManager(mGrid);

        ProductWarrantyAdapter mAdapter = new ProductWarrantyAdapter(CartActivity.this, getProductTestData());
        bestRecyclerView.setAdapter(mAdapter);
        mGrid.scrollToPosition(0);
    }

    private List<WarrantyObject> getProductTestData() {
        List<WarrantyObject> warrantyObjects = new ArrayList<WarrantyObject>();
        warrantyObjects.add(new WarrantyObject("3 years","129 SR" ));
        warrantyObjects.add(new WarrantyObject("3 years","129 SR" ));
        warrantyObjects.add(new WarrantyObject("3 years","129 SR" ));
        warrantyObjects.add(new WarrantyObject("3 years","129 SR" ));
        warrantyObjects.add(new WarrantyObject("3 years","129 SR" ));
        warrantyObjects.add(new WarrantyObject("3 years","129 SR" ));
        return warrantyObjects;
    }
}