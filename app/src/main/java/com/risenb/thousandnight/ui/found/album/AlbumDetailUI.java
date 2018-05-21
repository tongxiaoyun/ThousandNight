package com.risenb.thousandnight.ui.found.album;

import com.risenb.thousandnight.R;
import com.risenb.thousandnight.ui.BaseUI;

/**
 * 相片详情
 * Created by user on 2018/5/15.
 */

public class AlbumDetailUI extends BaseUI {
    @Override
    protected void back() {
        finish();
    }

    @Override
    protected int getLayout() {
        return R.layout.ui_found_album_detail;
    }

    @Override
    protected void setControlBasis() {

    }

    @Override
    protected void prepareData() {

    }
}
