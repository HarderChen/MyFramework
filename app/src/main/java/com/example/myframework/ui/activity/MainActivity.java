package com.example.myframework.ui.activity;

import android.support.annotation.LayoutRes;
import android.support.annotation.StringRes;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.myframework.R;
import com.example.myframework.ui.fragment.PageFragment;

import java.util.ArrayList;
import java.util.List;

import es.dmoral.toasty.Toasty;
import rx.Observable;
import rx.functions.Action1;

public class MainActivity extends AppCompatActivity {
    private final String TAG="MainActivity";
//    TabLayout tabLayout;
//    ViewPager viewPager;
//    List<PageModel>pageModels=new ArrayList<>();
//
//    {
//        pageModels.add(new PageModel(R.layout.sample_color,R.string.title_draw_color, R.layout.practice_color));
//        pageModels.add(new PageModel(R.layout.sample_circle,R.string.title_draw_circle, R.layout.practice_circle));
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[]names={"1","2","3"};
        Observable.from(names)
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        Log.d(TAG,s);
                    }
                });
//
//        viewPager= findViewById(R.id.pager);
//        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
//
//            @Override
//            public Fragment getItem(int position) {
//                PageModel pageModel=pageModels.get(position);
//                return PageFragment.newInstance(pageModel.sampleLayoutRes,pageModel.practiceLayoutRes);
//            }
//
//            @Override
//            public int getCount() {
//                return pageModels.size();
//            }
//
//            @Override
//            public CharSequence getPageTitle(int position) {
//                return getString(pageModels.get(position).titleRes);
//            }
//        });
//
//        tabLayout=findViewById(R.id.tabLayout);
//        tabLayout.setupWithViewPager(viewPager);
    }

//    private class PageModel{
//        @LayoutRes int sampleLayoutRes;
//        @StringRes int titleRes;
//        @LayoutRes int practiceLayoutRes;
//
//        PageModel(@LayoutRes int sampleLayoutRes, @StringRes int titleRes, @LayoutRes int practiceLayoutRes) {
//            this.sampleLayoutRes = sampleLayoutRes;
//            this.titleRes = titleRes;
//            this.practiceLayoutRes = practiceLayoutRes;
//        }
//    }
}
