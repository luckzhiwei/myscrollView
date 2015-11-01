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
           View mFramgmentView=inflater.inflate(R.layout.fragment_tab,container,false);
           this.textviewFragmentTitle=(TextView)mFramgmentView.findViewById(R.id.id_info);
           this.textviewFragmentTitle.setText(this.mTitle);
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

