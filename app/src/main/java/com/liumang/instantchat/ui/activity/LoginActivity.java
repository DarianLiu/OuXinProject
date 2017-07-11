package com.liumang.instantchat.ui.activity;

import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;

import com.liumang.instantchat.R;
import com.liumang.instantchat.ui.BaseActivity;

import butterknife.BindString;
import butterknife.BindView;

/**
 * 登录页面
 * Created by LiuLi on 2017/7/5.
 */

public class LoginActivity extends BaseActivity {
    @BindView(R.id.text_input_phone)
    TextInputLayout text_input_phone;

    @BindView(R.id.edit_phone)
    TextInputEditText edit_phone;

    @BindView(R.id.text_input_password)
    TextInputLayout text_input_password;

    @BindView(R.id.edit_password)
    TextInputEditText edit_password;

    @BindString(R.string.please_input_phone)
    String please_input_phone;
    @BindString(R.string.please_input_password)
    String please_input_password;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    /**
     * 出事化View
     */
    @Override
    protected void initView() {
        initTextInputLayout(text_input_phone,please_input_phone,true,true,true,
                11,R.style.hint_text,-1);

        initTextInputLayout(text_input_password,please_input_password,true,true,true,
                20,R.style.hint_text,-1);
//        设置是否显示密码可见图片
        text_input_password.setPasswordVisibilityToggleEnabled(true);

    }

    /**
     * 设置TextInputLayout属性
     * @param textInputLayout 控件
     * @param hint hint
     * @param hintAnimation 是否显示hint动画
     * @param hintEnable hint是否可用
     * @param counterEnable 计数器是否可用
     * @param counterMaxLength input的最大字符数
     * @param hintTextStyle hint字体样式
     * @param errorTextStyle error字体样式
     */
    private void initTextInputLayout(TextInputLayout textInputLayout,String hint,
                                     boolean hintAnimation,boolean hintEnable,
                                     boolean counterEnable,int counterMaxLength,
                                     int hintTextStyle, int errorTextStyle){
         /* 设置提示信息 */
        textInputLayout.setHint(please_input_phone);
        /* 设置hint文字的动画 */
        textInputLayout.setHintAnimationEnabled(true);
        /* 设置hint是否可用 */
        textInputLayout.setHintEnabled(true);
        /* 比如用户输错了密码或者用户名等 */
//        text_input_phone.setError("您的输入的电话号码有错!");
        /* 这句代码需要在setError() 之后调用 */
//        text_input_phone.setErrorEnabled(true);
        /* 设置计数器是否可用 */
        textInputLayout.setCounterEnabled(true);
        /* 设置input的最大字符数，如果<=0,则不显示 */
        textInputLayout.setCounterMaxLength(11);
        /* 获取最大可输入字符数 */
//        text_input_phone.getCounterMaxLength();
        textInputLayout.setHintTextAppearance(R.style.hint_text);
        textInputLayout.setErrorTextAppearance(-1);
        textInputLayout.setActivated(false);
    }
}
