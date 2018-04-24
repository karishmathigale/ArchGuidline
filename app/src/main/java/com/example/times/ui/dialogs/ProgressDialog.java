package com.example.times.ui.dialogs;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.Window;

import com.example.times.R;

/**
 * Created by Karishma on 16/4/18.
 */

public class ProgressDialog extends Dialog {

    private static ProgressDialog progressDialog;

    public static ProgressDialog getInstance(Context context){
        if(progressDialog == null){
            progressDialog = new ProgressDialog(context);
        }
        return progressDialog;
    }

    public ProgressDialog(@NonNull Context context) {
        super(context);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setBackgroundDrawable(new ColorDrawable(0x00000000));
        setContentView(R.layout.progress_dialog);
    }

    public void showProgress(){
        if(progressDialog != null){
            progressDialog.show();
        }

    }

    public void dismissProgress(){
        if(progressDialog != null){
            progressDialog.dismiss();
        }
    }
}
