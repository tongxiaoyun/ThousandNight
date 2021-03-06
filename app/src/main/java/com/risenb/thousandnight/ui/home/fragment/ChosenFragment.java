package com.risenb.thousandnight.ui.home.fragment;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.risenb.expand.xrecyclerview.adapter.BaseRecyclerAdapter;
import com.risenb.thousandnight.R;
import com.risenb.thousandnight.adapter.HomeCourseAdapter;
import com.risenb.thousandnight.adapter.HomeMusicAdapter;
import com.risenb.thousandnight.adapter.HomeVideoAdapter;
import com.risenb.thousandnight.beans.BannerBean;
import com.risenb.thousandnight.beans.CourseListBean;
import com.risenb.thousandnight.beans.MusicSheetBean;
import com.risenb.thousandnight.beans.VideoListBean;
import com.risenb.thousandnight.ui.BaseFragment;
import com.risenb.thousandnight.ui.home.HomeP;
import com.risenb.thousandnight.ui.home.fragment.course.ChoiceCourseUI;
import com.risenb.thousandnight.ui.home.fragment.course.CourseDetialUI;
import com.risenb.thousandnight.ui.home.fragment.music.MusicPlayUI;
import com.risenb.thousandnight.ui.home.fragment.music.MusicSecondUI;
import com.risenb.thousandnight.ui.home.fragment.music.SongSheetUI;
import com.risenb.thousandnight.ui.home.fragment.video.NewsVideoUI;
import com.risenb.thousandnight.ui.home.homep.BannerP;
import com.risenb.thousandnight.views.MyRecyclerView;
import com.risenb.thousandnight.views.banner.MZBannerView;
import com.risenb.thousandnight.views.banner.holder.MZHolderCreator;
import com.risenb.thousandnight.views.banner.holder.MZViewHolder;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 精选
 * Created by user on 2018/5/4.
 */

public class ChosenFragment extends BaseFragment implements BannerP.BannerFace, ChosenP.ChosenFace {

    /**
     * banner
     */
    @BindView(R.id.mzb_home)
    MZBannerView mzb_home;

    /**
     * 热播视频
     */
    @BindView(R.id.mrv_home_video)
    MyRecyclerView mrv_home_video;

    /**
     * 推荐歌单
     */
    @BindView(R.id.mrv_home_music)
    MyRecyclerView mrv_home_music;

    /**
     * 精选课程
     */
    @BindView(R.id.mrv_home_course)
    MyRecyclerView mrv_home_course;

    private BannerP bannerP;

    private HomeVideoAdapter<VideoListBean> homeVideoAdapter;
    private HomeMusicAdapter<MusicSheetBean> homeMusicAdapter;
    private HomeCourseAdapter<CourseListBean> homeCourseAdapter;

    private ArrayList<BannerBean> banners;
    private ChosenP chosenP;

    @Override
    protected void loadViewLayout(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.ui_home_chosen, container, false);
    }

    @Override
    protected void setControlBasis() {
        bannerP = new BannerP(this, getActivity());
        chosenP = new ChosenP(this, getActivity());
        initAdapter();
    }

    @Override
    protected void prepareData() {
        bannerP.getBanner();
        chosenP.videoListHot();
        chosenP.musicSheetList();
        chosenP.selectedList();
    }

    private void initAdapter() {
        //热播视频
        GridLayoutManager glm_video = new GridLayoutManager(getActivity(), 3);
        glm_video.setOrientation(GridLayoutManager.VERTICAL);
        mrv_home_video.setLayoutManager(glm_video);
        homeVideoAdapter = new HomeVideoAdapter<>();
        homeVideoAdapter.setActivity(getActivity());
        mrv_home_video.setAdapter(homeVideoAdapter);


        //推荐歌单
        LinearLayoutManager llm_music = new LinearLayoutManager(getActivity());
        llm_music.setOrientation(LinearLayoutManager.HORIZONTAL);
        mrv_home_music.setLayoutManager(llm_music);
        homeMusicAdapter = new HomeMusicAdapter<>();
        homeMusicAdapter.setActivity(getActivity());
        mrv_home_music.setAdapter(homeMusicAdapter);

        homeMusicAdapter.setOnItemClickListener(new BaseRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int i) {
                Intent intent = new Intent(getActivity(), SongSheetUI.class);
                getActivity().startActivity(intent);
            }
        });

        //精选课程
        GridLayoutManager glm_course = new GridLayoutManager(getActivity(), 2);
        mrv_home_course.setLayoutManager(glm_course);
        homeCourseAdapter = new HomeCourseAdapter<>();
        homeCourseAdapter.setActivity(getActivity());
        mrv_home_course.setAdapter(homeCourseAdapter);

        homeCourseAdapter.setOnItemClickListener(new BaseRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int i) {
                Intent intent = new Intent(getActivity(), CourseDetialUI.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public String getBannerType() {
        return "1";
    }

    @Override
    public void setBanner(ArrayList<BannerBean> result) {
        banners = result;
        mzb_home.setPages(banners, new MZHolderCreator<ViewPagerHolder>() {
            @Override
            public ViewPagerHolder createViewHolder() {
                return new ViewPagerHolder();
            }
        });
        mzb_home.start();
    }

    @Override
    public void setHotVideo(ArrayList<VideoListBean> result) {
        homeVideoAdapter.setList(result);
    }

    @Override
    public void setHotMusic(ArrayList<MusicSheetBean> result) {
        homeMusicAdapter.setList(result);
    }

    @Override
    public void setCourse(ArrayList<CourseListBean> result) {
        homeCourseAdapter.setList(result);
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
            Glide.with(context).load(data.getImageUrl())
                    .error(R.drawable.default_banner)
                    .placeholder(R.drawable.default_banner)
                    .into(iv_home_banner);
        }
    }

    @OnClick(R.id.iv_home_music)
    void play() {
        Intent intent = new Intent(getActivity(), MusicPlayUI.class);
        startActivity(intent);
    }

    @OnClick(R.id.ll_home_video_more)
    void toNews() {
        Intent intent = new Intent(getActivity(), NewsVideoUI.class);
        intent.putExtra("title", "热播视频");
        intent.putExtra("isHot", "1");
        startActivity(intent);
    }

    @OnClick(R.id.ll_home_music_more)
    void toMusic() {
        Intent intent = new Intent(getActivity(), MusicSecondUI.class);
        intent.putExtra("title", "推荐歌单");
        intent.putExtra("isRecommend", "1");
        startActivity(intent);
    }


    @OnClick(R.id.ll_home_choice_more)
    void toChoice() {
        Intent intent = new Intent(getActivity(), ChoiceCourseUI.class);
        startActivity(intent);
    }


    @OnClick(R.id.tv_home_video_refresh)
    void refreshVideo() {
        chosenP.videoListHot();
    }

    @OnClick(R.id.tv_home_course_refresh)
    void refreshCourse() {
        chosenP.selectedList();
    }

}
