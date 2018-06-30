package com.risenb.thousandnight.network;

import android.text.TextUtils;

import com.alibaba.fastjson.JSONObject;
import com.risenb.expand.m;
import com.risenb.expand.network.response.RawResponseHandler;
import com.risenb.thousandnight.MyApplication;
import com.risenb.thousandnight.R;
import com.risenb.thousandnight.beans.AlbumBean;
import com.risenb.thousandnight.beans.BannerBean;
import com.risenb.thousandnight.beans.BaseBean;
import com.risenb.thousandnight.beans.CodeBean;
import com.risenb.thousandnight.beans.CommentBean;
import com.risenb.thousandnight.beans.MomentBean;
import com.risenb.thousandnight.beans.NewsBean;
import com.risenb.thousandnight.beans.User;
import com.risenb.thousandnight.beans.UserBean;
import com.risenb.thousandnight.beans.UserCenterBean;
import com.risenb.thousandnight.utils.JsonFormatUtils;


import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * ================================================
 * 作    者：tongxiaoyun
 * 版    本：1.0
 * 创建日期：2018/4/4
 * 描    述：
 * 修订历史：
 * ================================================
 */
public class NetworkUtils {
    private static NetworkUtils networkUtils;
    protected MyApplication application;

    public static NetworkUtils getNetworkUtils() {
        if (networkUtils == null) {
            networkUtils = new NetworkUtils();
        }
        return networkUtils;
    }

    public void setApplication(MyApplication application) {
        this.application = application;
    }

    public String getUrl(int id) {
        return application.getResources().getString(R.string.service_host_address).concat(application.getString(id));
    }

    /**
     * 2.1.1.	获取验证码
     * mobile       手机号     是       string      无
     * type         类型      是       string      无       1:注册 2:找回密码 3：更换手机号 4：绑定手机
     */
    public void getCode(String mobile, String type, final HttpBack<CodeBean> httpBack) {
        String url = getUrl(R.string.getCode);
        Map<String, String> params = getReqParams();
        params.put("mobile", mobile);
        params.put("type", type);
        m.getInstance().getNetUtils().post().url(url).params(params).enqueue(new RawResponseHandler() {
            @Override
            public void onSuccess(int statusCode, String response) {
                BaseBean baseBean = JSONObject.parseObject(response, BaseBean.class);
                new JsonFormatUtils().format(baseBean, httpBack, CodeBean.class);
            }

            @Override
            public void onFailure(int statusCode, String error_msg) {
                httpBack.onFailure(String.valueOf(statusCode), error_msg);
            }
        });

    }

    /**
     * 2.1.2.	        注册
     * type             登录方式    是       string         无       1：手机 2：微信 3：QQ
     * mobile           手机号      否       string         无       type为1时必填
     * password 密码       否       string         无      type为1时必填
     * validCode 手机验证码  否       string        无       type为1时必填
     * wechatAuthorize     微信授权信息      否       string      无  type为2时必填
     * qqAuthorize         qq授权信息       否       string      无   type为3时必填
     * thumb           头像地址             否       string      无   第三方授权时获取
     */
    public void register(String type, String mobile, String password, String validCode, String wechatAuthorize, String qqAuthorize, String thumb, final HttpBack<UserBean> httpBack) {
        String url = getUrl(R.string.register);
        Map<String, String> params = getReqParams();
        params.put("type", type);
        params.put("mobile", mobile);
        params.put("password", password);
        params.put("validCode", validCode);
        params.put("wechatAuthorize", wechatAuthorize);
        params.put("qqAuthorize", qqAuthorize);
        params.put("thumb", thumb);
        m.getInstance().getNetUtils().post().url(url).params(params).enqueue(new RawResponseHandler() {
            @Override
            public void onSuccess(int statusCode, String response) {
                BaseBean baseBean = JSONObject.parseObject(response, BaseBean.class);
                new JsonFormatUtils().format(baseBean, httpBack, UserBean.class);
            }

            @Override
            public void onFailure(int statusCode, String error_msg) {
                httpBack.onFailure(String.valueOf(statusCode), error_msg);
            }
        });

    }

    /**
     * 2.1.3.	登录
     * type             登录方式    是       string         无       1：手机 2：微信 3：QQ
     * mobile           手机号      否       string         无       type为1时必填
     * password 密码       否       string         无      type为1时必填
     * wechatAuthorize     微信授权信息      否       string      无  type为2时必填
     * qqAuthorize         qq授权信息       否       string      无   type为3时必填
     * thumb           头像地址             否       string      无   第三方授权时获取
     */
    public void login(String type, String mobile, String password, String wechatAuthorize, String qqAuthorize, String thumb, final HttpBack<UserBean> httpBack) {
        String url = getUrl(R.string.login);
        Map<String, String> params = getReqParams();
        params.put("type", type);
        params.put("mobile", mobile);
        params.put("password", password);
        params.put("wechatAuthorize", wechatAuthorize);
        params.put("qqAuthorize", qqAuthorize);
        params.put("thumb", thumb);
        m.getInstance().getNetUtils().post().url(url).params(params).enqueue(new RawResponseHandler() {
            @Override
            public void onSuccess(int statusCode, String response) {
                BaseBean baseBean = JSONObject.parseObject(response, BaseBean.class);
                new JsonFormatUtils().format(baseBean, httpBack, UserBean.class);
            }

            @Override
            public void onFailure(int statusCode, String error_msg) {
                httpBack.onFailure(String.valueOf(statusCode), error_msg);
            }
        });

    }

    /**
     * 2.1.4.	找回登录密码（通过手机号验证码）
     * mobile           手机号         是           string      无
     * validCode        验证码         是           string      无
     * newPwdOne        新密码         是           string      无
     * newPwdTwo        新密码         是           string      无
     */
    public void findPwd(String mobile, String validCode, String newPwdOne, String newPwdTwo, final HttpBack<Object> httpBack) {
        String url = getUrl(R.string.findPwd);
        Map<String, String> params = getReqParams();
        params.put("mobile", mobile);
        params.put("validCode", validCode);
        params.put("newPwdOne", newPwdOne);
        params.put("newPwdTwo", newPwdTwo);
        m.getInstance().getNetUtils().post().url(url).params(params).enqueue(new RawResponseHandler() {
            @Override
            public void onSuccess(int statusCode, String response) {
                BaseBean baseBean = JSONObject.parseObject(response, BaseBean.class);
                new JsonFormatUtils().format(baseBean, httpBack, Object.class);
            }

            @Override
            public void onFailure(int statusCode, String error_msg) {
                httpBack.onFailure(String.valueOf(statusCode), error_msg);
            }
        });

    }


    /**
     * 2.2.1.	我的
     */
    public void home(final HttpBack<User> httpBack) {
        String url = getUrl(R.string.home);
        Map<String, String> params = getReqParams();
        params.put("c", application.getC());
        m.getInstance().getNetUtils().post().url(url).params(params).enqueue(new RawResponseHandler() {
            @Override
            public void onSuccess(int statusCode, String response) {
                BaseBean baseBean = JSONObject.parseObject(response, BaseBean.class);
                new JsonFormatUtils().format(baseBean, httpBack, User.class);
            }

            @Override
            public void onFailure(int statusCode, String error_msg) {
                httpBack.onFailure(String.valueOf(statusCode), error_msg);
            }
        });

    }


    /**
     * 2.2.2.  个人主页
     * userId       查看的用户id     是       string      无
     */
    public void index(String userId, final HttpBack<UserCenterBean> httpBack) {
        String url = getUrl(R.string.index);
        Map<String, String> params = getReqParams();
        params.put("c", application.getC());
        params.put("userId", userId);
        m.getInstance().getNetUtils().post().url(url).params(params).enqueue(new RawResponseHandler() {
            @Override
            public void onSuccess(int statusCode, String response) {
                BaseBean baseBean = JSONObject.parseObject(response, BaseBean.class);
                new JsonFormatUtils().format(baseBean, httpBack, UserCenterBean.class);
            }

            @Override
            public void onFailure(int statusCode, String error_msg) {
                httpBack.onFailure(String.valueOf(statusCode), error_msg);
            }
        });

    }


    /**
     * 2.2.3.  个人主页
     * c            用户登录标识          是           string          无
     * thumbTemp    头像                 否           二进制           无
     * nickName     昵称                 否           string          无
     * birthday     生日                 否           string          无    格式 yyyy-MM-dd
     * gender       性别                 否           string          无    1：男 2：女
     * provinceId   省id                 否           string          无
     * cityId       市id                 否           string          无
     * districtId   区域id               否           string          无
     * sign         签名                 否           string          无
     * classLng     上课经度              否           string          无
     * classLat     上课所在维度          否           string          无
     * classAddress 上课地址              否           string          无
     * introduce    介绍                 否           string          无
     * lastLng      最后所在经度          否           string           无
     * lastLat      最后所在维度          否           string          无
     */
    public void editInfo(File thumbTemp, String nickName, String birthday, String gender, String provinceId, String cityId, String districtId, String sign,
                         String classLng, String classLat, String classAddress, String introduce, String lastLng, String lastLat, final HttpBack<Object> httpBack) {
        String url = getUrl(R.string.editInfo);
        Map<String, String> params = getReqParams();
        params.put("c", application.getC());
        params.put("nickName", nickName);
        params.put("birthday", birthday);
        params.put("gender", gender);
        params.put("provinceId", provinceId);
        params.put("cityId", cityId);
        params.put("districtId", districtId);
        params.put("sign", sign);
        params.put("classLng", classLng);
        params.put("classLat", classLat);
        params.put("classAddress", classAddress);
        params.put("introduce", introduce);
        params.put("lastLng", lastLng);
        params.put("lastLat", lastLat);
        m.getInstance().getNetUtils().upload().url(url).params(params).addFile("thumbTemp", thumbTemp).enqueue(new RawResponseHandler() {
            @Override
            public void onSuccess(int statusCode, String response) {
                BaseBean baseBean = JSONObject.parseObject(response, BaseBean.class);
                new JsonFormatUtils().format(baseBean, httpBack, Object.class);
            }

            @Override
            public void onFailure(int statusCode, String error_msg) {
                httpBack.onFailure(String.valueOf(statusCode), error_msg);
            }
        });

    }


    /**
     * 2.2.4. 修改登录密码（通过旧密码）
     * oldPwd         旧密码         是           string          无
     * newPwdOne      新密码         是           string          无
     * newPwdTwo      新密码         是           string          无
     */
    public void changePwd(String oldPwd, String newPwdOne, String newPwdTwo, final HttpBack<Object> httpBack) {
        String url = getUrl(R.string.changePwd);
        Map<String, String> params = getReqParams();
        params.put("c", application.getC());
        params.put("oldPwd", oldPwd);
        params.put("newPwdOne", newPwdOne);
        params.put("newPwdTwo", newPwdTwo);
        m.getInstance().getNetUtils().post().url(url).params(params).enqueue(new RawResponseHandler() {
            @Override
            public void onSuccess(int statusCode, String response) {
                BaseBean baseBean = JSONObject.parseObject(response, BaseBean.class);
                new JsonFormatUtils().format(baseBean, httpBack, Object.class);
            }

            @Override
            public void onFailure(int statusCode, String error_msg) {
                httpBack.onFailure(String.valueOf(statusCode), error_msg);
            }
        });

    }

    /**
     * 2.2.5.	设置支付密码获取验证码
     */
    public void getPayCode(final HttpBack<CodeBean> httpBack) {
        String url = getUrl(R.string.getPayCode);
        Map<String, String> params = getReqParams();
        params.put("c", application.getC());
        m.getInstance().getNetUtils().post().url(url).params(params).enqueue(new RawResponseHandler() {
            @Override
            public void onSuccess(int statusCode, String response) {
                BaseBean baseBean = JSONObject.parseObject(response, BaseBean.class);
                new JsonFormatUtils().format(baseBean, httpBack, CodeBean.class);
            }

            @Override
            public void onFailure(int statusCode, String error_msg) {
                httpBack.onFailure(String.valueOf(statusCode), error_msg);
            }
        });

    }

    /**
     * 2.2.6.	设置支付密码
     * validCode	验证码	  是	   string	无
     * payPpwd	    支付密码	  是	   string	无
     */
    public void changePay(String validCode, String payPpwd, final HttpBack<Object> httpBack) {
        String url = getUrl(R.string.changePay);
        Map<String, String> params = getReqParams();
        params.put("c", application.getC());
        params.put("validCode", validCode);
        params.put("payPpwd", payPpwd);
        m.getInstance().getNetUtils().post().url(url).params(params).enqueue(new RawResponseHandler() {
            @Override
            public void onSuccess(int statusCode, String response) {
                BaseBean baseBean = JSONObject.parseObject(response, BaseBean.class);
                new JsonFormatUtils().format(baseBean, httpBack, Object.class);
            }

            @Override
            public void onFailure(int statusCode, String error_msg) {
                httpBack.onFailure(String.valueOf(statusCode), error_msg);
            }
        });

    }


    /**
     * 2.3.1. 动态列表
     * targetId           要查看的用户id            否           string            无
     * type               类型                     否           string            1           1：热门 2：关注 3：附近（targetId有值时，此参数无效）
     * lat                当前用户所在的维度         否           double            39.914153
     * lng                当前用户所在的经度         否           double            116.404062
     * pageNo             页码                     否           int               1
     * pageSize           每页显示条数              否           int               15
     */
    public void momentList(String targetId, String type, String lat, String lng, String pageNo, String pageSize, final HttpBack<MomentBean> httpBack) {
        String url = getUrl(R.string.momentList);
        Map<String, String> params = getReqParams();
        params.put("c", application.getC());
        params.put("targetId", targetId);
        params.put("type", type);
        params.put("lat", lat);
        params.put("lng", lng);
        params.put("pageNo", pageNo);
        params.put("pageSize", pageSize);
        m.getInstance().getNetUtils().post().url(url).params(params).enqueue(new RawResponseHandler() {
            @Override
            public void onSuccess(int statusCode, String response) {
                BaseBean baseBean = JSONObject.parseObject(response, BaseBean.class);
                new JsonFormatUtils().format(baseBean, httpBack, MomentBean.class);
            }

            @Override
            public void onFailure(int statusCode, String error_msg) {
                httpBack.onFailure(String.valueOf(statusCode), error_msg);
            }
        });

    }


    /**
     * 2.3.2.新增动态
     * content          内容          否           string          无
     * mediaTemp        图片          否           二进制           无         content与mediaTemp最少存在一个
     * authorty         权限          否           int             1          1:公开 2：私密 3：我关注的 4：关注我的
     * lat              维度         否            double
     * lng              经度         否            double
     */
    public void momentAdd(String content, String authorty, String lat, String lng, File mediaTemp, final HttpBack<Object> httpBack) {
        String url = getUrl(R.string.momentAdd);
        Map<String, String> params = getReqParams();
        params.put("content", content);
        params.put("authorty", authorty);
        params.put("lat", lat);
        params.put("lng", lng);
        m.getInstance().getNetUtils().upload().url(url).params(params).addFile("mediaTemp", mediaTemp).enqueue(new RawResponseHandler() {
            @Override
            public void onSuccess(int statusCode, String response) {
                BaseBean baseBean = JSONObject.parseObject(response, BaseBean.class);
                new JsonFormatUtils().format(baseBean, httpBack, Object.class);
            }

            @Override
            public void onFailure(int statusCode, String error_msg) {
                httpBack.onFailure(String.valueOf(statusCode), error_msg);
            }
        });

    }


    /**
     * 2.3.3.  删除动态
     * momentId         动态id            是           string          无
     */
    public void momentDel(String momentId, final HttpBack<Object> httpBack) {
        String url = getUrl(R.string.momentDel);
        Map<String, String> params = getReqParams();
        params.put("momentId", momentId);
        m.getInstance().getNetUtils().post().url(url).params(params).enqueue(new RawResponseHandler() {
            @Override
            public void onSuccess(int statusCode, String response) {
                BaseBean baseBean = JSONObject.parseObject(response, BaseBean.class);
                new JsonFormatUtils().format(baseBean, httpBack, Object.class);
            }

            @Override
            public void onFailure(int statusCode, String error_msg) {
                httpBack.onFailure(String.valueOf(statusCode), error_msg);
            }
        });

    }

    /**
     * 2.3.4.  动态详情
     * momentId         动态id            是           string          无
     */
    public void momentDetail(String momentId, final HttpBack<MomentBean> httpBack) {
        String url = getUrl(R.string.momentDetail);
        Map<String, String> params = getReqParams();
        params.put("momentId", momentId);
        m.getInstance().getNetUtils().post().url(url).params(params).enqueue(new RawResponseHandler() {
            @Override
            public void onSuccess(int statusCode, String response) {
                BaseBean baseBean = JSONObject.parseObject(response, BaseBean.class);
                new JsonFormatUtils().format(baseBean, httpBack, MomentBean.class);
            }

            @Override
            public void onFailure(int statusCode, String error_msg) {
                httpBack.onFailure(String.valueOf(statusCode), error_msg);
            }
        });

    }

    /**
     * 2.3.5.  点赞取消点赞
     * momentId         动态id            是           string          无
     */
    public void momentLike(String momentId, final HttpBack<Object> httpBack) {
        String url = getUrl(R.string.momentLike);
        Map<String, String> params = getReqParams();
        params.put("momentId", momentId);
        m.getInstance().getNetUtils().post().url(url).params(params).enqueue(new RawResponseHandler() {
            @Override
            public void onSuccess(int statusCode, String response) {
                BaseBean baseBean = JSONObject.parseObject(response, BaseBean.class);
                new JsonFormatUtils().format(baseBean, httpBack, Object.class);
            }

            @Override
            public void onFailure(int statusCode, String error_msg) {
                httpBack.onFailure(String.valueOf(statusCode), error_msg);
            }
        });

    }

    /**
     * 2.3.6.  点赞取消点赞
     * momentId         动态id            是           string          无
     * parentId         父级评论id         否           string          无    momentId与parentId必须存在一个，当传momentId时为一级评论，当传parentId时为二级评论，两个都传优先二级评论
     * content          内容               是          string          无
     */
    public void commentMoment(String momentId, String parentId, String content, final HttpBack<Object> httpBack) {
        String url = getUrl(R.string.commentMoment);
        Map<String, String> params = getReqParams();
        params.put("momentId", momentId);
        params.put("parentId", parentId);
        params.put("content", content);
        m.getInstance().getNetUtils().post().url(url).params(params).enqueue(new RawResponseHandler() {
            @Override
            public void onSuccess(int statusCode, String response) {
                BaseBean baseBean = JSONObject.parseObject(response, BaseBean.class);
                new JsonFormatUtils().format(baseBean, httpBack, Object.class);
            }

            @Override
            public void onFailure(int statusCode, String error_msg) {
                httpBack.onFailure(String.valueOf(statusCode), error_msg);
            }
        });

    }

    /**
     * 2.3.7.  删除评论(评论人和动态所有人可删除)
     * momentId         动态id            是           string          无
     */
    public void commentDelMoment(String momentId, final HttpBack<Object> httpBack) {
        String url = getUrl(R.string.commentDelMoment);
        Map<String, String> params = getReqParams();
        params.put("momentId", momentId);
        m.getInstance().getNetUtils().post().url(url).params(params).enqueue(new RawResponseHandler() {
            @Override
            public void onSuccess(int statusCode, String response) {
                BaseBean baseBean = JSONObject.parseObject(response, BaseBean.class);
                new JsonFormatUtils().format(baseBean, httpBack, Object.class);
            }

            @Override
            public void onFailure(int statusCode, String error_msg) {
                httpBack.onFailure(String.valueOf(statusCode), error_msg);
            }
        });

    }


    /**
     * 2.3.8. 评论详情
     * momentId         动态id            是           string          无
     * pageNo           页码              否           int             1
     * pageSize         每页显示条数       否            int           15
     */
    public void commentMomentList(String momentId, String pageNo, String pageSize, final HttpBack<CommentBean> httpBack) {
        String url = getUrl(R.string.commentMomentList);
        Map<String, String> params = getReqParams();
        params.put("momentId", momentId);
        params.put("pageNo", pageNo);
        params.put("pageSize", pageSize);
        m.getInstance().getNetUtils().post().url(url).params(params).enqueue(new RawResponseHandler() {
            @Override
            public void onSuccess(int statusCode, String response) {
                BaseBean baseBean = JSONObject.parseObject(response, BaseBean.class);
                new JsonFormatUtils().format(baseBean, httpBack, CommentBean.class);
            }

            @Override
            public void onFailure(int statusCode, String error_msg) {
                httpBack.onFailure(String.valueOf(statusCode), error_msg);
            }
        });

    }


    /**
     * 2.4.1.	新闻列表
     * type         类型          否           int         无
     * keyWord      关键字         否          string        无
     * pageNo           页码              否           int             1
     * pageSize         每页显示条数       否            int           15
     */
    public void newsList(String type, String keyWord, String pageNo, String pageSize, final HttpBack<NewsBean> httpBack) {
        String url = getUrl(R.string.newsList);
        Map<String, String> params = getReqParams();
        params.put("c", application.getC());
        params.put("type", type);
        params.put("keyWord", keyWord);
        params.put("pageNo", pageNo);
        params.put("pageSize", pageSize);
        m.getInstance().getNetUtils().post().url(url).params(params).enqueue(new RawResponseHandler() {
            @Override
            public void onSuccess(int statusCode, String response) {
                BaseBean baseBean = JSONObject.parseObject(response, BaseBean.class);
                new JsonFormatUtils().format(baseBean, httpBack, NewsBean.class);
            }

            @Override
            public void onFailure(int statusCode, String error_msg) {
                httpBack.onFailure(String.valueOf(statusCode), error_msg);
            }
        });

    }


    /**
     * 2.4.2.	新闻详情
     * newsId       新闻id        是       int     无
     */
    public void newsDetail(String newsId, final HttpBack<NewsBean> httpBack) {
        String url = getUrl(R.string.newsDetail);
        Map<String, String> params = getReqParams();
        params.put("newsId", newsId);
        m.getInstance().getNetUtils().post().url(url).params(params).enqueue(new RawResponseHandler() {
            @Override
            public void onSuccess(int statusCode, String response) {
                BaseBean baseBean = JSONObject.parseObject(response, BaseBean.class);
                new JsonFormatUtils().format(baseBean, httpBack, NewsBean.class);
            }

            @Override
            public void onFailure(int statusCode, String error_msg) {
                httpBack.onFailure(String.valueOf(statusCode), error_msg);
            }
        });

    }


    /**
     * 2.4.3.	新闻详情 点赞／取消点赞
     * newsId       新闻id        是       int     无
     */
    public void newsLike(String newsId, final HttpBack<Object> httpBack) {
        String url = getUrl(R.string.newsLike);
        Map<String, String> params = getReqParams();
        params.put("newsId", newsId);
        m.getInstance().getNetUtils().post().url(url).params(params).enqueue(new RawResponseHandler() {
            @Override
            public void onSuccess(int statusCode, String response) {
                BaseBean baseBean = JSONObject.parseObject(response, BaseBean.class);
                new JsonFormatUtils().format(baseBean, httpBack, Object.class);
            }

            @Override
            public void onFailure(int statusCode, String error_msg) {
                httpBack.onFailure(String.valueOf(statusCode), error_msg);
            }
        });

    }

    /**
     * 2.4.11.	分页获取相册列表
     * pageNo           页码              否           int             1
     * pageSize         每页显示条数       否            int           15
     */
    public void albumList(String pageNo, String pageSize, final HttpBack<AlbumBean> httpBack) {
        String url = getUrl(R.string.albumList);
        Map<String, String> params = getReqParams();
        params.put("c", application.getC());
        params.put("pageNo", pageNo);
        params.put("pageSize", pageSize);
        m.getInstance().getNetUtils().post().url(url).params(params).enqueue(new RawResponseHandler() {
            @Override
            public void onSuccess(int statusCode, String response) {
                BaseBean baseBean = JSONObject.parseObject(response, BaseBean.class);
                new JsonFormatUtils().format(baseBean, httpBack, AlbumBean.class);
            }

            @Override
            public void onFailure(int statusCode, String error_msg) {
                httpBack.onFailure(String.valueOf(statusCode), error_msg);
            }
        });

    }

    /**
     * 2.5.1.	获取轮播图
     * type	    类型	        是	    int	   无	  1：首页 2：广场 3：新闻
     */
    public void banner(String type, final HttpBack<BannerBean> httpBack) {
        String url = getUrl(R.string.list);
        Map<String, String> params = getReqParams();
        params.put("c", application.getC());
        params.put("type", type);
        m.getInstance().getNetUtils().post().url(url).params(params).enqueue(new RawResponseHandler() {
            @Override
            public void onSuccess(int statusCode, String response) {
                BaseBean baseBean = JSONObject.parseObject(response, BaseBean.class);
                new JsonFormatUtils().format(baseBean, httpBack, BannerBean.class);
            }

            @Override
            public void onFailure(int statusCode, String error_msg) {
                httpBack.onFailure(String.valueOf(statusCode), error_msg);
            }
        });

    }


    private HashMap getReqParams() {
        Map<String, String> params = new HashMap<>();
        if (!TextUtils.isEmpty(application.getC())) {
            params.put("token", application.getC());

        }
        return (HashMap) params;
    }


}


