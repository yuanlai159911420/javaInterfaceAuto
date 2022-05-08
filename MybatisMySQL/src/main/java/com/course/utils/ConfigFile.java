package com.course.utils;

import com.course.model.InterfacesName;

import java.util.Locale;
import java.util.ResourceBundle;

public class ConfigFile {
    private static final ResourceBundle bundle = ResourceBundle.getBundle("application", Locale.CHINA);

    // 拼接URl
    public static String getUrl(InterfacesName name) {
        String address = bundle.getString("testURL");
        String uri = "";
        String testUrl;

        if (name.equals(InterfacesName.Login)) {
            uri = bundle.getString("login.url");
        } else if (name.equals(InterfacesName.AddUserInfo)) {
            uri = bundle.getString("addUser.url");
        } else if (name.equals(InterfacesName.GetUserInfo)) {
            uri = bundle.getString("getUserInfo.url");
        } else if (name.equals(InterfacesName.GetUserList)) {
            uri = bundle.getString("getUserList.url");
        } else if (name.equals(InterfacesName.UpdateUserInfo)) {
            uri = bundle.getString("updateUserInfo.url");
        }

        testUrl = address + uri;

        return testUrl;
    }
}
