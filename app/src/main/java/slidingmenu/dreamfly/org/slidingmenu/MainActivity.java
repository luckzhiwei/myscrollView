package slidingmenu.dreamfly.org.slidingmenu;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import slidingmenu.dreamfly.org.slidingmenu.custom.PicGarellyActivity;
import slidingmenu.dreamfly.org.slidingmenu.custom.SlidingMenu;
import slidingmenu.dreamfly.org.slidingmenu.custom.app.DetailActivity;
import slidingmenu.dreamfly.org.slidingmenu.custom.app.SlidingActivity;


public class MainActivity extends Activity {


    private SlidingMenu mSlidingMenu;

    private Button btnMenuLeftShowid;
    private Button btnMenuLeftPicGralley;
    private Button btnMenuMainShowid;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        this.mSlidingMenu=(SlidingMenu)this.findViewById(R.id.slidingmenulayout);

        mSlidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        //设置滑动的形式，全屏幕滑动还是触摸边框滑动
        mSlidingMenu.setShadowWidthRes(R.dimen.shaow_width);
        //设置阴影的宽度
        mSlidingMenu.setBehindOffsetRes(R.dimen.slidingmenu_offsets);
        //设置当滑动左侧菜单栏时候，右侧的显示的剩下宽度
        mSlidingMenu.setFadeDegree(0.60f);
        mSlidingMenu.setViewAbove(R.layout.main_menu_layout);
        //设置主界面的布局
        mSlidingMenu.setViewBehind(R.layout.menu_left_layout);

        //设置侧滑菜单的主界面。
        View leftView=this.mSlidingMenu.getBehindView();
        View aboveView=this.mSlidingMenu.getAboveView();

        this.btnMenuLeftPicGralley=(Button)leftView.findViewById(R.id.btn_meun_left_layout_pic_gralley);
        this.btnMenuLeftShowid=(Button)leftView.findViewById(R.id.btn_menu_left_layout_showid);
        this.btnMenuMainShowid=(Button)aboveView.findViewById(R.id.btn_menu_main_layout_showid);

        this.btnMenuLeftShowid.setText("主菜单");
        this.btnMenuMainShowid.setText("显示侧滑");
      this.btnMenuLeftShowid.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                mSlidingMenu.showAbove();
            }
        });
        this.btnMenuMainShowid.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                mSlidingMenu.showBehind();
            }
        });
        this.btnMenuLeftPicGralley.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, DetailActivity.class);
                startActivity(intent);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private int getSrceenWidth(){
        WindowManager wm=(WindowManager)this.getSystemService(Context.WINDOW_SERVICE);
        return(wm.getDefaultDisplay().getWidth());
    }
}
