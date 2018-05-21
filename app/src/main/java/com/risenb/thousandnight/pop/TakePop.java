package com.risenb.thousandnight.pop;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.risenb.thousandnight.R;

/**
 * Created by user on 2018/5/11.
 */

public class TakePop extends CommentPopUtils implements View.OnClickListener {

    private TextView tv_cancel;
    private TextView tv_take;
    private TextView tv_album;

    public TakePop(View v, Context context, int layout) {
        super(v, context, layout);
    }

    @Override
    public void initLayout(View v, Context context) {
        tv_cancel = (TextView) v.findViewById(R.id.tv_cancel);
        tv_take = (TextView) v.findViewById(R.id.tv_take);
        tv_album = (TextView) v.findViewById(R.id.tv_album);
        tv_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        tv_take.setOnClickListener(this);
        tv_album.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (onClickListener != null) {
            onClickListener.onClick(v);
        }
    }
}
