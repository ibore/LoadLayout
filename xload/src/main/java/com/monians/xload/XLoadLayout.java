package com.monians.xload;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

/**
 * 功能: XLoadLayout
 * 作者: ibore
 * 时间: 2016/5/27 11:33
 * 邮箱: bore521@live.com
 */
public class XLoadLayout extends FrameLayout {

    private int mLoadingId ,mEmptyId, mErrorId;

    private View mLoadingView, mEmptyView, mErrorView, mContentView;

    private OnLoadClickListener onLoadClickListener;

    public XLoadLayout(Context context) {
        this(context, null);
    }

    public XLoadLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public XLoadLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.XLoadLayout, defStyleAttr, 0);
        try {
            mLoadingId = typedArray.getResourceId(R.styleable.XLoadLayout_loadingLayout, -1);
            mEmptyId = typedArray.getResourceId(R.styleable.XLoadLayout_emptyLayout, -1);
            mErrorId = typedArray.getResourceId(R.styleable.XLoadLayout_errorLayout, -1);
        } finally {
            typedArray.recycle();
        }
    }

    // 设置监听
    public void setOnLoadingClickListener(OnLoadClickListener onLoadClickListener) {
        this.onLoadClickListener = onLoadClickListener;
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        mContentView = getChildAt(0);

        if (mLoadingId != -1) {
            setLoadingView(mLoadingId);
        }

        if (mEmptyId != -1) {
            setEmptyView(mEmptyId);
        }

        if (mErrorId != -1) {
            setErrorView(mErrorId);
        }
    }

    public void setLoadView(int loadingViewResId, int emptyViewResId, int errorViewResId) {
        setLoadingView(loadingViewResId);
        setEmptyView(emptyViewResId);
        setErrorView(errorViewResId);
    }

    public void setLoadView(View loadingView, View emptyView, View errorView) {
        setLoadingView(loadingView);
        setEmptyView(emptyView);
        setErrorView(errorView);
    }

    public View setLoadingView(int loadingViewResId) {
        View view = LayoutInflater.from(getContext()).inflate(loadingViewResId, this, false);
        setLoadingView(view);
        return view;
    }

    public View setEmptyView(int emptyViewResId) {
        View view = LayoutInflater.from(getContext()).inflate(emptyViewResId, this, false);
        setEmptyView(view);
        return view;
    }

    public View setErrorView(int errorViewResId) {
        View view = LayoutInflater.from(getContext()).inflate(errorViewResId, this, false);
        setErrorView(view);
        return view;
    }

    public View setContentView(int contentViewResId) {
        View view = LayoutInflater.from(getContext()).inflate(contentViewResId, this, false);
        setContentView(view);
        return view;
    }

    public View setLoadingView(View loadingView) {
        if (mLoadingView != null) {
            removeView(mLoadingView);
        }
        if (mLoadingView != loadingView) {
            mLoadingView = loadingView;
            addView(loadingView);
            mLoadingView.setVisibility(GONE);
        }
        return mLoadingView;
    }

    public View setEmptyView(View emptyView) {
        if (mEmptyView != null) {
            removeView(mEmptyView);
        }
        if (mEmptyView != emptyView) {
            mEmptyView = emptyView;
            addView(this.mEmptyView);
            mEmptyView.setVisibility(GONE);
        }
        mEmptyView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != onLoadClickListener)onLoadClickListener.onEmptyClick();
            }
        });
        return mEmptyView;
    }

    public View setErrorView(View errorView) {
        if (mErrorView != null) {
            removeView(mErrorView);
        }
        if (mErrorView != errorView) {
            mErrorView = errorView;
            addView(errorView);
            mErrorView.setVisibility(GONE);
        }
        mErrorView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != onLoadClickListener)onLoadClickListener.onErrorClick();
            }
        });
        return mErrorView;
    }

    public View setContentView(View contentView) {
        if (mLoadingView != null) {
            removeView(mLoadingView);
        }
        if (mLoadingView != contentView) {
            mLoadingView = contentView;
            addView(contentView);
        }
        return mContentView;
    }

    public void showLoadingView() {
        showView(mLoadingView);
    }

    public void showEmptyView() {
        showView(mEmptyView);
    }

    public void showErrorView() {
        showView(mErrorView);
    }

    public void showContentView() {
        showView(mContentView);
    }

    private void showView(View specialView) {
        if (specialView == null) {
            throw new NullPointerException("The View can't be empty");
        }
        for (int i = 0; i < getChildCount(); i++) {
            View child = getChildAt(i);
            if (child == specialView) {
                child.setVisibility(VISIBLE);
            } else {
                child.setVisibility(GONE);
            }
        }
    }

    public interface OnLoadClickListener {
        // 数据为空时回调
        void onEmptyClick();
        // 数据错误时的回调
        void onErrorClick();
    }
}
