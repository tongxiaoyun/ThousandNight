package com.risenb.thousandnight.ui.found.recruit;

import android.graphics.Color;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.bigkoo.pickerview.builder.OptionsPickerBuilder;
import com.bigkoo.pickerview.listener.OnOptionsSelectListener;
import com.bigkoo.pickerview.view.OptionsPickerView;
import com.risenb.thousandnight.R;
import com.risenb.thousandnight.beans.AreaBean;
import com.risenb.thousandnight.beans.ProviceBean;
import com.risenb.thousandnight.ui.BaseUI;
import com.risenb.thousandnight.ui.mine.info.AddressP;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * ================================================
 * 作    者：tongxiaoyun
 * 版    本：1.0
 * 创建日期：2018/5/27
 * 描    述：
 * 修订历史：
 * ================================================
 */
public class ReleaseRecuitUI extends BaseUI implements ReleaseRecruitP.ReleaseRecruitFace, AddressP.AddressFace, RadioGroup.OnCheckedChangeListener {

    @BindView(R.id.et_release_recruit_name)
    EditText et_release_recruit_name;

    @BindView(R.id.tv_release_recruit_type)
    TextView tv_release_recruit_type;

    @BindView(R.id.tv_release_recruit_years)
    TextView tv_release_recruit_years;

    @BindView(R.id.tv_release_recruit_grade)
    TextView tv_release_recruit_grade;

    @BindView(R.id.tv_release_recruit_addr)
    TextView tv_release_recruit_addr;

    @BindView(R.id.ll_release_recruit_salary)
    LinearLayout ll_release_recruit_salary;

    @BindView(R.id.rg_release_recruit_salary)
    RadioGroup rg_release_recruit_salary;

    @BindView(R.id.et_release_recruit_salary_begin)
    EditText et_release_recruit_salary_begin;

    @BindView(R.id.et_release_recruit_salary_end)
    EditText et_release_recruit_salary_end;

    @BindView(R.id.et_release_recruit_desc)
    EditText et_release_recruit_desc;

    private OptionsPickerView optionsPickerView;

    private ReleaseRecruitP releaseRecruitP;
    private AddressP addressP;

    private String positionType = "";
    private String typeName = "";
    private String workYears = "";
    private String yearsName = "";
    private String positionGrade = "";
    private String gradeName = "";
    private String salaryType = "1";

    private ArrayList<ProviceBean> options1Items = new ArrayList<>();
    private ArrayList<ArrayList<String>> options2Items = new ArrayList<>();
    private ArrayList<ArrayList<ArrayList<AreaBean>>> options3Items = new ArrayList<>();

    private String provinceId = "";
    private String cityId = "";
    private String areaId = "";

    private String provinceName = "";
    private String cityName = "";
    private String areaName = "";

    @Override
    protected void back() {
        finish();
    }

    @Override
    protected int getLayout() {
        return R.layout.ui_release_recuit;
    }

    @Override
    protected void setControlBasis() {
        setTitle("职位发布");
        releaseRecruitP = new ReleaseRecruitP(this, getActivity());
        addressP = new AddressP(this, getActivity());
        rg_release_recruit_salary.setOnCheckedChangeListener(this);
    }

    @Override
    protected void prepareData() {
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.rb_release_recruit_range:
                salaryType = "1";
                ll_release_recruit_salary.setVisibility(View.VISIBLE);
                break;
            case R.id.rb_release_recruit_face:
                salaryType = "2";
                ll_release_recruit_salary.setVisibility(View.GONE);
                break;
        }
    }

    private void initOptionsPickerView(final String type, final ArrayList<String> options1Items) {
        optionsPickerView = new OptionsPickerBuilder(ReleaseRecuitUI.this, new OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int option2, int options3, View v) {
                //测试数据
                if ("0".equals(type)) {
                    positionType = String.valueOf(options1);
                    typeName = options1Items.get(options1);
                    tv_release_recruit_type.setText(options1Items.get(options1));
                } else if ("1".equals(type)) {
                    workYears = String.valueOf(options1);
                    yearsName = options1Items.get(options1);
                    tv_release_recruit_years.setText(options1Items.get(options1));
                } else if ("2".equals(type)) {
                    positionGrade = String.valueOf(options1);
                    gradeName = options1Items.get(options1);
                    tv_release_recruit_grade.setText(options1Items.get(options1));
                }

            }
        })
                .setDividerColor(Color.GRAY)
                .setTextColorCenter(Color.GRAY)
                .setContentTextSize(18)
                .build();
        optionsPickerView.setPicker(options1Items);

    }

    private void initAddressPickView() {
        OptionsPickerView pvOptions = new OptionsPickerBuilder(ReleaseRecuitUI.this, new OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int option2, int options3, View v) {
                tv_release_recruit_addr.setText(options1Items.get(options1).getPickerViewText() + "  " + options1Items.get(options1).getCitys().get(option2).getCname() + "  " + options1Items.get(options1).getCitys().get(option2).getAreas().get(options3).getAname());
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
     * 职位类型
     */
    @OnClick(R.id.ll_release_recruit_type)
    void positionType() {
        ArrayList<String> options1Items = new ArrayList<>();
        options1Items.add("教练");
        options1Items.add("教练");
        initOptionsPickerView("0", options1Items);
        optionsPickerView.setTitleText("职位类型");
        optionsPickerView.show();
    }

    /**
     * 工作年限
     */
    @OnClick(R.id.ll_release_recruit_years)
    void workYears() {
        ArrayList<String> options1Items = new ArrayList<>();
        options1Items.add("1-3年");
        options1Items.add("3-5年");
        initOptionsPickerView("1", options1Items);
        optionsPickerView.setTitleText("工作年限");
        optionsPickerView.show();
    }

    /**
     * 职位等级
     */
    @OnClick(R.id.ll_release_recruit_grade)
    void positionGrade() {
        ArrayList<String> options1Items = new ArrayList<>();
        options1Items.add("初级");
        options1Items.add("中级");
        options1Items.add("高级");
        initOptionsPickerView("2", options1Items);
        optionsPickerView.setTitleText("职位等级");
        optionsPickerView.show();
    }

    /**
     * 工作地点
     */
    @OnClick(R.id.ll_release_recruit_addr)
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

    @Override
    public String getPositionName() {
        return et_release_recruit_name.getText().toString().trim();
    }

    @Override
    public String getPositionType() {
        return positionType;
    }

    @Override
    public String getTypeName() {
        return typeName;
    }

    @Override
    public String getWorkYears() {
        return workYears;
    }

    @Override
    public String getYearsName() {
        return yearsName;
    }

    @Override
    public String getPositionGrade() {
        return positionGrade;
    }

    @Override
    public String getGradeName() {
        return gradeName;
    }

    @Override
    public String getProvinceId() {
        return provinceId;
    }

    @Override
    public String getProvinceName() {
        return provinceName;
    }

    @Override
    public String getCityId() {
        return cityId;
    }

    @Override
    public String getCityName() {
        return cityName;
    }

    @Override
    public String getAreaId() {
        return areaId;
    }

    @Override
    public String getAreaName() {
        return areaName;
    }

    @Override
    public String getSalaryType() {
        return salaryType;
    }

    @Override
    public String getSalaryBegin() {
        return et_release_recruit_salary_begin.getText().toString().trim();
    }

    @Override
    public String getSalaryEnd() {
        return et_release_recruit_salary_end.getText().toString().trim();
    }

    @Override
    public String getPositionDesc() {
        return et_release_recruit_desc.getText().toString().trim();
    }

    @OnClick(R.id.tv_release_recruit_publish)
    void publish() {
        releaseRecruitP.addPosition();
    }

    @Override
    public void publishSuccess() {
        FoundRecruitUI.isRefresh = true;
        finish();
    }

}
