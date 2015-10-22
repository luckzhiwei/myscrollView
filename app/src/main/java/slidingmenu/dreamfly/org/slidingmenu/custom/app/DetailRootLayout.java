package slidingmenu.dreamfly.org.slidingmenu.custom.app;

import android.content.Context;
import android.support.v4.view.VelocityTrackerCompat;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Scroller;

import slidingmenu.dreamfly.org.slidingmenu.R;

/**
 * Created by asus on 2015/10/20.
 */
public class DetailRootLayout  extends LinearLayout {


        private RelativeLayout relLayoutDetialLayoutDetial;
        private ViewPager    viewPagerDetail2ShowDetial;

        private Scroller mScroller;

        private int mTocuhlop;
        private int mMaximumVelocity, mMinimumVelocity;

        private boolean isDragging;

        private VelocityTracker mVelocityTracker;

        private float lastY;

        public  DetailRootLayout(Context context, AttributeSet attrs){
               super(context,attrs);
               this.isDragging=false;
               this.mTocuhlop= ViewConfiguration.get(context).getScaledDoubleTapSlop();
               this.mVelocityTracker=VelocityTracker.obtain();
               this.mMaximumVelocity=ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
               this.mMinimumVelocity=ViewConfiguration.get(context).getScaledMaximumFlingVelocity();

        }

        @Override
        protected void onFinishInflate(){
              super.onFinishInflate();
              this.relLayoutDetialLayoutDetial=(RelativeLayout)this.findViewById(R.id.relayout_detail2_showdetail);
              this.viewPagerDetail2ShowDetial=(ViewPager)this.findViewById(R.id.viewpager_detail2_viewdetials);
        }

        @Override
        public boolean onTouchEvent(MotionEvent event){

            switch (event.getAction()){
                case MotionEvent.ACTION_DOWN:
                  lastY=event.getRawY();
                  break;
                case MotionEvent.ACTION_MOVE:
                   float distanceY=lastY-event.getRawY();
                   if(!isDragging && Math.abs(distanceY)>mTocuhlop){
                       isDragging=true;
                   }
                   if(isDragging){
                        scrollTo(0,(int)(distanceY));
                        lastY=event.getRawY();
                   }
                   break;
                case MotionEvent.ACTION_UP:
                    isDragging=false;
                    break;
            }
            return (super.onTouchEvent(event));
        }
}
