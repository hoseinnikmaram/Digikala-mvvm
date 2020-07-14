package com.example.digikalamvvm.view;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.databinding.DataBindingUtil;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.viewpager.widget.ViewPager;
import me.relex.circleindicator.CircleIndicator;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.digikalamvvm.PushNotification.ActivityShowNotification;
import com.example.digikalamvvm.model.CatModel;
import com.example.digikalamvvm.model.HomeModel;
import com.example.digikalamvvm.model.NotficationModel;
import com.example.digikalamvvm.model.TimerModel;
import com.example.digikalamvvm.R;
import com.example.digikalamvvm.Util.Adapter.Adapter_Recyclerview_category_home;
import com.example.digikalamvvm.Util.Adapter.Adapter_sandcount;
import com.example.digikalamvvm.Util.Custom_font.CustomTypefaceSpan;
import com.example.digikalamvvm.Util.SetupTimer;
import com.example.digikalamvvm.Util.Slider_config;
import com.example.digikalamvvm.view.custom.Custom_product;
import com.example.digikalamvvm.ViewModel.Viewmodel_Cat;
import com.example.digikalamvvm.ViewModel.Viewmodel_Home;
import com.example.digikalamvvm.ViewModel.Viewmodel_Timer;
import com.example.digikalamvvm.databinding.ActivityMainBinding;
import com.example.digikalamvvm.view.custom.Custom_product_offer;
import com.google.android.material.navigation.NavigationView;
import com.pnikosis.materialishprogress.ProgressWheel;

import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    ActivityMainBinding binding;
    Slider_config slider_config;
    Adapter_Recyclerview_category_home adapter_recyclerview_category_home;
    ProgressWheel progress_wheel;
    ViewPager viewpager;
    Toolbar toolbar;
    DrawerLayout drawer;
    NavigationView navigationView;
    RecyclerView recyclerview_category_home,recyclerview_span_count;
    TextView Tv_sec, Tv_min, Tv_hour;
    Adapter_sandcount adapter_sandcount;
    private Menu m;
    static Typeface iranianSansFont;
    HomeModel result_homeModel=null;
     MutableLiveData<HomeModel> mutableLiveData_home;
    MutableLiveData<Boolean> mutableLiveData_status_home;
    Custom_product custom_product,Custom_proruct_new;
    Custom_product_offer custom_product_offer;
    NotficationModel notficationModel =new NotficationModel();
;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        Cast();
        setSupportActionBar(toolbar);
      getSupportActionBar().setDisplayShowTitleEnabled(false);

        Set_Drawer();

        Set_Slider();

        Set_category();

        Set_Timer();

        Set_Spancount();
        Getlist_Custom_proruct_pourforsh();
        Getlist_Custom_proruct_offer();
         Getlist_Custom_proruct_new();

        if(getIntent().hasExtra("type")) {

            if(getIntent().getStringExtra("type").equals("activity")){

                Intent intent=new Intent(getApplicationContext(),ActivityShowNotification.class);


                intent.putExtra("title",getIntent().getStringExtra("title"));
                intent.putExtra("image",getIntent().getStringExtra("image"));
                intent.putExtra("content",getIntent().getStringExtra("content"));
                intent.putExtra("date",getIntent().getStringExtra("date"));
                startActivity(intent);
            }

            if(getIntent().getStringExtra("type").equals("url")){

                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse(getIntent().getStringExtra("destination")));

                startActivity(intent);
            }

        }

    }



    void Getlist_Custom_proruct_new()
    {

        mutableLiveData_status_home.observe(this,s->{
            if(!s){
                Toast.makeText(this, "سرور در دسترس نیست", Toast.LENGTH_SHORT).show();
            }

            else {

                mutableLiveData_home.observe(this, new Observer<HomeModel>() {
                    @Override
                    public void onChanged(HomeModel homeModel) {
Log.e("aa",homeModel.getProductNewModel().get(0).getName());
                        Custom_proruct_new.Getlistproduct();
                        Custom_proruct_new.getlist_product_new(homeModel.getProductNewModel());
                        Custom_proruct_new.Settitle("محصولات جدید");


                    }
                });
            }
        });




    }

    void Getlist_Custom_proruct_offer()
    {

        mutableLiveData_status_home.observe(this,s->{
            if(!s){
                Toast.makeText(this, "سرور در دسترس نیست", Toast.LENGTH_SHORT).show();
            }

            else {

                mutableLiveData_home.observe(this, new Observer<HomeModel>() {
                    @Override
                    public void onChanged(HomeModel homeModel) {

                        custom_product_offer.Getlistproduct();
                        custom_product_offer.getlist(homeModel.getProductOffer());


                    }
                });
            }
        });



    }


    private void Getlist_Custom_proruct_pourforsh()
    {



        mutableLiveData_status_home.observe(this,s->{
            if(!s){
                Toast.makeText(this, "سرور در دسترس نیست", Toast.LENGTH_SHORT).show();
            }

            else {

                mutableLiveData_home.observe(this, new Observer<HomeModel>() {
                    @Override
                    public void onChanged(HomeModel homeModel) {


                        custom_product.Getlistproduct();
                       custom_product.getlist(homeModel.getProductPourforshModels());
                        custom_product.Settitle("محصولات پروفروش");


                    }
                });
            }
        });

    }



    private void Set_Spancount() {


        mutableLiveData_status_home.observe(this,s->{
            if(!s){
                Toast.makeText(this, "سرور در دسترس نیست", Toast.LENGTH_SHORT).show();
            }

            else {

                mutableLiveData_home.observe(this, new Observer<HomeModel>() {
                    @Override
                    public void onChanged(HomeModel homeModel) {
                        final GridLayoutManager gridLayoutManager = new GridLayoutManager(MainActivity.this, 2);
                        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                            @Override
                            public int getSpanSize(int position) {

                                if (position==0){
                                    return 2;
                                }
                                else {return 1;}
                            }
                        });
                        recyclerview_span_count.setLayoutManager(gridLayoutManager);
                        adapter_sandcount = new Adapter_sandcount(MainActivity.this, homeModel.getSliderModel());
                        recyclerview_span_count.setAdapter(adapter_sandcount);
                    }
                });
            }
        });



    }


    private void Set_Timer() {
        Viewmodel_Timer viewmodel_timer = ViewModelProviders.of(this).get(Viewmodel_Timer.class);
        final MutableLiveData<TimerModel> mutableLiveData_timer = viewmodel_timer.Timer_Mutable();
        MutableLiveData<Boolean> mutableLiveData_status = viewmodel_timer.liveData_status;
        Log.e("eroree","0");

        mutableLiveData_status.observe(this,s->{
            if(!s){
                Toast.makeText(MainActivity.this, "سرور در دسترس نیست", Toast.LENGTH_SHORT).show();
                Log.e("eroree","1");

            }


            else {
                mutableLiveData_timer.observe(this, new Observer<TimerModel>() {
                    @Override
                    public void onChanged(TimerModel timerModel) {
                        Log.e("eroree","2");


                 SetupTimer.Getmethod_timer(MainActivity.this,Tv_sec,Tv_min,Tv_hour,timerModel.getTimer());




                    }
                });

            }

        });


    }

    private void Set_category() {
        Viewmodel_Cat viewmodel_cat = new ViewModelProvider(this).get(Viewmodel_Cat.class);
        final MutableLiveData<CatModel> mutableLiveData_cat = viewmodel_cat.Cat_Mutable();
        MutableLiveData<Boolean> mutableLiveData_status_cat = viewmodel_cat.liveData_status;

        mutableLiveData_status_cat.observe(this,s->{
            if(!s){
                Toast.makeText(this, "سرور در دسترس نیست", Toast.LENGTH_SHORT).show();
            }


            else {
                mutableLiveData_cat.observe(this, new Observer<CatModel>() {
                    @Override
                    public void onChanged(CatModel catModel) {
                        recyclerview_category_home.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.HORIZONTAL));
                        adapter_recyclerview_category_home=new Adapter_Recyclerview_category_home(MainActivity.this,catModel.getListCatModel());
                        recyclerview_category_home.setAdapter(adapter_recyclerview_category_home);


                    }
                });

            }

        });


    }

    private void Set_Drawer() {
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(MainActivity.this);
        m = navigationView.getMenu();
        for (int i = 0; i < m.size(); i++) {
            MenuItem mi = m.getItem(i);
            SubMenu subMenu = mi.getSubMenu();
            if (subMenu != null && subMenu.size() > 0) {
                for (int j = 0; j < subMenu.size(); j++) {
                    MenuItem subMenuItem = subMenu.getItem(j);
                    applyFontToMenuItem(subMenuItem);
                }
            }
            applyFontToMenuItem(mi);

        }
        FontGetment_headrviewitmes();
    }

    private void Set_Slider() {

        Viewmodel_Home viewmodel_home = new ViewModelProvider(this).get(Viewmodel_Home.class);
         mutableLiveData_home = viewmodel_home.List_Slider_Mutable();
         mutableLiveData_status_home = viewmodel_home.liveData_status;

        mutableLiveData_status_home.observe(this,s->{
            if(!s){
                Toast.makeText(this, "سرور در دسترس نیست", Toast.LENGTH_SHORT).show();
            }

            else {

                mutableLiveData_home.observe(this, new Observer<HomeModel>() {
                    @Override
                    public void onChanged(HomeModel homeModel) {
                        progress_wheel.setVisibility(View.GONE);
                        result_homeModel=homeModel;
                        slider_config = new Slider_config(MainActivity.this, MainActivity.this, viewpager, homeModel);
                        //Set_Spancount();

                    }
                });
            }
        });

    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);

        if(intent.hasExtra("type")) {

            if(intent.getStringExtra("type").equals("activity")) {

                Intent intent1 = new Intent(getApplicationContext(), ActivityShowNotification.class);


                intent1.putExtra("title", intent.getStringExtra("title"));
                intent1.putExtra("image", intent.getStringExtra("image"));
                intent1.putExtra("content", intent.getStringExtra("content"));
                intent1.putExtra("date", intent.getStringExtra("date"));
                startActivity(intent1);

            }

            if(intent.getStringExtra("type").equals("url")){

                Intent intent1=new Intent(Intent.ACTION_VIEW, Uri.parse(intent.getStringExtra("destination")));

                startActivity(intent1);
            }
        }

    }

    public void Cast() {
        progress_wheel = binding.contentMain.progressWheel;
        viewpager = binding.contentMain.viewpager;
        toolbar = binding.toolbar;
        drawer = binding.drawerLayout;
        navigationView = binding.navView;
        recyclerview_category_home=binding.contentMain.recyclerviewCategoryHome;
        Tv_hour=binding.contentMain.TvHour;
        Tv_min=binding.contentMain.TvMin;
        Tv_sec=binding.contentMain.TvSec;
        recyclerview_span_count=binding.contentMain.recyclerviewSpanCount;
        custom_product=binding.contentMain.CustomProructPourforsh;
        custom_product_offer=binding.contentMain.CustomProductOffer;
        Custom_proruct_new=binding.contentMain.CustomProructNew;
    }


    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        } else if (id == R.id.nav_about) {
            //   Intent intent=new Intent(getApplicationContext(),About_Digikala.class);
            //   startActivity(intent);
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    private void applyFontToMenuItem(MenuItem mi) {
        SpannableString mNewTitle = new SpannableString(mi.getTitle());
        mNewTitle.setSpan(new CustomTypefaceSpan(getApplicationContext(), "", getIranianSansFont(getApplicationContext())), 0, mNewTitle.length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        mi.setTitle(mNewTitle);
    }

    public static Typeface getIranianSansFont(Context context) {

        if (iranianSansFont == null) {
            iranianSansFont = Typeface.createFromAsset(context.getAssets(), "fonts/iranian_sans.ttf");
        }
        return iranianSansFont;
    }

    void FontGetment_headrviewitmes(){
        View view=navigationView.getHeaderView(0);
        TextView Tv_title_header=view.findViewById(R.id.textView);
        Tv_title_header.setTypeface(getIranianSansFont(getApplicationContext()));
    }

}



