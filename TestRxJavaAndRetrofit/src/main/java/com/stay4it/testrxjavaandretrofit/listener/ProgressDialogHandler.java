package com.stay4it.testrxjavaandretrofit.listener;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;


public class ProgressDialogHandler extends Handler {
    public static final int SHOW_DIALOG = 1;
    public static final int DISMISS_DIALOG = 2;
    private ProgressDialog progressDialog;
    private Context context;
    private boolean cancelable;
    private ProgressCancelListener mProgressCancelListener;

    public ProgressDialogHandler(Context context, boolean cancelable, ProgressCancelListener listener) {
        super();
        this.context = context;
        this.cancelable = cancelable;
        mProgressCancelListener = listener;
    }

    private void initProgressDialog() {
        if (progressDialog == null) {
            progressDialog = new ProgressDialog(context);
            progressDialog.setCancelable(cancelable);

            if (cancelable) {
                progressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialog) {
                        mProgressCancelListener.onCancelProgress();
                    }
                });
            }

            if (!progressDialog.isShowing()) {
                progressDialog.show();
            }
        }
    }

    private void dismissProgressDialog() {
        if (progressDialog != null) {
            progressDialog.dismiss();
            progressDialog = null;
        }
    }

    @Override
    public void handleMessage(Message msg) {
        switch (msg.what) {
            case SHOW_DIALOG:
                initProgressDialog();
                break;
            case DISMISS_DIALOG:
                dismissProgressDialog();
                break;
        }
    }
}
