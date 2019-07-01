package com.co.soyjorgediaz5.introviewpager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class IntroActivity extends AppCompatActivity {

    private ViewPager screenViewPager;
    private TabLayout tabIndicator;
    private Button btnNext;
    private int indicatorPosition;
    private List<ScreenItem> itemList;
    private Button btnGetStarted;
    private Animation animGetStarted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        initComponents();
        setMockData();
        setupViewPager();
        setBtnNextEvent();
        setTabIndicatorListener();
        setBtnGetStarted();
    }

    private void setupViewPager() {
        //Setup ViewPager
        screenViewPager = findViewById(R.id.screen_viewpager);
        IntroViewPagerAdapter introViewPagerAdapter = new IntroViewPagerAdapter(this, itemList);
        screenViewPager.setAdapter(introViewPagerAdapter);
        // Setup TabLayout with ViewPager
        tabIndicator.setupWithViewPager(screenViewPager);
    }

    private void setMockData() {
        itemList = new ArrayList<>();
        itemList.add(new ScreenItem("Cuentas rápidas", "Cálculos rápidos de tus finanzas", R.drawable.calculator));
        itemList.add(new ScreenItem("Estadísticas", "Controla el progreso de tu negocio", R.drawable.chart));
        itemList.add(new ScreenItem("Gestión de Clientes", "Agrega la información de tus clientes", R.drawable.human_suscess));
    }

    private void initComponents() {
        tabIndicator = findViewById(R.id.tab_indicator);
        btnNext = findViewById(R.id.btn_next);
        btnGetStarted = findViewById(R.id.btn_get_started);
        animGetStarted = AnimationUtils.loadAnimation(btnGetStarted.getContext(), R.anim.button_getstarted_anim);
    }

    private void setBtnNextEvent(){
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                indicatorPosition = screenViewPager.getCurrentItem();
                if (indicatorPosition < itemList.size()) {
                    indicatorPosition++;
                    screenViewPager.setCurrentItem(indicatorPosition);
                }

                // The last screen of ViewPager
                if (indicatorPosition == itemList.size()-1){
                    loadLastScreen();
                }
            }
        });
    }

    private void setBtnGetStarted(){
        btnGetStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(btnGetStarted.getContext(), HomeActivity.class));
            }
        });
    }

    private void loadLastScreen() {
        btnNext.setVisibility(View.GONE);
        tabIndicator.setVisibility(View.INVISIBLE);
        btnGetStarted.setVisibility(View.VISIBLE);
        btnGetStarted.setAnimation(animGetStarted);
    }

    private void setTabIndicatorListener(){
        tabIndicator.addOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition() == itemList.size()-1) {
                    loadLastScreen();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
