package com.risenb.thousandnight.ui.mine.info;

import android.content.Intent;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bigkoo.pickerview.builder.OptionsPickerBuilder;
import com.bigkoo.pickerview.listener.OnOptionsSelectListener;
import com.bigkoo.pickerview.view.OptionsPickerView;
import com.bumptech.glide.Glide;
import com.risenb.expand.imagepick.PhotoPicker;
import com.risenb.expand.imagepick.picker.Load;
import com.risenb.thousandnight.R;
import com.risenb.thousandnight.beans.AreaBean;
import com.risenb.thousandnight.beans.CardBean;
import com.risenb.thousandnight.beans.ProviceBean;
import com.risenb.thousandnight.ui.BaseUI;
import com.risenb.thousandnight.utils.GlideImageLoader;
import com.risenb.thousandnight.utils.GlideRoundTransform;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 资料
 * Created by user on 2018/5/7.
 */

public class PersonInfoUI extends BaseUI implements AddressP.AddressFace {

    //头像
    @BindView(R.id.iv_personinfo_icon)
    ImageView iv_personinfo_icon;
    //账号
    @BindView(R.id.tv_personinfo_account)
    TextView tv_personinfo_account;
    //昵称
    @BindView(R.id.et_personinfo_nickname)
    EditText et_personinfo_nickname;
    //生日
    @BindView(R.id.tv_personinfo_birthday)
    TextView tv_personinfo_birthday;
    //性别
    @BindView(R.id.tv_personinfo_sex)
    TextView tv_personinfo_sex;
    //地区
    @BindView(R.id.tv_personinfo_pcd)
    TextView tv_personinfo_pcd;
    //个性签名
    @BindView(R.id.et_personinfo_signature)
    EditText et_personinfo_signature;
    //老师
    @BindView(R.id.ll_personinfo_teacher)
    LinearLayout ll_personinfo_teacher;
    //老师特点
    @BindView(R.id.tfl_personinfo_feature)
    TagFlowLayout tfl_personinfo_feature;
    //上课地址
    @BindView(R.id.et_personinfo_address)
    EditText et_personinfo_address;
    //介绍
    @BindView(R.id.et_personinfo_intro)
    EditText et_personinfo_intro;

    private AddressP addressP;

    private String sex = "0";

    private ArrayList<ProviceBean> options1Items = new ArrayList<>();
    private ArrayList<ArrayList<String>> options2Items = new ArrayList<>();
    private ArrayList<ArrayList<ArrayList<AreaBean>>> options3Items = new ArrayList<>();

    private String provinceId = "";
    private String cityId = "";
    private String areaId = "";

    private String provinceName = "";
    private String cityName = "";
    private String areaName = "";

    private List<String> features = new ArrayList<String>();

    @Override
    protected void back() {
        finish();
    }

    @Override
    protected int getLayout() {
        return R.layout.ui_mine_personinfo;
    }

    @Override
    protected void setControlBasis() {
        setTitle("编辑资料");
        rightVisible("保存");
        addressP = new AddressP(this, getActivity());
    }

    @Override
    protected void prepareData() {
        if ("1".equals(getIntent().getStringExtra("role"))) {
            ll_personinfo_teacher.setVisibility(View.GONE);
        } else if ("2".equals(getIntent().getStringExtra("role"))) {
            ll_personinfo_teacher.setVisibility(View.VISIBLE);
        }
        Glide.with(getActivity()).load(application.getUserBean().getThumb())
                .transform(new GlideRoundTransform(getActivity()))
                .error(R.drawable.default_icon)
                .placeholder(R.drawable.default_icon)
                .into(iv_personinfo_icon);
        tv_personinfo_account.setText("");
        if (TextUtils.isEmpty(application.getUserBean().getNickName())) {
            et_personinfo_nickname.setHint("未设置");
        } else {
            et_personinfo_nickname.setHint(application.getUserBean().getNickName());
        }
        if (TextUtils.isEmpty(application.getUserBean().getBirthdayStr())) {
            tv_personinfo_birthday.setText("未设置");
        } else {
            tv_personinfo_birthday.setText(application.getUserBean().getBirthdayStr());
        }
        if ("0".equals(application.getUserBean().getGender())) {
            tv_personinfo_sex.setText("未设置");
        } else if ("1".equals(application.getUserBean().getGender())) {
            tv_personinfo_sex.setText("男");
        } else if ("2".equals(application.getUserBean().getGender())) {
            tv_personinfo_sex.setText("女");
        }

        features.add("科班出身");
        features.add("漂亮");
        features.add("活泼");
        tfl_personinfo_feature.setAdapter(new TagAdapter<String>(features) {
            @Override
            public View getView(FlowLayout parent, int position, String s) {
                TextView tv_hot_word = (TextView) LayoutInflater.from(PersonInfoUI.this).inflate(R.layout.item_mine_personinfo,
                        tfl_personinfo_feature, false);
                tv_hot_word.setText(s);
                return tv_hot_word;
            }
        });
    }

    private void initOptionsPickerView(final ArrayList<CardBean> options1Items) {
        OptionsPickerView optionsPickerView = new OptionsPickerBuilder(PersonInfoUI.this, new OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int option2, int options3, View v) {
                sex = String.valueOf(options1Items.get(options1).getId());
                tv_personinfo_sex.setText(options1Items.get(options1).getPickerViewText());

            }
        })
                .setTitleText("性别选择")
                .setDividerColor(Color.GRAY)
                .setTextColorCenter(Color.GRAY)
                .setContentTextSize(18)
                .build();
        optionsPickerView.setPicker(options1Items);
        optionsPickerView.show();

    }

    private void initAddressPickView() {
        OptionsPickerView pvOptions = new OptionsPickerBuilder(PersonInfoUI.this, new OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int option2, int options3, View v) {
                tv_personinfo_pcd.setText(options1Items.get(options1).getPickerViewText() + "  " + options1Items.get(options1).getCitys().get(option2).getCname() + "  " + options1Items.get(options1).getCitys().get(option2).getAreas().get(options3).getAname());
                provinceId = options1Items.get(options1).getPcode();
                cityId = options1Items.get(options1).getCitys().get(option2).getCcode();
                areaId = options1Items.get(options1).getCitys().get(option2).getAreas().get(options3).getAcode();

                provinceName = options1Items.get(options1).getPname();
                cityName = options1Items.get(options1).getCitys().get(option2).getCname();
                areaName = options1Items.get(options1).getCitys().get(option2).getAreas().get(options3).getAname();
            }
        })
                .setTitleText("城市选择")
                .setDividerColor(Color.GRAY)
                .setTextColorCenter(Color.GRAY)
                .setContentTextSize(18)
                .build();

        pvOptions.setPicker(options1Items, options2Items, options3Items);
        pvOptions.show();

    }

    /**
     * 性别修改
     */
    @OnClick(R.id.ll_personinfo_sex)
    void getSex() {
        ArrayList<CardBean> options1Items = new ArrayList<>();
        options1Items.add(new CardBean(1, "男"));
        options1Items.add(new CardBean(2, "女"));
        initOptionsPickerView(options1Items);
    }

    /**
     * 工作地点
     */
    @OnClick(R.id.ll_personinfo_pcd)
    void positionAddr() {
        if (options1Items == null || options1Items.size() == 0) {
            addressP.getPlaces();
        } else {
            initAddressPickView();
        }
    }

    @Override
    public void setAddress(ArrayList<ProviceBean> result) {
        options1Items = result;
        for (int i = 0; i < result.size(); i++) {//遍历省份
            ArrayList<String> CityList = new ArrayList<>();//该省的城市列表（第二级）
            ArrayList<ArrayList<AreaBean>> Province_AreaList = new ArrayList<>();//该省的所有地区列表（第三极）

            for (int c = 0; c < result.get(i).getCitys().size(); c++) {//遍历该省份的所有城市
                String CityName = result.get(i).getCitys().get(c).getCname();
                CityList.add(CityName);//添加城市
                ArrayList<AreaBean> City_AreaList = new ArrayList<>();//该城市的所有地区列表
                City_AreaList.addAll(result.get(i).getCitys().get(c).getAreas());
                Province_AreaList.add(City_AreaList);//添加该省所有地区数据
            }

            /**
             * 添加城市数据
             */
            options2Items.add(CityList);

            /**
             * 添加地区数据
             */
            options3Items.add(Province_AreaList);
        }

        initAddressPickView();
    }

    /**
     * 头像修改
     */
    @OnClick(R.id.ll_personinfo_icon)
    void getIcon() {
        PhotoPicker.init(new GlideImageLoader(), null);
        Load load = PhotoPicker.load()
                .showCamera(true)
                .gridColumns(3);
        load.single().start(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PhotoPicker.REQUEST_SELECTED) {
            if (resultCode == RESULT_OK) {
                ArrayList<String> mSelectPath = data.getStringArrayListExtra(PhotoPicker.EXTRA_RESULT);
//                minePersonInfoP.upload(mSelectPath.get(0));
            }
        }
    }

    /**
     * 特长
     */
    @OnClick(R.id.ll_personinfo_feature)
    void getFeature() {
        Intent intent = new Intent(PersonInfoUI.this, FeatureUI.class);
        startActivity(intent);
    }

}
