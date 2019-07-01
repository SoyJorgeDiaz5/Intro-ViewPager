package com.co.soyjorgediaz5.introviewpager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class IntroActivity extends AppCompatActivity {

    private ViewPager screenViewPager;
    private IntroViewPagerAdapter introViewPagerAdapter;
    private TabLayout tabIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        tabIndicator = findViewById(R.id.tab_indicator);

        // Mock List items
        List<ScreenItem> itemList = new ArrayList<>();
        itemList.add(new ScreenItem("Cuentas rápidas", "Cálculos rápidos de tus finanzas", R.drawable.calculator));
        itemList.add(new ScreenItem("Estadísticas", "Controla el progreso de tu negocio", R.drawable.chart));
        itemList.add(new ScreenItem("Gestión de Clientes", "Agrega la información de tus clientes", R.drawable.human_suscess));

        //Setup ViewPager
        screenViewPager = findViewById(R.id.screen_viewpager);
        introViewPagerAdapter = new IntroViewPagerAdapter(this, itemList);
        screenViewPager.setAdapter(introViewPagerAdapter);

        // Setup TabLayout with ViewPager
        tabIndicator.setupWithViewPager(screenViewPager);

    }
}
