package com.qoobico.remindme;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;


import com.qoobico.remindme.adapter.TabsFragmentAdapter;


public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;

    private static final int LAYOUT = R.layout.activiti_main;

    private DrawerLayout drawerLayout;

    private ViewPager viewPager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppDefault);
        super.onCreate(savedInstanceState);
        setContentView(LAYOUT);

        initToolbar();
        initNavigationView();
        initTabs();


        }

    private void initTabs() {
        viewPager=(ViewPager)findViewById(R.id.viewPager);

        //TabLayout  tabLayout=(TabLayout) findViewById(R.id.tabLayout);

        TabsFragmentAdapter adapter = new TabsFragmentAdapter(getApplicationContext(), getSupportFragmentManager());

        viewPager.setAdapter(adapter);
     //tabLayout.setupWithViewPager(viewPager);
    }

    private void initToolbar(){
            toolbar=(Toolbar)findViewById(R.id.toolbar);
            toolbar.setTitle(R.string.app_name); //наздвание
            toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() { //слушатель события для элементов которые выскакивают в меню
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    return false;
                }
            });
            toolbar.inflateMenu(R.menu.menu); //создаем менюшку и отсылаемся к файлу меню

        }

    private void initNavigationView() {
        drawerLayout= (DrawerLayout)findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,R.string.text_open,R.string.text_close);
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navView = (NavigationView) findViewById(R.id.navigation);
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                drawerLayout.closeDrawers();
                switch (item.getItemId()) {

                    case R.id.actionHistory: {
                        viewPager.setCurrentItem(0);
                        toolbar.setTitle(R.string.tab_item_soup);
                        break;
                    }
                    case R.id.actionIdea: {
                        viewPager.setCurrentItem(1);
                        toolbar.setTitle(R.string.tab_item_salad);
                        break;
                    }
                    case R.id.actionToDo: {
                        viewPager.setCurrentItem(2);
                        toolbar.setTitle(R.string.tab_item_casserole);
                        break;
                    }
                    case R.id.actionBirthday: {
                        viewPager.setCurrentItem(3);
                        toolbar.setTitle(R.string.tab_item_garnish);
                        break;
                    }
                }
                return true;
            }
        });

    }


 /*   private void initList() {

        ListView lvMain = (ListView) findViewById (R.id.lvMain);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, names);

        lvMain.setAdapter(adapter);


    }


       /*  private void showNotificationTab(){
          viewPager.setCurrentItem(Constants.TAB_ONE);
      }

      private void showTestTab(){
          viewPager.setCurrentItem(Constants.TAB_TWO);
      }*/
}
