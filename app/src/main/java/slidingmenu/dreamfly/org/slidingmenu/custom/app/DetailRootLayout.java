package slidingmenu.dreamfly.org.slidingmenu.custom.app;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.VelocityTrackerCompat;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.BounceInterpolator;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.OverScroller;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Scroller;

import slidingmenu.dreamfly.org.slidingmenu.R;

/**
 * Created by asus on 2015/10/20.
 */
public class DetailRootLayout  extends LinearLayout {

    private View mTop;
    private View mSimpleIncator;
    private ViewPager mViewPager;
    private View mFragmentInnerView;

    private int mTopViewHeight;
    private ViewGroup mInnerScrollView;
    private boolean isTopHidden;

    private OverScroller mScroller;
    private VelocityTracker mVelocityTracker;
    private int mTouchSlop;
    private int mMaximumVelocity, mMinimumVelocity;

    private float mLastY;
    private boolean isDragging;

    public DetailRootLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        setOrientation(LinearLayout.VERTICAL);
        this.mVelocityTracker=VelocityTracker.obtain();
        this.mScroller=new OverScroller(context);
        this.isDragging=false;
        this.isTopHidden=false;
        this.mTouchSlop=ViewConfiguration.get(context).getScaledTouchSlop();
        this.mMaximumVelocity=ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
        this.mMinimumVelocity=ViewConfiguration.get(context).getScaledMinimumFlingVelocity();
    }

    /**
     * 在这里要设置viewpageer本身的高度，这里一定要设置的尽量大
     * 或者就是全屏都可以,这样才会让整个定义的Layout超出屏幕的范围
     * @param widthMeasureSpec
     * @param heightMeasureSpec
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
          super.onMeasure(widthMeasureSpec,heightMeasureSpec);
          ViewGroup.LayoutParams mLayoutParams=this.mViewPager.getLayoutParams();
          mLayoutParams.height=this.getMeasuredHeight()-this.mSimpleIncator.getMeasuredHeight();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
          super.onSizeChanged(w,h,oldw,oldh);
          this.mTopViewHeight=this.mTop.getMeasuredHeight();
          Log.i("lzw","topHeight"+this.mTopViewHeight);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.mViewPager=(ViewPager)this.findViewById(R.id.viewpager_detail2_viewdetials);
        this.mTop=this.findViewById(R.id.relayout_detail2_showdetail);
        this.mSimpleIncator=this.findViewById(R.id.mydefindicator_detailactivity_viewpagerindicator);
    }

    /**
     * startScroll(滑动的起点的X,滑动的起点的Y,滑动的最终距离X，滑动的最终距离Y)
     * @param event
     * @return
     */
    @Override
    public boolean onTouchEvent(MotionEvent event){
         this.mVelocityTracker.addMovement(event);
         switch (event.getAction()) {
             case MotionEvent.ACTION_DOWN:
                 this.mLastY = event.getY();
                 if (this.mScroller.isFinished()) {
                     this.mScroller.abortAnimation();
                 }
                 break;
             case MotionEvent.ACTION_MOVE:
                 float disY = event.getY() - this.mLastY;
                 if (!this.isDragging && Math.abs(disY) > this.mTouchSlop) {
                     this.isDragging = true;
                 }
                 if (this.isDragging) {
                     this.scrollBy(0, -(int) disY);
                     this.mLastY=event.getY();
                 }
                 break;
             case MotionEvent.ACTION_UP:
                 this.isDragging = false;
//                 this.mVelocityTracker.computeCurrentVelocity(1000,this.mMaximumVelocity);
//                 float velocityY=this.mVelocityTracker.getYVelocity();
//                 //向下滑动，速率的计算值肯定是负数
//                 if(Math.abs(velocityY)>this.mMinimumVelocity){
//                      this.fling(-(int)velocityY);
//                 }
                 float disTmp=event.getY()-this.mLastY;
                 this.mScroller.startScroll(this.mScroller.getFinalX(),
                                 this.getScrollY(),0,-(int)disTmp);

                 break;
         }
         return(true);
    }


    /**
     * fling函数
     * startX:开始滑动的X起点
     * startY:开始滚动的Y起点
     * velocityX:滑动的速度X
     * velocityY:滑动的速度Y
     * minx:X方向的最小值
     * maxX:X方向的最大值
     * minY:Y方向的最小值
     * maxY:Y方向的最大值
     * @param velocity
     */
    private void fling(int velocity){
         this.mScroller.fling(0,this.getScrollY(),0,velocity,0,0,0,this.mTopViewHeight);
         this.invalidate();
    }


    /**
     * 在fling或者startScroll方法后，调用invalidate方法后执行的函数
     * scroller.getCurY() 返回当前Y方向的偏移
     */
    @Override
    public void computeScroll() {
        if(this.mScroller.computeScrollOffset()){
              this.scrollTo(0,this.mScroller.getCurrY());
              invalidate();
        }
    }

    /**
     *
     * @param x
     * @param y
     */
    @Override
    public void scrollTo(int x,int y){
            if(y<0) {
                y = 0;
            }
            //指定一个滑动的上限
            if(y>this.mTopViewHeight){
               y=mTopViewHeight;
            }
            if(y!=this.getScrollY()){
                  super.scrollTo(x,y);
            }
           this.isTopHidden=(getScrollY()==mTopViewHeight);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event){
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                 this.mLastY=event.getY();
                 break;
            case MotionEvent.ACTION_MOVE:
                 float disY=event.getY()-this.mLastY;
                 this.getFramgmentInnerView();
                /**
                 *两种情况拦截事件:
                 * 当顶部的TopView还没有完全被遮盖的时候，滑动事件不向下处理
                 * 之后会将手势事件下放,
                 * 当我们在顶部的列表view的Y=0且绑定手势是想要向上滑动的,则再次回收
                 * 事件监测处理权
                 */
                  if(Math.abs(disY)>this.mTouchSlop){
                        this.isDragging=true;
                        if(!this.isTopHidden ||
                                (this.isTopHidden &&
                                  this.mFragmentInnerView.getScrollY()==0
                                  && (disY)>0)){
                              this.mLastY=event.getY();
                              this.mVelocityTracker.addMovement(event);
                              return(true);
                        }
                  }
                  Log.i("lzw","innerViewY"+this.mFragmentInnerView.getScrollY());

                 break;
            case MotionEvent.ACTION_UP:
                 this.isDragging=false;
                 break;
        }
        return(super.onInterceptTouchEvent(event));
    }

    private void getFramgmentInnerView(){
          if(this.mFragmentInnerView==null){
                 int itemCount=this.mViewPager.getCurrentItem();
                 PagerAdapter pagerAdapter=this.mViewPager.getAdapter();
                 Fragment item=(Fragment)pagerAdapter.instantiateItem(mViewPager,itemCount);
                 mFragmentInnerView=item.getView().findViewById(R.id.scrollview_tabfra_rootview);
           }
    }


}
