package com.ima.wispro.kisah25nabi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.ftinc.kit.adapter.BetterRecyclerAdapter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ima.wispro.kisah25nabi.model.NamaNabi;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.Bind;


public class MainActivity extends AppCompatActivity {

    @Bind(R.id.recycler)
    RecyclerView mRecycler;

    private NamaAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initRecycler();
    }

    /**
     * Intialize Recycler
     */
    private void initRecycler(){
        mAdapter = new NamaAdapter();
        mAdapter.addAll(getData());
        mRecycler.setAdapter(mAdapter);
        mRecycler.setLayoutManager(new LinearLayoutManager(this));
        mAdapter.setOnItemClickListener(new BetterRecyclerAdapter.OnItemClickListener<NamaNabi>() {
            @Override
            public void onItemClick(View view, NamaNabi namaNabi, int i) {
                // Launch the slidable activity
                Intent viewer = new Intent(MainActivity.this, ViewerActivity.class);
                viewer.putExtra(ViewerActivity.EXTRA_NAMA, namaNabi);
                startActivity(viewer);
            }
        });
    }

    private List<NamaNabi> getData(){
        InputStream is = getResources().openRawResource(R.raw.kisah25nabi);
        InputStreamReader isr = new InputStreamReader(is);
        Gson gson = new Gson();
        Type listType = new TypeToken<List<NamaNabi>>(){}.getType();
        List<NamaNabi> oss = gson.fromJson(isr, listType);
        return oss;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.about:
                Intent intent = new Intent(this,About.class);
                this.startActivity(intent);
                break;
        }

        return true;
    }
}
