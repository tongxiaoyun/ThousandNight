package com.risenb.thousandnight.ui.chat;

import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.risenb.expand.xrecyclerview.XRecyclerView;
import com.risenb.thousandnight.R;
import com.risenb.thousandnight.adapter.ChatAdapter;
import com.risenb.thousandnight.ui.BaseFragment;

import butterknife.BindView;

/**
 * 消息
 * Created by user on 2018/5/4.
 */

public class ChatFragment extends BaseFragment {

    @BindView(R.id.xrv_chat)
    XRecyclerView xrv_chat;

    private ChatAdapter<Object> chatAdapter;

    @Override
    protected void loadViewLayout(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.ui_chat, container, false);
    }

    @Override
    protected void setControlBasis() {
        setTitle("消息");
        backGone();
        initAdapter();
    }

    @Override
    protected void prepareData() {

    }

    private void initAdapter() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        xrv_chat.setLayoutManager(linearLayoutManager);
        chatAdapter = new ChatAdapter<>();
        chatAdapter.setActivity(getActivity());
        chatAdapter.setmHeaderCount(1);
        xrv_chat.setAdapter(chatAdapter);
    }

}
