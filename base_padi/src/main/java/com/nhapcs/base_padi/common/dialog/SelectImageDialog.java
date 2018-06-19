package com.nhapcs.base_padi.common.dialog;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;


import com.nhapcs.base_padi.R;

/**
 * Visunite
 * <p>
 * Created by Paditech on 3/10/2017.
 * Copyright (c) 2017 Paditech. All rights reserved.
 */

public class SelectImageDialog extends BottomSheetDialogFragment {

    private SelectImageDialogListenner mSelectImageDialogListenner;

    public static SelectImageDialog newInstance() {
        return new SelectImageDialog();
    }

    public void setSelectImageDialogListenner(SelectImageDialogListenner selectImageDialogListenner) {
        this.mSelectImageDialogListenner = selectImageDialogListenner;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        try {
            getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
            getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));


        } catch (Exception e) {
            e.printStackTrace();
        }
        View view = inflater.inflate(R.layout.dialog_pick_image, container, false);
        view.findViewById(R.id.btn_pick_image).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
                if (mSelectImageDialogListenner != null) {
                    mSelectImageDialogListenner.pickImage();
                }
            }
        });
        view.findViewById(R.id.btn_take_photo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
                if (mSelectImageDialogListenner != null) {
                    mSelectImageDialogListenner.takePhoto();
                }
            }
        });
        view.findViewById(R.id.btn_cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        return view;
    }

    @Override
    public void show(FragmentManager manager, String tag) {
        try {
            super.show(manager, tag);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public int show(FragmentTransaction transaction, String tag) {
        try {
            return super.show(transaction, tag);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public interface SelectImageDialogListenner {
        void pickImage();

        void takePhoto();
    }

    @Override
    public void dismiss() {

    }
}
