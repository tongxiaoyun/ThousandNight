package com.risenb.thousandnight.pop;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.risenb.thousandnight.R;
import com.risenb.thousandnight.adapter.MusicPlayAdapter;

/**
 * ================================================
 * 作    者：tongxiaoyun
 * 版    本：1.0
 * 创建日期：2018/5/21
 * 描    述：
 * 修订历史：
 * ================================================
 */
public class MusicPlayPopUtils extends CommentPopUtils {

    private RecyclerView rv_pop_music_play;
    private TextView tv_pop_music_play_cancle;
    private MusicPlayAdapter<Object> musicPlayAdapter;

    public MusicPlayPopUtils(View v, Context context, int layout) {
        super(v, context, layout);
    }

    @Override
    public void initLayout(View v, Context context) {
        rv_pop_music_play = v.findViewById(R.id.rv_pop_music_play);
        tv_pop_music_play_cancle = v.findViewById(R.id.tv_pop_music_play_cancle);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        musicPlayAdapter = new MusicPlayAdapter<>();
        musicPlayAdapter.setActivity((FragmentActivity) context);
        rv_pop_music_play.setLayoutManager(linearLayoutManager);
        rv_pop_music_play.setAdapter(musicPlayAdapter);
    }
}
