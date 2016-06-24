package com.stay4it.testrxjavaandretrofit.http;

import android.content.Context;
import com.stay4it.testrxjavaandretrofit.listener.ProgressCancelListener;
import com.stay4it.testrxjavaandretrofit.listener.ProgressDialogHandler;
import com.stay4it.testrxjavaandretrofit.listener.SubscribeOnNextListener;
import rx.Subscriber;

public class ProgressSubscriber<T> extends Subscriber<T> implements ProgressCancelListener {
    private SubscribeOnNextListener mSubscribeOnNextListener;
    private Context context;
    private ProgressDialogHandler mProgressDialogHandler;

    public ProgressSubscriber(SubscribeOnNextListener subscribeOnNextListener, Context context, Boolean dialogShow) {
        mSubscribeOnNextListener = subscribeOnNextListener;
        this.context = context;
        mProgressDialogHandler = new ProgressDialogHandler(context, dialogShow, this);
    }

    private void showProgressDialog() {
        if (mProgressDialogHandler != null) {
            mProgressDialogHandler.obtainMessage(ProgressDialogHandler.SHOW_DIALOG).sendToTarget();
        }
    }


    private void dismissProgressDialog() {
        if (mProgressDialogHandler != null) {
            mProgressDialogHandler.obtainMessage(ProgressDialogHandler.DISMISS_DIALOG).sendToTarget();
            mProgressDialogHandler = null;
        }
    }

    @Override
    public void onStart() {
        showProgressDialog();
        super.onStart();
    }

    @Override
    public void onCompleted() {
        dismissProgressDialog();
    }

    @Override
    public void onError(Throwable e) {
        dismissProgressDialog();
    }

    @Override
    public void onNext(T t) {
        mSubscribeOnNextListener.onNext(t);
    }


    @Override
    public void onCancelProgress() {
        if (!this.isUnsubscribed()) {
            this.unsubscribe();
        }
    }
}
