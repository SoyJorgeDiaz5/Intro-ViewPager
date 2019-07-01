package com.co.soyjorgediaz5.introviewpager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        initComponents();
        setMockData();
        setupViewPager();
        setBtnNextEvent();
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
            }
        });
    }
}
