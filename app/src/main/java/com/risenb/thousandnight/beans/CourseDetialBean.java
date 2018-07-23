package com.risenb.thousandnight.beans;

import java.util.ArrayList;

/**
 * ================================================
 * 作    者：tongxiaoyun
 * 版    本：1.0
 * 创建日期：2018/7/21
 * 描    述：
 * 修订历史：
 * ================================================
 */
public class CourseDetialBean {
    private ArrayList<VideoBean> courseVideo;
    private ArrayList<TeacherBean> teacherList;//
    private CourseBean course;//

    public ArrayList<VideoBean> getCourseVideo() {
        return courseVideo;
    }

    public void setCourseVideo(ArrayList<VideoBean> courseVideo) {
        this.courseVideo = courseVideo;
    }

    public ArrayList<TeacherBean> getTeacherList() {
        return teacherList;
    }

    public void setTeacherList(ArrayList<TeacherBean> teacherList) {
        this.teacherList = teacherList;
    }

    public CourseBean getCourse() {
        return course;
    }

    public void setCourse(CourseBean course) {
        this.course = course;
    }
}
