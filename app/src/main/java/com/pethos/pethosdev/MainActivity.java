package com.pethos.pethosdev;

import android.content.Context;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.view.View;
import android.widget.SearchView.OnQueryTextListener;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;


public class MainActivity extends AppCompatActivity {


    SearchView search;
    ViewPager viewPager;
    LinearLayout sliderDotspanel;
    private int dotscount;
    private ImageView[] dots;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RvAdapter adapter;
    ArrayList<KategoriClass> kategoriArray = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //logo
        ImageView logo = (ImageView) findViewById(R.id.logo_pet_hos);
        logo.setImageResource(R.drawable.logo_merah);

        //search
        CardView cv = (CardView) findViewById(R.id.cv_search);
        cv.setBackgroundResource(R.drawable.gradient_background_card_search);
        search=(SearchView) findViewById(R.id.searchView1);
        search.setQueryHint("Cari Produk atau Toko");
        search.setIconified(false);


        search.setOnQueryTextFocusChangeListener(new SearchView.OnFocusChangeListener()
        {

            @Override
            public void onFocusChange(View v, boolean hasFocus) {

            }
        });

        search.setOnQueryTextListener(new OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        //images slider
        viewPager = (ViewPager) findViewById(R.id.pager);
        sliderDotspanel = (LinearLayout) findViewById(R.id.sliderDots);
        SlidingAd_Adapter slidingAd_adapter = new SlidingAd_Adapter(this);
        viewPager.setAdapter(slidingAd_adapter);

        //dot indicators
        dotscount = slidingAd_adapter.getCount();
        dots = new ImageView[dotscount];

        for(int i=0; i<dotscount; i++){
            dots[i] = new ImageView(this);
            dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.non_active_dot));
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(5,15,5,25);
            sliderDotspanel.addView(dots[i],params);
        }

        dots[0].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dot));
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                for (int i =0; i<dotscount;i++){
                    dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.non_active_dot));
                }

                dots[position].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dot));
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        //cardview kategori
        initDataKategori();
        recyclerView = (RecyclerView) findViewById(R.id.rv);
        layoutManager = new GridLayoutManager(getApplicationContext(),3);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new RvAdapter(kategoriArray);
        recyclerView.setAdapter(adapter);
    }

    private void initDataKategori(){
        kategoriArray.add(new KategoriClass(1,"Best Seller", R.drawable.best_seller));
        kategoriArray.add(new KategoriClass(2,"Near Me", R.drawable.near_me));
        kategoriArray.add(new KategoriClass(3,"Promotion", R.drawable.promotion));
        kategoriArray.add(new KategoriClass(3,"Dog Food", R.drawable.dog_food));
        kategoriArray.add(new KategoriClass(3,"Cat Food", R.drawable.cat_food));
        kategoriArray.add(new KategoriClass(3,"Accessories", R.drawable.accessories));
        kategoriArray.add(new KategoriClass(3,"Health", R.drawable.health));
        kategoriArray.add(new KategoriClass(3,"Grooming", R.drawable.grooming_tools));
        kategoriArray.add(new KategoriClass(3,"Tools", R.drawable.tools));
    }
}
