package slidingmenu.dreamfly.org.slidingmenu.custom.app;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import slidingmenu.dreamfly.org.slidingmenu.R;

/**
 * Created by asus on 2015/10/20.
 */
public class TestScrollActivity extends Activity {

    private Button btnTestScrollTest;
    private Button btnTestScrollTo;
    private TextView textViewTestScrollTest;
    private MyDedefineTextView defineTextViewTestScrollScroll2;



    protected void onCreate(Bundle savedInstanceState){
         super.onCreate(savedInstanceState);
         this.setContentView(R.layout.test_scroll_layout);
         this.btnTestScrollTest=(Button)this.findViewById(R.id.test_scroll_by);
         this.btnTestScrollTo=(Button)this.findViewById(R.id.test_scroll_to);
         this.textViewTestScrollTest=(TextView)this.findViewById(R.id.textview_testScroll_scroll);
         this.defineTextViewTestScrollScroll2=(MyDedefineTextView)this.findViewById(R.id.definetextview_testScroll_scroll2);
         this.btnTestScrollTest.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                    textViewTestScrollTest.scrollBy(-30,0);
             }
         });

        this.btnTestScrollTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 textViewTestScrollTest.scrollTo(30,0);
            }
         });


    }


}
