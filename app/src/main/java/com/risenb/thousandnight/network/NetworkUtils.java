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
import com.risenb.thousandnight.beans.ClassBean;
import com.risenb.thousandnight.beans.CodeBean;
import com.risenb.thousandnight.beans.CommentBean;
import com.risenb.thousandnight.beans.CourseDetialBean;
import com.risenb.thousandnight.beans.CourseListBean;
import com.risenb.thousandnight.beans.DanceHallBean;
import com.risenb.thousandnight.beans.HomeHotVideoBean;
import com.risenb.thousandnight.beans.HomeSignBean;
import com.risenb.thousandnight.beans.MomentBean;
import com.risenb.thousandnight.beans.MusicSheetBean;
import com.risenb.thousandnight.beans.NewsBean;
import com.risenb.thousandnight.beans.ParamBean;
import com.risenb.thousandnight.beans.PositonBean;
import com.risenb.thousandnight.beans.ProviceBean;
import com.risenb.thousandnight.beans.SignBean;
import com.risenb.thousandnight.beans.User;
import com.risenb.thousandnight.beans.UserBean;
import com.risenb.thousandnight.beans.UserCenterBean;
import com.risenb.thousandnight.beans.VideoListBean;
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


    /**
     * 2.1.1.	查询用户签到信息
     */
    public void signInfo(final HttpBack<HomeSignBean> httpBack) {
        String url = getUrl(R.string.signInfo);
        Map<String, String> params = getReqParams();
        m.getInstance().getNetUtils().post().url(url).params(params).enqueue(new RawResponseHandler() {
            @Override
            public void onSuccess(int statusCode, String response) {
                BaseBean baseBean = JSONObject.parseObject(response, BaseBean.class);
                new JsonFormatUtils().format(baseBean, httpBack, HomeSignBean.class);
            }

            @Override
            public void onFailure(int statusCode, String error_msg) {
                httpBack.onFailure(String.valueOf(statusCode), error_msg);
            }
        });

    }

    /**
     * 2.1.2.	签到
     */
    public void sign(final HttpBack<Object> httpBack) {
        String url = getUrl(R.string.sign);
        Map<String, String> params = getReqParams();
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
     * 2.1.2.	签到
     */
    public void signRecord(String dateStr, final HttpBack<SignBean> httpBack) {
        String url = getUrl(R.string.signRecord);
        Map<String, String> params = getReqParams();
        params.put("dateStr", dateStr);
        m.getInstance().getNetUtils().post().url(url).params(params).enqueue(new RawResponseHandler() {
            @Override
            public void onSuccess(int statusCode, String response) {
                BaseBean baseBean = JSONObject.parseObject(response, BaseBean.class);
                new JsonFormatUtils().format(baseBean, httpBack, SignBean.class);
            }

            @Override
            public void onFailure(int statusCode, String error_msg) {
                httpBack.onFailure(String.valueOf(statusCode), error_msg);
            }
        });

    }


    /**
     * 2.3.1.	歌曲表单
     * pageNo       页码      否（默认1）      Int
     * pageSize     每页条数    否（默认15）     Int
     * isRecommend  是否推荐（   0：不推荐 1：推荐） 否   int 不传为全部
     */
    public void musicSheetList(String pageNo, String pageSize, String isRecommend, final HttpBack<MusicSheetBean> httpBack) {
        String url = getUrl(R.string.musicSheetList);
        Map<String, String> params = getReqParams();
        if (!TextUtils.isEmpty(pageNo))
            params.put("pageNo", pageNo);
        if (!TextUtils.isEmpty(pageSize))
            params.put("pageSize", pageSize);
        if (!TextUtils.isEmpty(isRecommend))
            params.put("isRecommend", isRecommend);
        m.getInstance().getNetUtils().post().url(url).params(params).enqueue(new RawResponseHandler() {
            @Override
            public void onSuccess(int statusCode, String response) {
                BaseBean baseBean = JSONObject.parseObject(response, BaseBean.class);
                new JsonFormatUtils().format(baseBean, httpBack, MusicSheetBean.class);
            }

            @Override
            public void onFailure(int statusCode, String error_msg) {
                httpBack.onFailure(String.valueOf(statusCode), error_msg);
            }
        });

    }

    /**
     * 2.1.4.	精选课程列表
     * pageNo       页码      否（默认1）      Int
     * pageSize     每页条数    否（默认15）     Int
     */
    public void selectedList(String pageNo, String pageSize, final HttpBack<CourseListBean> httpBack) {
        String url = getUrl(R.string.selectedList);
        Map<String, String> params = getReqParams();
        if (!TextUtils.isEmpty(pageNo))
            params.put("pageNo", pageNo);
        if (!TextUtils.isEmpty(pageSize))
            params.put("pageSize", pageSize);
        m.getInstance().getNetUtils().post().url(url).params(params).enqueue(new RawResponseHandler() {
            @Override
            public void onSuccess(int statusCode, String response) {
                BaseBean baseBean = JSONObject.parseObject(response, BaseBean.class);
                new JsonFormatUtils().format(baseBean, httpBack, CourseListBean.class);
            }

            @Override
            public void onFailure(int statusCode, String error_msg) {
                httpBack.onFailure(String.valueOf(statusCode), error_msg);
            }
        });

    }


    /**
     * 2.1.4.	精选课程列表
     * pageNo       页码      否（默认1）      Int
     * pageSize     每页条数    否（默认15）     Int
     */
    public void courseList(String paramId, String teacherId, String orderField, String orderDirection, String pageNo, String pageSize, final HttpBack<CourseListBean> httpBack) {
        String url = getUrl(R.string.courseList);
        Map<String, String> params = getReqParams();
        if (!TextUtils.isEmpty(paramId))
            params.put("paramId", paramId);

        if (!TextUtils.isEmpty(teacherId))
            params.put("teacherId", teacherId);

        if (!TextUtils.isEmpty(orderField))
            params.put("orderField", orderField);

        if (!TextUtils.isEmpty(orderDirection))
            params.put("orderDirection", orderDirection);
        if (!TextUtils.isEmpty(pageNo))
            params.put("pageNo", pageNo);
        if (!TextUtils.isEmpty(pageSize))
            params.put("pageSize", pageSize);
        m.getInstance().getNetUtils().post().url(url).params(params).enqueue(new RawResponseHandler() {
            @Override
            public void onSuccess(int statusCode, String response) {
                BaseBean baseBean = JSONObject.parseObject(response, BaseBean.class);
                new JsonFormatUtils().format(baseBean, httpBack, CourseListBean.class);
            }

            @Override
            public void onFailure(int statusCode, String error_msg) {
                httpBack.onFailure(String.valueOf(statusCode), error_msg);
            }
        });

    }


    /**
     * 2.2.3.课程详情
     * courseId
     */
    public void courseDetail(String courseId, final HttpBack<CourseDetialBean> httpBack) {
        String url = getUrl(R.string.courseDetail);
        Map<String, String> params = getReqParams();
        params.put("courseId", courseId);
        m.getInstance().getNetUtils().post().url(url).params(params).enqueue(new RawResponseHandler() {
            @Override
            public void onSuccess(int statusCode, String response) {
                BaseBean baseBean = JSONObject.parseObject(response, BaseBean.class);
                new JsonFormatUtils().format(baseBean, httpBack, CourseDetialBean.class);
            }

            @Override
            public void onFailure(int statusCode, String error_msg) {
                httpBack.onFailure(String.valueOf(statusCode), error_msg);
            }
        });

    }


    /**
     * 2.4.4	视频评论列表
     * pageNo       页码                        否（默认1）          Int
     * pageSize     每页条数                     否（默认15）         Int
     * videoId	视频ID	是	long
     */
    public void courseCommentList(String pageNo, String pageSize, String courseId, final HttpBack<CommentBean> httpBack) {
        String url = getUrl(R.string.commentList);
        Map<String, String> params = getReqParams();
        params.put("pageNo", pageNo);
        params.put("pageSize", pageSize);
        params.put("courseId", courseId);
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
     * 2.7.1.	查询分类列表
     * type	分类（1：课程 2:音乐 7:视频）	是	int	无
     */
    public void classifyList(String type, final HttpBack<ClassBean> httpBack) {
        String url = getUrl(R.string.classifyList);
        Map<String, String> params = getReqParams();
        if (!TextUtils.isEmpty(type))
            params.put("type", type);
        m.getInstance().getNetUtils().post().url(url).params(params).enqueue(new RawResponseHandler() {
            @Override
            public void onSuccess(int statusCode, String response) {
                BaseBean baseBean = JSONObject.parseObject(response, BaseBean.class);
                new JsonFormatUtils().format(baseBean, httpBack, ClassBean.class);
            }

            @Override
            public void onFailure(int statusCode, String error_msg) {
                httpBack.onFailure(String.valueOf(statusCode), error_msg);
            }
        });

    }

    /**
     * 2.7.2.     查询条件接口
     * hierarchy	层级	是	int	无
     * type	类型（5：舞种 6：舞伴级别）	是	int
     */
    public void conditionList(String hierarchy, String type, final HttpBack<ParamBean> httpBack) {
        String url = getUrl(R.string.condition);
        Map<String, String> params = getReqParams();
        params.put("hierarchy", hierarchy);
        if (!TextUtils.isEmpty(type))
            params.put("type", type);
        m.getInstance().getNetUtils().post().url(url).params(params).enqueue(new RawResponseHandler() {
            @Override
            public void onSuccess(int statusCode, String response) {
                BaseBean baseBean = JSONObject.parseObject(response, BaseBean.class);
                new JsonFormatUtils().format(baseBean, httpBack, ParamBean.class);
            }

            @Override
            public void onFailure(int statusCode, String error_msg) {
                httpBack.onFailure(String.valueOf(statusCode), error_msg);
            }
        });

    }


    /**
     * 2.4.1.	视频列表
     * pageNo       页码                        否（默认1）          Int
     * pageSize     每页条数                     否（默认15）         Int
     * isHot        是否热播（0：否1：是）         否                  int         不传为全部
     * paramId      分类ID                       否                  Long          无
     * parentId     分类父ID                      否                Long            0
     * orderField   排序字段                       否                String(观看量：view_num 评论量：    comment_num     创建时间：   create_time )   默认创建时间
     * orderDirection   排序方向                   否                String(升 asc降 desc)默认降
     */
    public void videoList(String pageNo, String pageSize, String isHot, String paramId, String parentId, String orderField, String orderDirection, final HttpBack<HomeHotVideoBean> httpBack) {
        String url = getUrl(R.string.videoList);
        Map<String, String> params = getReqParams();
        params.put("pageNo", pageNo);
        params.put("pageSize", pageSize);
        params.put("isHot", isHot);
        if (!TextUtils.isEmpty(paramId))
            params.put("paramId", paramId);
        if (!TextUtils.isEmpty(parentId))
            params.put("parentId", parentId);
        if (!TextUtils.isEmpty(orderField))
            params.put("orderField", orderField);
        if (!TextUtils.isEmpty(orderDirection))
            params.put("orderDirection", orderDirection);
        m.getInstance().getNetUtils().post().url(url).params(params).enqueue(new RawResponseHandler() {
            @Override
            public void onSuccess(int statusCode, String response) {
                BaseBean baseBean = JSONObject.parseObject(response, BaseBean.class);
                new JsonFormatUtils().format(baseBean, httpBack, HomeHotVideoBean.class);
            }

            @Override
            public void onFailure(int statusCode, String error_msg) {
                httpBack.onFailure(String.valueOf(statusCode), error_msg);
            }
        });

    }

    /**
     * 2.4.1.	视频列表
     * pageNo       页码                        否（默认1）          Int
     * pageSize     每页条数                     否（默认15）         Int
     * isHot        是否热播（0：否1：是）         否                  int         不传为全部
     * paramId      分类ID                       否                  Long          无
     * parentId     分类父ID                      否                Long            0
     * orderField   排序字段                       否                String(观看量：view_num 评论量：    comment_num     创建时间：   create_time )   默认创建时间
     * orderDirection   排序方向                   否                String(升 asc降 desc)默认降
     */
    public void videoListHot(final HttpBack<HomeHotVideoBean> httpBack) {
        videoList("1", "6", "1", "", "", "", "", httpBack);
    }

    /**
     * 2.4.2   收藏/取消收藏 视频
     * videoId	视频ID	                            是	long
     * type	操作类型     0：取消收藏      1：收藏	    是	int
     */
    public void addOrCancleLikeVideo(String videoId, String type, final HttpBack<Object> httpBack) {
        String url = getUrl(R.string.video_addOrCancleLike);
        Map<String, String> params = getReqParams();
        params.put("c", application.getC());
        params.put("videoId", videoId);
        params.put("type", type);
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
     * 2.4.3   评论视频
     * videoId	视频ID	                            是	long
     * content	评论内容	是	String
     */
    public void addCommentVideo(String videoId, String content, final HttpBack<Object> httpBack) {
        String url = getUrl(R.string.video_addComment);
        Map<String, String> params = getReqParams();
        params.put("c", application.getC());
        params.put("videoId", videoId);
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
     * 2.4.4	视频评论列表
     * pageNo       页码                        否（默认1）          Int
     * pageSize     每页条数                     否（默认15）         Int
     * videoId	视频ID	是	long
     */
    public void videoCommentList(String pageNo, String pageSize, String videoId, final HttpBack<CommentBean> httpBack) {
        String url = getUrl(R.string.video_commentList);
        Map<String, String> params = getReqParams();
        params.put("pageNo", pageNo);
        params.put("pageSize", pageSize);
        params.put("videoId", videoId);
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
     * 2.5.1.	发布职位
     * positionName	职位名称	是	string
     * positionType	职位类型	是	int
     * typeName	职位类型名称	是	String
     * workYears	工作年限	是	int
     * yearsName	工作年限名称	是	string
     * positionGrade	职位等级	是	int
     * gradeName	职位等级名称	是	string
     * provinceId	省Id	是	int
     * provinceName	省名称	是	string
     * cityId	市ID	是	int
     * cityName	市名称	是	string
     * areaId	区ID	是	int
     * areaName	区名称	是	string
     * salaryType	薪资类型(1：范围 2：面议 )	是	int
     * salaryBegin	薪资起始值	否	int
     * salaryEnd	薪资结束值	否	int
     * positionDesc	职位描述	否	string
     */

    public void addPosition(String positionName, String positionType, String typeName, String workYears, String yearsName, String positionGrade, String gradeName, String provinceId, String provinceName,
                            String cityId, String cityName, String areaId, String areaName, String salaryType, String salaryBegin, String salaryEnd, String positionDesc, final HttpBack<Object> httpBack) {
        String url = getUrl(R.string.addPosition);
        Map<String, String> params = getReqParams();
        params.put("c", application.getC());
        params.put("positionName", positionName);
        params.put("positionType", positionType);
        params.put("typeName", typeName);
        params.put("workYears", workYears);
        params.put("yearsName", yearsName);
        params.put("positionGrade", positionGrade);
        params.put("gradeName", gradeName);
        params.put("provinceId", provinceId);
        params.put("provinceName", provinceName);
        params.put("cityId", cityId);
        params.put("cityName", cityName);
        params.put("areaId", areaId);
        params.put("areaName", areaName);
        params.put("salaryType", salaryType);
        if (!TextUtils.isEmpty(salaryBegin))
            params.put("salaryBegin", salaryBegin);
        if (!TextUtils.isEmpty(salaryEnd))
            params.put("salaryEnd", salaryEnd);
        if (!TextUtils.isEmpty(positionDesc))
            params.put("positionDesc", positionDesc);
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
     * 2.5.2.	职位投递
     * positionId	职位ID	是	string
     * deliveryInfo	投递信息	否	string
     * video	视频	否	视频文件
     */
    public void addPositoinDelivery(String positionId, String deliveryInfo, File video, final HttpBack<Object> httpBack) {
        String url = getUrl(R.string.addPositoinDelivery);
        Map<String, String> params = getReqParams();
        params.put("c", application.getC());
        params.put("positionId", positionId);
        if (!TextUtils.isEmpty(deliveryInfo))
            params.put("deliveryInfo", deliveryInfo);
        m.getInstance().getNetUtils().upload().url(url).params(params).addFile("video", video).enqueue(new RawResponseHandler() {
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
     * 2.5.3.	职位列表
     * provinceId	省ID	否	int
     * cityId	市ID	否	int
     * areaId	区ID	否	int
     * positionType	职位类型ID	否	Int
     * workYears	工作年限ID	否	int
     * positionGrade	职位等级ID	否	int
     * salaryType	薪资类型(1：范围 2：面议 )	否	int
     * salaryBegin	薪资起始值	否	int
     * salaryEnd	薪资结束值	否	int
     * pageNo	页码	否（默认1）	Int
     * pageSize	每页条数	否（默认15）	Int
     */
    public void positionList(String pageNo, String pageSize, String provinceId, String cityId, String areaId, String positionType, String workYears, String positionGrade, String salaryType,
                             String salaryBegin, String salaryEnd, final HttpBack<PositonBean> httpBack) {
        String url = getUrl(R.string.positionList);
        Map<String, String> params = getReqParams();
        params.put("pageNo", pageNo);
        params.put("pageSize", pageSize);
        if (!TextUtils.isEmpty(provinceId))
            params.put("provinceId", provinceId);
        if (!TextUtils.isEmpty(cityId))
            params.put("cityId", cityId);
        if (!TextUtils.isEmpty(areaId))
            params.put("areaId", areaId);
        if (!TextUtils.isEmpty(positionType))
            params.put("positionType", positionType);
        if (!TextUtils.isEmpty(workYears))
            params.put("workYears", workYears);
        if (!TextUtils.isEmpty(positionGrade))
            params.put("positionGrade", positionGrade);
        if (!TextUtils.isEmpty(salaryType))
            params.put("salaryType", salaryType);
        if (!TextUtils.isEmpty(salaryBegin))
            params.put("salaryBegin", salaryBegin);
        if (!TextUtils.isEmpty(salaryEnd))
            params.put("salaryEnd", salaryEnd);
        m.getInstance().getNetUtils().post().url(url).params(params).enqueue(new RawResponseHandler() {
            @Override
            public void onSuccess(int statusCode, String response) {
                BaseBean baseBean = JSONObject.parseObject(response, BaseBean.class);
                new JsonFormatUtils().format(baseBean, httpBack, PositonBean.class);
            }

            @Override
            public void onFailure(int statusCode, String error_msg) {
                httpBack.onFailure(String.valueOf(statusCode), error_msg);
            }
        });

    }

    /**
     * 2.5.4.	职位详情
     * positionId	职位id	是	int
     */
    public void positionDetail(String positionId, final HttpBack<PositonBean> httpBack) {
        String url = getUrl(R.string.positionDetail);
        Map<String, String> params = getReqParams();
        params.put("positionId", positionId);
        m.getInstance().getNetUtils().post().url(url).params(params).enqueue(new RawResponseHandler() {
            @Override
            public void onSuccess(int statusCode, String response) {
                BaseBean baseBean = JSONObject.parseObject(response, BaseBean.class);
                new JsonFormatUtils().format(baseBean, httpBack, PositonBean.class);
            }

            @Override
            public void onFailure(int statusCode, String error_msg) {
                httpBack.onFailure(String.valueOf(statusCode), error_msg);
            }
        });

    }

    /**
     * 2.6.1.	发布
     * dancePartnerType	舞伴类型(1:男 2：女 3：皆可)	是	int
     * peopleNum	人数	是	int
     * dancesFirst	舞种一级分类ID	是	int
     * dancesFirstName	舞种一级分类名称	是	string
     * dancesSecond	舞种二级分类ID	否	int
     * dancesSecondName	舞种二级分类名称	否	string
     * level	级别	是	int
     * levelName	级别名称	是	string
     * title	标题	是	string
     * explain	说明	是	string
     * provinceId	省ID	是	string
     * provinceName	省名称	是	string
     * longitude	经度	是	string
     * latitude	纬度	是	string
     * address	详细地址	是	string
     * beginTimeStr	开始日期	是	string	时间格式    2018-09-12 11
     * endTimeStr	结束日期	是	string	时间格式    2018-09-12 17
     */
    public void addFindDancer(String dancePartnerType, String peopleNum, String dancesFirst, String dancesFirstName, String dancesSecond, String dancesSecondName, String level, String levelName, String title,
                              String explain, String provinceId, String provinceName, String longitude, String latitude, String address, String beginTimeStr, String endTimeStr, final HttpBack<Object> httpBack) {
        String url = getUrl(R.string.addFindDancer);
        Map<String, String> params = getReqParams();
        params.put("c", application.getC());
        params.put("dancePartnerType", dancePartnerType);
        params.put("peopleNum", peopleNum);
        params.put("dancesFirst", dancesFirst);
        params.put("dancesFirstName", dancesFirstName);
        if (!TextUtils.isEmpty(dancesSecond))
            params.put("dancesSecond", dancesSecond);
        if (!TextUtils.isEmpty(dancesSecondName))
            params.put("dancesSecondName", dancesSecondName);
        params.put("level", level);
        params.put("levelName", levelName);
        params.put("title", title);
        params.put("explain", explain);
        params.put("provinceId", provinceId);
        params.put("provinceName", provinceName);
        params.put("longitude", longitude);
        params.put("latitude", latitude);
        params.put("address", address);
        params.put("beginTimeStr", beginTimeStr);
        params.put("endTimeStr", endTimeStr);
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
     * 2.6.2.	舞伴大厅列表
     * longitude	经度	否	String
     * latitude	纬度	否	string
     * provinceId	省ID	否	int
     * dancesFirst	舞种分类ID	否	long
     * dancePartnerType	性别	否	int
     * pageNo	页码	否（默认1）	Int
     * pageSize	每页条数	否（默认15）	Int
     */
    public void dancehallList(String pageNo, String pageSize, String longitude, String latitude, String provinceId, String dancesFirst, String dancePartnerType, final HttpBack<DanceHallBean> httpBack) {
        String url = getUrl(R.string.dancehallList);
        Map<String, String> params = getReqParams();
        params.put("pageNo", pageNo);
        params.put("pageSize", pageSize);
        if (!TextUtils.isEmpty(longitude))
            params.put("longitude", longitude);
        if (!TextUtils.isEmpty(latitude))
            params.put("latitude", latitude);
        if (!TextUtils.isEmpty(provinceId))
            params.put("provinceId", provinceId);
        if (!TextUtils.isEmpty(dancesFirst))
            params.put("dancesFirst", dancesFirst);
        if (!TextUtils.isEmpty(dancePartnerType))
            params.put("dancePartnerType", dancePartnerType);
        m.getInstance().getNetUtils().post().url(url).params(params).enqueue(new RawResponseHandler() {
            @Override
            public void onSuccess(int statusCode, String response) {
                BaseBean baseBean = JSONObject.parseObject(response, BaseBean.class);
                new JsonFormatUtils().format(baseBean, httpBack, DanceHallBean.class);
            }

            @Override
            public void onFailure(int statusCode, String error_msg) {
                httpBack.onFailure(String.valueOf(statusCode), error_msg);
            }
        });

    }

    /**
     * 2.6.3.    舞伴大厅详情
     * danceHallId	主键ID	是	long
     * longitude	经度	否	String
     * latitude	纬度	否	string
     */
    public void dancehallDetail(String danceHallId, String longitude, String latitude, final HttpBack<DanceHallBean> httpBack) {
        String url = getUrl(R.string.dancehallDetail);
        Map<String, String> params = getReqParams();
        params.put("danceHallId", danceHallId);
        if (!TextUtils.isEmpty(longitude))
            params.put("longitude", longitude);
        if (!TextUtils.isEmpty(latitude))
            params.put("latitude", latitude);
        m.getInstance().getNetUtils().post().url(url).params(params).enqueue(new RawResponseHandler() {
            @Override
            public void onSuccess(int statusCode, String response) {
                BaseBean baseBean = JSONObject.parseObject(response, BaseBean.class);
                new JsonFormatUtils().format(baseBean, httpBack, DanceHallBean.class);
            }

            @Override
            public void onFailure(int statusCode, String error_msg) {
                httpBack.onFailure(String.valueOf(statusCode), error_msg);
            }
        });

    }

    /**
     * 2.6.4.舞伴大厅评论
     * danceHallId	舞伴大厅ID	是	int
     * content	评论内容	是	string
     */
    public void addFindDancerComment(String danceHallId, String content, final HttpBack<Object> httpBack) {
        String url = getUrl(R.string.addFindDancerComment);
        Map<String, String> params = getReqParams();
        params.put("c", application.getC());
        params.put("danceHallId", danceHallId);
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
     * 2.6.5  舞伴大厅评论列表
     * pageNo       页码                        否（默认1）          Int
     * pageSize     每页条数                     否（默认15）         Int
     * danceHallId	舞伴大厅ID	是	int
     */
    public void dancehallCommentList(String pageNo, String pageSize, String danceHallId, final HttpBack<CommentBean> httpBack) {
        String url = getUrl(R.string.dancehallCommentList);
        Map<String, String> params = getReqParams();
        params.put("pageNo", pageNo);
        params.put("pageSize", pageSize);
        params.put("danceHallId", danceHallId);
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
     * 2.7	获取省市区
     */
    public void getPlaces(final HttpBack<ProviceBean> httpBack) {
        String url = getUrl(R.string.getPlaces);
        Map<String, String> params = getReqParams();
        m.getInstance().getNetUtils().post().url(url).params(params).enqueue(new RawResponseHandler() {
            @Override
            public void onSuccess(int statusCode, String response) {
                BaseBean baseBean = JSONObject.parseObject(response, BaseBean.class);
                new JsonFormatUtils().format(baseBean, httpBack, ProviceBean.class);
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
            params.put("c", application.getC());

        }
        return (HashMap) params;
    }


}


