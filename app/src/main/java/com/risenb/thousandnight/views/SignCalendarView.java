package com.risenb.thousandnight.views;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.risenb.thousandnight.MyApplication;
import com.risenb.thousandnight.R;
import com.risenb.thousandnight.beans.SignBean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * ================================================
 * 作    者：tongxiaoyun
 * 版    本：1.0
 * 创建日期：2018/4/9
 * 描    述：
 * 修订历史：
 * ================================================
 */
public class SignCalendarView extends LinearLayout {
    private Context mContext;

    private List<String> list = new ArrayList<String>();
    private List<Integer> sinalist = new ArrayList<Integer>();
    private HashMap<Integer, SignBean> map = new HashMap<>();

    private int dayMaxNum;
    private int year, month, day;
    private int space;

    Calendar mCalendar;
    GridView gdDate;
    private SimpleDateFormat dateFormat;

    public SignCalendarView(Context context) {
        this(context, null, 0);
    }

    public SignCalendarView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SignCalendarView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        init();
    }

    private void init() {
        View view = View.inflate(mContext, R.layout.sign_view, this);
        gdDate = (GridView) view.findViewById(R.id.gdDate);

        dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date m = new Date();
        //获得日历对象
        mCalendar = dateFormat.getCalendar();
        mCalendar.setTime(m);
        year = mCalendar.get(Calendar.YEAR);
        month = mCalendar.get(Calendar.MONTH) + 1;//因为月份是从0开始计算的，所以要加1
        day = mCalendar.get(Calendar.DAY_OF_MONTH);
        int weekOfMonth = mCalendar.get(Calendar.WEEK_OF_MONTH);
        //根据当前日期在本月第几周，以及当天在本周是第几天来推算出本月第1号是周几,需要几个空格
        int i = 0;
        int week = mCalendar.get(Calendar.DAY_OF_WEEK);//取的是今天是星期几，以周日开始，周日为1周六为7
        i += (week == 1 ? week + 6 : week - 1);
        weekOfMonth--;//先除去本周，看距离第一周还有几周
        if (weekOfMonth >= 1) {
            i += weekOfMonth * 7;
        }
        if (i > 0) {
            space = Math.abs(day - i);
        }
        if (space == 6) {
            space = 0;
        }
        getData();

        gdDate.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {
                //判断是否已经签到 从服务器获取签到信息
                //模拟从本地数据库获取信息

            }
        });
    }

    void getData() {
        list.clear();
        //此处是用处：每个月1号如果不是周一的话，若其假设其为周三，就用2个元素占下集合中的前两位，让1号对应到相应周数。
        for (int i = 0; i <= space; i++) {
            list.add(1 + i + "");
        }
        dayMaxNum = getCurrentMonthDay();
        for (int i = 0; i < dayMaxNum; i++) {
            list.add(i + 1 + "");
        }
        gdDate.setSelector(new ColorDrawable(Color.TRANSPARENT));
        gdDate.setAdapter(new getDayNumAdapter(MyApplication.getContent()));
    }

    public boolean checkTodauSign() {
        Calendar calendar = dateFormat.getCalendar();
        calendar.setTime(new Date());
        if (sinalist != null) {
            return sinalist.contains(calendar.get(Calendar.DAY_OF_MONTH));
        }
        return false;
    }


    private ArrayList<SignBean> sign;

    public void setSign(ArrayList<SignBean> sign) {
        this.sign = sign;
        sinalist.clear();
        Calendar calendar = dateFormat.getCalendar();
        for (int i = 0; i < sign.size(); i++) {
            try {
                Date date = new Date(Long.parseLong(sign.get(i).getCreateTime()));
                calendar.setTime(date);
                if (month == (calendar.get(Calendar.MONTH) + 1)) {
                    sinalist.add(calendar.get(Calendar.DAY_OF_MONTH));
                    map.put(calendar.get(Calendar.DAY_OF_MONTH), sign.get(i));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        gdDate.setAdapter(new getDayNumAdapter(MyApplication.getContent()));
    }

    class getDayNumAdapter extends BaseAdapter {
        Context c;

        public getDayNumAdapter(Context c) {
            this.c = c;
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View v = LinearLayout.inflate(c, R.layout.date_mb, null);
            TextView txtWeek = (TextView) v.findViewById(R.id.txtWeekDateMB);
            TextView txtDay = (TextView) v.findViewById(R.id.txtDayDateMB);
            TextView tv_point = (TextView) v.findViewById(R.id.tv_point);
            ImageView ivtDay = (ImageView) v.findViewById(R.id.ivtDayDateMB);
            tv_point.setVisibility(View.GONE);
            switch (position) {
                case 0:
                    txtWeek.setText("日");
                    break;
                case 1:
                    txtWeek.setText("一");
                    break;
                case 2:
                    txtWeek.setText("二");
                    break;
                case 3:
                    txtWeek.setText("三");
                    break;
                case 4:
                    txtWeek.setText("四");
                    break;
                case 5:
                    txtWeek.setText("五");
                    break;
                case 6:
                    txtWeek.setText("六");
                    break;
            }
            if (position < 7) {
                txtWeek.setVisibility(View.VISIBLE);
            }


            if (position <= space) {
                return v;
            }
            int lstDay = Integer.parseInt(list.get(position));

            //标记当前日期
            if (day > lstDay) {
                txtDay.setText(list.get(position).toString());
                txtDay.setTextColor(Color.parseColor("#caab76"));
                txtDay.setTypeface(Typeface.DEFAULT_BOLD);
            } else
                txtDay.setTextColor(Color.parseColor("#999999"));
            txtDay.setText(list.get(position).toString());
            if (sign != null) {
                if (sinalist.contains(Integer.parseInt(list.get(position)))) {
                    txtDay.setText(list.get(position).toString());
                    txtDay.setTextColor(Color.parseColor("#caab76"));
                    txtDay.setTypeface(Typeface.DEFAULT_BOLD);
                    ivtDay.setVisibility(View.VISIBLE);
                    tv_point.setVisibility(View.VISIBLE);
                    SignBean signBean = map.get(Integer.parseInt(list.get(position)));
                    tv_point.setText("+" + signBean.getSignIntegral());
                } else {
                    ivtDay.setVisibility(View.GONE);
                }
            }

            return v;
        }

    }

    public String getMonth() {
        return month + "月";
    }

    //获取当月的 天数
    public int getCurrentMonthDay() {
        Calendar a = Calendar.getInstance();
        a.set(Calendar.DATE, 1);
        a.roll(Calendar.DATE, -1);
        int maxDate = a.get(Calendar.DATE);
        return maxDate;
    }
}