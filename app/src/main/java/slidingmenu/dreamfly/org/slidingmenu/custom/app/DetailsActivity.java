package slidingmenu.dreamfly.org.slidingmenu.custom.app;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import slidingmenu.dreamfly.org.slidingmenu.R;

/**
 * Created by asus on 2015/10/19.
 */
public class DetailsActivity extends FragmentActivity {

    private String DetailTitle[];
    private ViewPager mViewPager;
    private FragmentPagerAdapter mFragmentPagerAdapter;
    private TabFragment[] mTabFragment;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.detail_layout2);
        this.init();
    }

    private void init(){
         this.initViews();
         this.initDatas();
    }


    private void initViews(){
        this.mViewPager=(ViewPager)this.findViewById(R.id.viewpager_detail2_viewdetials);
    }

    private void initDatas(){
         this.DetailTitle=new String[]{"简介","评价","相关"};
         this.mTabFragment=new TabFragment[3];
         for(int index=0;index<3;index++){
               this.mTabFragment[index]=TabFragment.newInstatence(this.DetailTitle[index],index+1);
         }
         final int fragmentLength=this.DetailTitle.length;
         this.mFragmentPagerAdapter=new FragmentPagerAdapter(this.getSupportFragmentManager()) {
             @Override
             public Fragment getItem(int position) {
                 return(mTabFragment[position]);
             }

             @Override
             public int getCount() {
                 return (fragmentLength);
             }
         };
        this.mViewPager.setAdapter(mFragmentPagerAdapter);
        this.mViewPager.setCurrentItem(0);
    }
}
