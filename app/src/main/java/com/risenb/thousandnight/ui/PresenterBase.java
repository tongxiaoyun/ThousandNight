package com.risenb.thousandnight.ui;

import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;

import com.risenb.expand.utils.AppProgressDialog;
import com.risenb.thousandnight.MyApplication;
import com.risenb.thousandnight.R;


/**
 * Presenter 基类
 * 
 * @author Administrator
 * 
 */
public abstract class PresenterBase
{
    protected FragmentActivity activity;
    protected MyApplication application;
    private AppProgressDialog progressDialog;

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 1) {

            }
        }
    };

    public FragmentActivity getActivity()
    {
        return activity;
    }

    public void setActivity(FragmentActivity activity)
    {
        this.activity = activity;
        application = (MyApplication) activity.getApplication();
    }

    protected void makeText(final String content)
    {
        handler.post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getActivity(), content, Toast.LENGTH_SHORT).show();
            }
        });
    }

    protected String getUrl(int id)
    {
        return getActivity().getResources().getString(R.string.service_host_address).concat(getActivity().getString(id));
    }

    public synchronized void showProgressDialog()
    {
        if (progressDialog == null)
        {
            progressDialog = new AppProgressDialog();
        }
        progressDialog.show(activity);
    }

    public void dismissProgressDialog()
    {
        if (progressDialog != null && progressDialog.isShowing())
        {
            progressDialog.dismissDialog();
        }
    }

    public synchronized AppProgressDialog getProgressDialog()
    {
        if (progressDialog == null)
        {
            progressDialog = new AppProgressDialog();
        }
        return progressDialog;
    }

    public synchronized void setProgress(String context )
    {
        if (progressDialog != null)
        {
            progressDialog.setProgress(context);
        }
    }
}
