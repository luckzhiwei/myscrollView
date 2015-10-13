package slidingmenu.dreamfly.org.slidingmenu.custom.app;
import android.view.View;

import android.view.ViewGroup.LayoutParams;
import slidingmenu.dreamfly.org.slidingmenu.custom.SlidingMenu;

/**
 * Created by asus on 2015/4/2.
 */
public interface SlidingActivityBase {

    public void setBehindContentView(View v, LayoutParams p);

    public SlidingMenu getSlidingMenu();

    public void toggle();

    public void showAbove();

    public void showBehind();
}
