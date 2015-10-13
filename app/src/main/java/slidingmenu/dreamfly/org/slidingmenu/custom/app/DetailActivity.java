package slidingmenu.dreamfly.org.slidingmenu.custom.app;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
import slidingmenu.dreamfly.org.slidingmenu.R;

/**
 * Created by asus on 2015/10/9.
 */
public class DetailActivity  extends Activity {

    private ViewPager viewPagerDetailActivityDetail;

    private List<String>  listDetailActivityDetailTitle;
    private List<View>   listDetailActivityDetialView;
    private PagerAdapter mPagerAdatper;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.detail_layout);
        this.init();
    }

    private void init(){
           this.initId();
           this.initData();
           this.mPagerAdatper=new MyViewPagerAdapter(this.listDetailActivityDetialView,this.listDetailActivityDetailTitle);
           this.viewPagerDetailActivityDetail.setAdapter(mPagerAdatper);
    }

    private void initId(){
          this.viewPagerDetailActivityDetail=(ViewPager)this.findViewById(R.id.viewpager_detail_viewdetials);
    }

    private  void initData(){
        this.listDetailActivityDetialView=new ArrayList<>();
        View pageFirstView= LayoutInflater.from(this).inflate(R.layout.pic1_layout,null);
        View pageSecondView=LayoutInflater.from(this).inflate(R.layout.pic2_layout,null);
        View pageThirdView=LayoutInflater.from(this).inflate(R.layout.pic3_layout,null);
        this.listDetailActivityDetialView.add(pageFirstView);
        this.listDetailActivityDetialView.add(pageSecondView);
        this.listDetailActivityDetialView.add(pageThirdView);
        this.listDetailActivityDetailTitle=new ArrayList<>();
        this.listDetailActivityDetailTitle.add("简介");
        this.listDetailActivityDetailTitle.add("评论");
        this.listDetailActivityDetailTitle.add("相关");
    }


}
