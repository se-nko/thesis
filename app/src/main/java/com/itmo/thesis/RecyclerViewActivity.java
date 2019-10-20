package com.itmo.thesis;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;

import com.itmo.thesis.adapters.GlideAdapter;
import com.itmo.thesis.adapters.PicassoAdapter;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {

    private List<Image> imageList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        Bundle arguments = getIntent().getExtras();
        if (arguments != null) {
            Type library = (Type) arguments.get("lib");
            Format format = (Format) arguments.get("format");
            imageList = new ArrayList<>();
            imageList.add(new Image("https://cdn.britannica.com/67/197567-131-1645A26E/Scottish-fold-cat-feline.jpg", getString(R.string.png),"600*800"));
            RecyclerView recyclerView = findViewById(R.id.list);
            RecyclerView.LayoutManager layoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
            recyclerView.setLayoutManager(layoutManager);
            RecyclerView.Adapter adapter;
            if (library == Type.GLIDE)
                adapter = new GlideAdapter(this, imageList);
            else
                adapter = new PicassoAdapter(this, imageList);
            recyclerView.setAdapter(adapter);
        }
    }
}
