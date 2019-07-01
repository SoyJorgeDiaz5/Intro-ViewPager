package com.co.soyjorgediaz5.introviewpager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class IntroActivity extends AppCompatActivity {

    private ViewPager screenViewPager;
    private IntroViewPagerAdapter introViewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        // Mock List items
        List<ScreenItem> itemList = new ArrayList<>();
        itemList.add(new ScreenItem("Cuentas rápidas", "Cálculos rápidos de tus finanzas", R.drawable.calculator));
        itemList.add(new ScreenItem("Estadísticas", "Controla el progreso de tu negocio", R.drawable.chart));
        itemList.add(new ScreenItem("Gestión de Clientes", "Agrega la información de tus clientes", R.drawable.human_suscess));

        //Setup ViewPager
        screenViewPager = findViewById(R.id.screen_viewpager);
        introViewPagerAdapter = new IntroViewPagerAdapter(this, itemList);
        screenViewPager.setAdapter(introViewPagerAdapter);

    }
}
