package com.risenb.thousandnight.ui.home.fragment.music;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.risenb.thousandnight.R;
import com.risenb.thousandnight.adapter.MusicAdapter;
import com.risenb.thousandnight.adapter.MusicClassifyAdapter;
import com.risenb.thousandnight.beans.BannerBean;
import com.risenb.thousandnight.ui.BaseFragment;
import com.risenb.thousandnight.views.MyRecyclerView;
import com.risenb.thousandnight.views.banner.MZBannerView;
import com.risenb.thousandnight.views.banner.holder.MZHolderCreator;
import com.risenb.thousandnight.views.banner.holder.MZViewHolder;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * 音乐
 * Created by user on 2018/5/10.
 */

public class MusicFragment extends BaseFragment {

    /**
     * banner
     */
    @BindView(R.id.mzb_home)
    MZBannerView mzb_home;

    /**
     * 热播歌单
     */
    @BindView(R.id.mrv_music)
    MyRecyclerView mrv_music;

    /**
     * 歌曲分类
     */
    @BindView(R.id.mrv_music_classify)
    MyRecyclerView mrv_music_classify;

    private MusicAdapter<Object> musicAdapter;
    private MusicClassifyAdapter<Object> musicClassifyAdapter;
    private ArrayList<BannerBean> banners;

    @Override
    protected void loadViewLayout(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.ui_home_music, container, false);
    }

    @Override
    protected void setControlBasis() {
        initBanner();
        initAdapter();
    }

    @Override
    protected void prepareData() {

    }

    private void initBanner() {
        banners = new ArrayList<>();
        BannerBean bannerBean = null;
        bannerBean = new BannerBean();
        bannerBean.setImg("");
        banners.add(bannerBean);
        bannerBean = new BannerBean();
        bannerBean.setImg("");
        banners.add(bannerBean);
        bannerBean = new BannerBean();
        bannerBean.setImg("");
        banners.add(bannerBean);

        mzb_home.setPages(banners, new MZHolderCreator<ViewPagerHolder>() {
            @Override
            public ViewPagerHolder createViewHolder() {
                return new ViewPagerHolder();
            }
        });
        mzb_home.start();
    }

    private void initAdapter() {
        //热播歌单
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mrv_music.setLayoutManager(linearLayoutManager);
        musicAdapter = new MusicAdapter<>();
        musicAdapter.setActivity(getActivity());
        mrv_music.setAdapter(musicAdapter);

        //歌曲分类
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 3);
        mrv_music_classify.setLayoutManager(gridLayoutManager);
        musicClassifyAdapter = new MusicClassifyAdapter<>();
        musicClassifyAdapter.setActivity(getActivity());
        mrv_music_classify.setAdapter(musicClassifyAdapter);
    }

    public static final class ViewPagerHolder implements MZViewHolder<BannerBean> {

        private ImageView iv_home_banner;

        @Override
        public View createView(Context context) {
            View view = LayoutInflater.from(context).inflate(R.layout.include_home_banner, null);
            iv_home_banner = (ImageView) view.findViewById(R.id.iv_home_banner);
            return view;
        }

        @Override
        public void onBind(Context context, int position, BannerBean data) {
            Glide.with(context).load("").error(R.drawable.default_banner).placeholder(R.drawable.default_banner).into(iv_home_banner);

        }
    }
}
