package com.liumang.instantchat.ui.activity;

import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.liumang.instantchat.R;
import com.liumang.instantchat.ui.BaseActivity;
import com.liumang.instantchat.ui.fragment.TabAddressFragment;
import com.liumang.instantchat.ui.fragment.TabFindFragment;
import com.liumang.instantchat.ui.fragment.TabIndexFragment;
import com.liumang.instantchat.ui.fragment.TabMineFragment;

import java.util.List;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.BindViews;

public class MainActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tvTitle)
    TextView tvTitle;
    @BindView(R.id.flContent)
    FrameLayout flContent;
    @BindView(R.id.rgTabBar)
    RadioGroup rgTabBar;
    @BindViews({R.id.rbIndex, R.id.rbAddress, R.id.rbFind, R.id.rbMine})
    List<RadioButton> rbTabs;

    @BindString(R.string.app_name)
    String tabIndex;
    @BindString(R.string.tab_address)
    String tabAddress;
    @BindString(R.string.tab_find)
    String tabFind;
    @BindString(R.string.tab_mine)
    String tabMine;

    TabIndexFragment mIndexFragment = new TabIndexFragment();
    TabAddressFragment mAddressFragment = new TabAddressFragment();
    TabFindFragment mFindFragment = new TabFindFragment();
    TabMineFragment mMineFragment = new TabMineFragment();

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        toolbar.setTitle("");
        tvTitle.setText(tabFind);
        setSupportActionBar(toolbar);

        addFragment();

        //默认选中第一项
        rbTabs.get(0).setChecked(true);

        rgTabBar.setOnCheckedChangeListener(mOnCheckedChangeListener);
        if (!isLogin()){
            Intent intent = new Intent();
            intent.setClass(MainActivity.this,LoginActivity.class);
            startActivity(intent);
        }
    }

    /**
     * 首页tab索引
     **/
    final int TAB_INDEX = 0;
    /**
     * 工作tab索引
     **/
    final int TAB_ADDRESS = 1;
    /**
     * 消息tab索引
     **/
    final int TAB_FIND = 2;
    /**
     * 我的tab索引
     **/
    final int TAB_MINE = 3;
    /**
     * 当前展示的tab索引
     **/
    int mCurShowFragmentIndex;

    public void addFragment() {
        FragmentTransaction transaction = getSupportFragmentManager()
                .beginTransaction();
        transaction.add(R.id.flContent, mIndexFragment);
        transaction.add(R.id.flContent, mAddressFragment);
        transaction.add(R.id.flContent, mFindFragment);
        transaction.add(R.id.flContent, mMineFragment);
        transaction.commit();

        showFragment(TAB_INDEX);

    }

    /**
     * 切换 tab选项卡
     */
    private void changeTab(int tabItem) {
        switch (tabItem) {
            case TAB_INDEX:
                tvTitle.setText(tabIndex);
                mCurShowFragmentIndex = TAB_INDEX;
                break;
            case TAB_ADDRESS:
                tvTitle.setText(tabAddress);
                mCurShowFragmentIndex = TAB_ADDRESS;
                break;
            case TAB_FIND:
                tvTitle.setText(tabFind);
                mCurShowFragmentIndex = TAB_FIND;
                break;
            case TAB_MINE:
                tvTitle.setText(tabMine);
                mCurShowFragmentIndex = TAB_MINE;
                break;
        }
        showFragment(mCurShowFragmentIndex);
    }

    /**
     * 底部导航菜单切换监听
     */
    RadioGroup.OnCheckedChangeListener mOnCheckedChangeListener = (group, checkedId) -> {
        switch (checkedId) {
            case R.id.rbIndex:
                changeTab(TAB_INDEX);
                break;
            case R.id.rbAddress:
                changeTab(TAB_ADDRESS);
                break;
            case R.id.rbFind:
                changeTab(TAB_FIND);
                break;
            case R.id.rbMine:
                changeTab(TAB_MINE);
                break;

        }
    };

    /**
     * hide所有的fragment
     */
    private void hideFragment() {
        FragmentTransaction transaction = getSupportFragmentManager()
                .beginTransaction();
        transaction.hide(mIndexFragment);
        transaction.hide(mAddressFragment);
        transaction.hide(mFindFragment);
        transaction.hide(mMineFragment);
        transaction.commit();
    }

    /**
     * show选中的fragment
     */
    public void showFragment(int tab) {
        hideFragment();
        FragmentTransaction transaction = getSupportFragmentManager()
                .beginTransaction();
        switch (tab) {
            case TAB_INDEX:
                transaction.show(mIndexFragment);
                tvTitle.setText(tabIndex);
                break;
            case TAB_ADDRESS:
                transaction.show(mAddressFragment);
                break;
            case TAB_FIND:
                transaction.show(mFindFragment);
                break;
            case TAB_MINE:
                transaction.show(mMineFragment);
                break;
        }
        transaction.commit();
    }

}
