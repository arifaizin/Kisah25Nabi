package com.ima.wispro.kisah25nabi;

import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ftinc.kit.util.Utils;
import com.ftinc.kit.widget.AspectRatioImageView;
//import com.google.android.gms.appindexing.Action;
//import com.google.android.gms.appindexing.AppIndex;
//import com.google.android.gms.common.api.GoogleApiClient;
import com.ima.wispro.Slidr;
import com.ima.wispro.kisah25nabi.model.NamaNabi;
import com.ima.wispro.model.SlidrConfig;
import com.ima.wispro.model.SlidrPosition;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by r0adkll on 1/11/15.
 */
public class ViewerActivity extends AppCompatActivity {

    public static final String EXTRA_NAMA = "extra_os_version";

    @Bind(R.id.toolbar)
    Toolbar mToolbar;
    @Bind(R.id.cover)
    AspectRatioImageView mCover;
    @Bind(R.id.title)
    TextView mTitle;
    @Bind(R.id.description)
    TextView mDescription;
    @Bind(R.id.date)
    TextView mDate;
    @Bind(R.id.version)
    TextView mVersion;
    @Bind(R.id.sdk)
    TextView mSdk;
    //@Bind(R.id.position)
    //TextView mPosition;

    private NamaNabi mNAMA;
    private SlidrConfig mConfig;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
//    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewer);
        ButterKnife.bind(this);

        // Get the status bar colors to interpolate between
        int primary = getResources().getColor(R.color.primaryDark);
        int secondary = getResources().getColor(R.color.red_500);

        // Build the slidr config
        //int numPositions = SlidrPosition.values().length;
        //SlidrPosition position = SlidrPosition.values()[Utils.getRandom().nextInt(numPositions)];
        //mPosition.setText(position.name());

        mConfig = new SlidrConfig.Builder()
                .primaryColor(primary)
                .secondaryColor(secondary)
                .position(SlidrPosition.HORIZONTAL)
                .velocityThreshold(2400)
                .distanceThreshold(.25f)
                .edge(true)
                .touchSize(Utils.dpToPx(this, 32))
                .build();

        // Attach the Slidr Mechanism to this activity
        Slidr.attach(this, mConfig);

        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mNAMA = getIntent().getParcelableExtra(EXTRA_NAMA);
        if (savedInstanceState != null) mNAMA = savedInstanceState.getParcelable(EXTRA_NAMA);

        // Set layout contents
        mTitle.setText(mNAMA.name);
        mDescription.setText(mNAMA.description);
        mDate.setText(String.valueOf(mNAMA.year));
        mVersion.setText(String.valueOf(mNAMA.version));
        mSdk.setText(String.valueOf(mNAMA.sdk_int));

        // Load header image
        Glide.with(this)
                .load(mNAMA.image_url)
                .crossFade()
                .into(mCover);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        //client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    //@OnClick({R.id.color1, R.id.color2, R.id.color3, R.id.color4, R.id.color5})
    void onColorClicked(View v) {
        int color = ((ColorDrawable) v.getBackground()).getColor();
        getWindow().setStatusBarColor(color);
        mConfig.setColorSecondary(color);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(EXTRA_NAMA, mNAMA);
    }


}
