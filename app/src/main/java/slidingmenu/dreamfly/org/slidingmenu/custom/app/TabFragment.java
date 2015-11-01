package slidingmenu.dreamfly.org.slidingmenu.custom.app;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import slidingmenu.dreamfly.org.slidingmenu.R;

/**
 * Created by asus on 2015/10/19.
 */
public class TabFragment extends Fragment {

    private TextView  textviewFragmentTitle;
    private LinearLayout linearFragementRootLayout;
    private String mTitle;
    private int backgroundIndex;
    public static final String  TITLE="title";
    public static final String  BACKGROUAND="BACKGROUND";


    @Override
    public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            if(this.getArguments()!=null){
                mTitle=getArguments().getString(TITLE);
                backgroundIndex=getArguments().getInt(BACKGROUAND);
            }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
           View mFramgmentView=inflater.inflate(R.layout.tabfragment_layout,container,false);
           this.textviewFragmentTitle=(TextView)mFramgmentView.findViewById(R.id.textview_tabfag_title);
           this.linearFragementRootLayout=(LinearLayout)mFramgmentView.findViewById(R.id.linearlayout_tabfragment_rootlayout);
           this.textviewFragmentTitle.setText(mTitle);
           switch (this.backgroundIndex){
               case 1:
                     this.linearFragementRootLayout.setBackgroundResource(R.drawable.pic_one);
                      break;
               case 2:
                     this.linearFragementRootLayout.setBackgroundResource(R.drawable.pic_two);
                     break;
               case 3:
                     this.linearFragementRootLayout.setBackgroundResource(R.drawable.pic_three);
                     break;
               default:
                     break;
           }
           return(mFramgmentView);
    }

    public static  TabFragment newInstatence(String title,int background){
        TabFragment tabFragment = new TabFragment();
        Bundle bundle = new Bundle();
        bundle.putString(TITLE, title);
        bundle.putInt(BACKGROUAND,background);
        tabFragment.setArguments(bundle);
        return tabFragment;
    }


}

