package slidingmenu.dreamfly.org.slidingmenu.custom.app;

import android.content.Context;
import android.support.v4.view.VelocityTrackerCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
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

    private OverScroller mScroller;
    private float mLastY;

    public MyDefineHorzontalView(Context context, AttributeSet attrs) {
        super(context,attrs);
        this.mTouchSlop=ViewConfiguration.get(context).getScaledTouchSlop();
        this.mMaxVelocity= ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
        this.mMinVelocity=ViewConfiguration.get(context).getScaledMinimumFlingVelocity();
        this.mVeloctiyTracker=VelocityTracker.obtain();
        this.mScroller=new OverScroller(context);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                this.mLastY=event.getX();
                this.mVeloctiyTracker.addMovement(event);
                break;
            case MotionEvent.ACTION_MOVE:

                break;
            case MotionEvent.ACTION_UP:
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


}
