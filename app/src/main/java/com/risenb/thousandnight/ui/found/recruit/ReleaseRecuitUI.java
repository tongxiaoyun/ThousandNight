package com.risenb.thousandnight.ui.found.recruit;

import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.risenb.thousandnight.R;
import com.risenb.thousandnight.ui.BaseUI;

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
public class ReleaseRecuitUI extends BaseUI implements ReleaseRecruitP.ReleaseRecruitFace, RadioGroup.OnCheckedChangeListener {

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

    private ReleaseRecruitP releaseRecruitP;

    private String salaryType = "1";

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

    @OnClick(R.id.ll_release_recruit_type)
    void positionType() {

    }

    @OnClick(R.id.ll_release_recruit_years)
    void workYears() {

    }

    @OnClick(R.id.ll_release_recruit_grade)
    void positionGrade() {

    }

    @OnClick(R.id.ll_release_recruit_addr)
    void positionAddr() {

    }

    @Override
    public String getPositionName() {
        return et_release_recruit_name.getText().toString().trim();
    }

    @Override
    public String getPositionType() {
        return null;
    }

    @Override
    public String getTypeName() {
        return null;
    }

    @Override
    public String getWorkYears() {
        return null;
    }

    @Override
    public String getYearsName() {
        return null;
    }

    @Override
    public String getPositionGrade() {
        return null;
    }

    @Override
    public String getGradeName() {
        return null;
    }

    @Override
    public String getProvinceId() {
        return null;
    }

    @Override
    public String getProvinceName() {
        return null;
    }

    @Override
    public String getCityId() {
        return null;
    }

    @Override
    public String getCityName() {
        return null;
    }

    @Override
    public String getAreaId() {
        return null;
    }

    @Override
    public String getAreaName() {
        return null;
    }

    @Override
    public String getSalaryType() {
        return salaryType;
    }

    @Override
    public String getSalaryBegin() {
        if ("1".equals(salaryType)) {
            return et_release_recruit_salary_begin.getText().toString().trim();
        } else if ("2".equals(salaryType)) {
            return "";
        }
        return "";
    }

    @Override
    public String getSalaryEnd() {
        if ("1".equals(salaryType)) {
            return et_release_recruit_salary_end.getText().toString().trim();
        } else if ("2".equals(salaryType)) {
            return "";
        }
        return "";
    }

    @Override
    public String getPositionDesc() {
        return et_release_recruit_desc.getText().toString().trim();
    }

}
