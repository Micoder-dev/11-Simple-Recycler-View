package com.example.simplerecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Handler;

import com.todkars.shimmer.ShimmerRecyclerView;

public class MainActivity extends AppCompatActivity {

    private ShimmerRecyclerView categoryRecyclerView;

    private Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        categoryRecyclerView = findViewById(R.id.categoryRecyclerView);

        categoryRecyclerView.setAdapter(new CategoryRecyclerViewAdapter());
        categoryRecyclerView.setLayoutManager(new LinearLayoutManager(this));


        categoryRecyclerView.showShimmer();     // to start showing shimmer

        // To stimulate long running work using android.os.Handler
        mHandler = new Handler();
        mHandler.postDelayed((Runnable) () -> {
            categoryRecyclerView.hideShimmer(); // to hide shimmer
        }, 3000);

    }
}