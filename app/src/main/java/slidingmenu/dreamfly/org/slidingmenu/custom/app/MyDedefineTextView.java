package slidingmenu.dreamfly.org.slidingmenu.custom.app;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.animation.BounceInterpolator;
import android.widget.Button;
import android.widget.OverScroller;
import android.widget.TextView;

/**
 * Created by asus on 2015/10/20.
 */
public class MyDedefineTextView extends Button {

    private OverScroller mScroller;
    private float lastX;
    private float lastY;

    private float startX;
    private float startY;

    public MyDedefineTextView(Context mContext, AttributeSet attrs) {
        super(mContext, attrs);
        this.mScroller = new OverScroller(mContext, new BounceInterpolator());
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                lastX = event.getRawX();
                lastY = event.getRawY();
                break;
            case MotionEvent.ACTION_MOVE:
                float disX = event.getRawX() - lastX;
                float disY = event.getRawY() - lastY;
                offsetLeftAndRight((int) disX);
                offsetTopAndBottom((int) disY);
                lastX = event.getRawX();
                lastY = event.getRawY();
                break;
            case MotionEvent.ACTION_UP:
                int movX=-(int)(getX()-startX);
                int movY=-(int)(getY()-startY);
                Log.i("lzw","movX"+movX);
                Log.i("lzw","movY"+movY);
                mScroller.startScroll((int)getX(),
                                       (int)getY(),
                                     -100,-100);
                invalidate();
                break;
        }

        return (super.onTouchEvent(event));
    }

    @Override
    public void computeScroll() {
           if(this.mScroller.computeScrollOffset()){
                 setX(mScroller.getCurrX());
                 setY(mScroller.getCurrY());
                 invalidate();

           }
    }

        @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        return (this.onTouchEvent(event));
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        startX = getX();
        startY = getY();
    }


}
