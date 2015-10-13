package slidingmenu.dreamfly.org.slidingmenu.custom;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.widget.ViewFlipper;

import slidingmenu.dreamfly.org.slidingmenu.R;

/**
 * Created by asus on 2015/8/17.
 */
public class PicGarellyActivity extends Activity{

    private ViewFlipper viewFlipperPicGarellyShowPic;
    private float startXPiont;
    private int picFlag;

    protected void onCreate(Bundle savedInstanceState) {
           super.onCreate(savedInstanceState);
           this.setContentView(R.layout.picgralley_layout);
           this.init();
    }

    private void init(){
         this.picFlag=2;
         this.viewFlipperPicGarellyShowPic=(ViewFlipper)this.findViewById(R.id.view_flipper_pic_gralley_showpic);
         this.viewFlipperPicGarellyShowPic.addView(LayoutInflater.from(this).inflate(R.layout.pic1_layout,null));
         this.viewFlipperPicGarellyShowPic.addView(LayoutInflater.from(this).inflate(R.layout.pic2_layout,null));
         this.viewFlipperPicGarellyShowPic.addView(LayoutInflater.from(this).inflate(R.layout.pic3_layout,null));
    }

    public boolean onTouchEvent(MotionEvent event){
         switch (event.getAction()){
             case MotionEvent.ACTION_DOWN:
             this.startXPiont=event.getX();
             break;
             /**
              * 基于栈结构判断
              */
             case MotionEvent.ACTION_UP:
                  if(event.getX()>this.startXPiont) {//向右滑动
                      if (picFlag <2) {
                          picFlag++;
                          this.viewFlipperPicGarellyShowPic.setInAnimation(this, R.anim.slide_left_in);
                          this.viewFlipperPicGarellyShowPic.setOutAnimation(this, R.anim.slide_right_out);
                          this.viewFlipperPicGarellyShowPic.showNext();
                          Log.i("lzw",picFlag+"右滑动");
                      }
                  }else if(event.getX()<this.startXPiont) {//向左滑动
                      picFlag--;
                      if (picFlag>=0) {
                          Log.i("lzw",picFlag+"左滑动");
                          this.viewFlipperPicGarellyShowPic.setInAnimation(this, R.anim.slide_right_in);
                          this.viewFlipperPicGarellyShowPic.setOutAnimation(this, R.anim.slide_left_out);
                          this.viewFlipperPicGarellyShowPic.showPrevious();
                      }
                  }
             break;

         }
         return(super.onTouchEvent(event));
    }

}
