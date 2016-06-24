package com.stay4it.testretrofit.http;

import android.content.Context;
import android.util.Log;

import com.stay4it.testretrofit.listener.ProgressCancelListener;
import com.stay4it.testretrofit.listener.ProgressDialogHandler;
import com.stay4it.testretrofit.listener.SubscribeOnNextListener;

import rx.Subscriber;


public class ProgressSubscriber<T> extends Subscriber<T> implements ProgressCancelListener {

    private static final String TAG = "rxjava";
    private SubscribeOnNextListener mSubscribeOnNextListener;
    private Context context;
    private ProgressDialogHandler mProgressDialogHandler;

    public ProgressSubscriber(SubscribeOnNextListener subscribeOnNextListener, Context context,Boolean dialogShow) {
        mSubscribeOnNextListener = subscribeOnNextListener;
        this.context = context;
        mProgressDialogHandler = new ProgressDialogHandler(context, dialogShow, this);
    }

    private void showProgressDialog() {
        if (mProgressDialogHandler != null) {
            mProgressDialogHandler.obtainMessage(ProgressDialogHandler.SHOW_PROGRESS_DIALOG)
                    .sendToTarget();
        }
    }


    private void dismissProgressDialog() {
        if (mProgressDialogHandler != null) {
            mProgressDialogHandler.obtainMessage(ProgressDialogHandler.DISMISS_PROGRESS_DIALOG)
                    .sendToTarget();
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
        Log.d(TAG, "onError: success");
    }

    @Override
    public void onError(Throwable e) {
        dismissProgressDialog();
        Log.e(TAG, "onError: error:" + e.getMessage());
    }

    @Override
    public void onNext(T t) {
        Log.d(TAG, "onError: onnext");
        mSubscribeOnNextListener.onNext(t);

    }


    @Override
    public void onCancelProgress() {
        if (!this.isUnsubscribed()) {
            this.unsubscribe();
        }
    }
}
