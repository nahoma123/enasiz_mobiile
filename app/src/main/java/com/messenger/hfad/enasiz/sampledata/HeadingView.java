package com.messenger.hfad.enasiz.sampledata;

import android.content.Context;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.messenger.hfad.enasiz.R;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;
import com.mindorks.placeholderview.annotations.expand.Collapse;
import com.mindorks.placeholderview.annotations.expand.Expand;
import com.mindorks.placeholderview.annotations.expand.Parent;
import com.mindorks.placeholderview.annotations.expand.ParentPosition;
import com.mindorks.placeholderview.annotations.expand.SingleTop;
import com.mindorks.placeholderview.annotations.expand.Toggle;

/**
 * Created by Nahom on 2018-03-31.
 */

@Parent
@SingleTop
@Layout(R.layout.feed_heading)
public class HeadingView {

    @View(R.id.headingTxt)
    private TextView headingTxt;
    @View(R.id.shitTxt)
    private TextView shitTxt;

    @View(R.id.toggleIcon)
    private TextView toggleIcon;

    @Toggle(R.id.matchtoggle)
    private LinearLayout toggleView;

    @ParentPosition
    private int mParentPosition;

    private Context mContext;
    private String mHeading;
    private String mShit;

    public HeadingView(Context context, String heading, String shit) {
        mContext = context;
        mHeading = heading;
        mShit =shit;
    }

    @Resolve
    private void onResolved() {
        toggleIcon.setText("Show Bets");
        headingTxt.setText(mHeading);
        shitTxt.setText(mShit);
    }

    @Expand
    private void onExpand(){
        toggleIcon.setText("Show Bets");
    }

    @Collapse
    private void onCollapse(){
        toggleIcon.setText("Hide Bets");
    }
}

