package slidingmenu.dreamfly.org.slidingmenu.custom.app;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by asus on 2015/10/9.
 */
public class MyViewPagerAdapter extends PagerAdapter {

        private List<View> mListViews;
        private List<String> mListTitle;

        public MyViewPagerAdapter(List<View> mListViews,List<String> mListTitle){
              this.mListViews=mListViews;
              this.mListTitle=mListTitle;
        }


        @Override
        public void destroyItem(ViewGroup container, int position, Object object){
                container.removeView(mListViews.get(position));
        }

        @Override
        public int  getCount(){
            return (this.mListViews.size());
        }


        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0==arg1;//官方提示这样写
        }


        @Override
        public Object instantiateItem(ViewGroup container, int position) {
               container.addView(mListViews.get(position));
               return (mListViews.get(position));
        }

        @Override
        public CharSequence getPageTitle(int pos){
              return(this.mListTitle.get(pos));
        }


}
