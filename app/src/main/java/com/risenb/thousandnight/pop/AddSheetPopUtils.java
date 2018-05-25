package com.risenb.thousandnight.pop;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.risenb.thousandnight.R;
import com.risenb.thousandnight.adapter.MyMusicAdapter;

/**
 * ================================================
 * 作    者：tongxiaoyun
 * 版    本：1.0
 * 创建日期：2018/5/24
 * 描    述：
 * 修订历史：
 * ================================================
 */
public class AddSheetPopUtils extends CommentPopUtils implements View.OnClickListener {
    private MyMusicAdapter<Object> myMusicAdapter;

    public AddSheetPopUtils(View v, Context context, int layout) {
        super(v, context, layout);
    }

    @Override
    public void initLayout(View v, Context context) {
        RecyclerView rv_add_sheet = v.findViewById(R.id.rv_add_sheet);
        TextView tv_add_sheet_add = v.findViewById(R.id.tv_add_sheet_add);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rv_add_sheet.setLayoutManager(linearLayoutManager);

        myMusicAdapter = new MyMusicAdapter<>();
        myMusicAdapter.setActivity((FragmentActivity) context);
        rv_add_sheet.setAdapter(myMusicAdapter);

        popupWindow.setAnimationStyle(R.style.take_photo_anim);
        tv_add_sheet_add.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        dismiss();
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }
}
