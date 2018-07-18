package com.risenb.thousandnight.pop;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.risenb.thousandnight.R;

/**
 * Created by user on 2018/3/26.
 */

public class SexPop extends CommentPopUtils implements View.OnClickListener {

    private TextView tv_sex_boy;
    private TextView tv_sex_girl;
    private TextView tv_cancel;

    public SexPop(View v, Context context, int layout) {
        super(v, context, layout);
    }

    @Override
    public void initLayout(View v, Context context) {
        tv_sex_boy = (TextView) v.findViewById(R.id.tv_sex_boy);
        tv_sex_girl = (TextView) v.findViewById(R.id.tv_sex_girl);
        tv_cancel = (TextView) v.findViewById(R.id.tv_cancel);
        tv_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
        tv_sex_boy.setOnClickListener(this);
        tv_sex_girl.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

}
