package slidingmenu.dreamfly.org.slidingmenu.custom.app;

import android.content.Context;
import android.support.v4.view.VelocityTrackerCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.OverScroller;
import android.widget.TextView;

import slidingmenu.dreamfly.org.slidingmenu.R;

/**
 * Created by asus on 2015/11/3.
 */
public class MyDefineHorzontalView extends LinearLayout {

    private View mViewSHlayoutChating;
    private TextView mTextViewSHlayoutDetele;

    private VelocityTracker mVeloctiyTracker;
    private int mMaxVelocity,mMinVelocity;
    private int mTouchSlop;

    private int mHiddienWidth;
    private boolean isHidden;
    private OverScroller mScroller;
    private float mLastX;

    public MyDefineHorzontalView(Context context, AttributeSet attrs) {
        super(context,attrs);
        this.mTouchSlop=ViewConfiguration.get(context).getScaledTouchSlop();
        this.mMaxVelocity= ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
        this.mMinVelocity=ViewConfiguration.get(context).getScaledMinimumFlingVelocity();
        this.mVeloctiyTracker=VelocityTracker.obtain();
        this.mScroller=new OverScroller(context);
        this.isHidden=true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                this.mLastX=event.getX();
                this.mVeloctiyTracker.addMovement(event);
                break;
            case MotionEvent.ACTION_UP:
                float disX=event.getX()-this.mLastX;
                this.mScroller.startScroll(this.getScrollX(),
                         this.mScroller.getCurrY(),-(int)(disX),0);
                this.invalidate();
//                this.mLastX=event.getX();
////                this.mVeloctiyTracker.computeCurrentVelocity(1000,this.mMaxVelocity);
////                float velocityY=mVeloctiyTracker.getXVelocity();
////                Log.i("lzw","velocity"+velocityY);
////                this.fling(-(int)velocityY);
                break;
        }
        return(true);
    }


    @Override
    protected void onFinishInflate(){
          super.onFinishInflate();
          this.mTextViewSHlayoutDetele=(TextView)this.findViewById(R.id.textview_hslayout_delete);
          this.mViewSHlayoutChating=this.findViewById(R.id.textview_hslayout_chating);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec,heightMeasureSpec);
        ViewGroup.LayoutParams layoutParams=this.mTextViewSHlayoutDetele.getLayoutParams();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w,h,oldw,oldh);
        this.mHiddienWidth=this.mTextViewSHlayoutDetele.getMeasuredWidth();
    }


    private void fling(int velocityX){
           Log.i("lzw","fling");
           this.mScroller.fling(this.getScrollX(),0,velocityX,0,0,this.mHiddienWidth,0,0);
           this.invalidate();
    }

    @Override
    public void computeScroll(){
          if(this.mScroller.computeScrollOffset()){
                 this.scrollTo(this.mScroller.getCurrX(),0);
                 invalidate();
          }
    }

    @Override
    public void scrollTo(int x,int y){
           if(x<0){
                super.scrollTo(0,0);
                return;
           }
           if(x>this.mHiddienWidth) {
               x=mHiddienWidth;
           }
           super.scrollTo(x,0);

    }


}
