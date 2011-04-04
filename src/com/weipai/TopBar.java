package com.weipai;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by IntelliJ IDEA.
 * User: lsha6086
 * Date: 4/1/11
 * Time: 12:28 PM
 * To change this template use File | Settings | File Templates.
 */
public class TopBar extends LinearLayout {
    private Context context;
    private LinearLayout topbarLL;

    private void init(AttributeSet attrs) {
        LayoutInflater inflater = LayoutInflater.from(context);
        topbarLL = (LinearLayout) inflater.inflate(R.layout.topbar, this);

        TypedArray array = getContext().obtainStyledAttributes(attrs, R.styleable.topbar);
        String leftButtonLabel = null;
        if(array.hasValue(R.styleable.topbar_leftButtonLabel))
            leftButtonLabel = array.getString(R.styleable.topbar_leftButtonLabel);

        String rightButtonLabel = null;
        if(array.hasValue(R.styleable.topbar_rightButtonLabel))
            rightButtonLabel = array.getString(R.styleable.topbar_rightButtonLabel);

        String title = null;
        if(array.hasValue(R.styleable.topbar_title))
            title = array.getString(R.styleable.topbar_title);

        Button leftButton = (Button)topbarLL.findViewById(R.id.leftButton);
        Button rightButton = (Button)topbarLL.findViewById(R.id.rightButton);
        TextView titleView = (TextView)topbarLL.findViewById(R.id.topBarTitle);

        if(leftButtonLabel!= null && leftButtonLabel.length() != 0)
            leftButton.setText(leftButtonLabel);
        else
            leftButton.setVisibility(INVISIBLE);

        if(rightButtonLabel!= null && rightButtonLabel.length() != 0)
            rightButton.setText(rightButtonLabel);
        else
            rightButton.setVisibility(INVISIBLE);

        if(title!= null && title.length() != 0)
            titleView.setText(title);
        else
            titleView.setVisibility(INVISIBLE);
    }

    public TopBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init(attrs);
    }


}
