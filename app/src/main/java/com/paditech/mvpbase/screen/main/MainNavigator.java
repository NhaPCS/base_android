package com.paditech.mvpbase.screen.main;

import com.nhapcs.base_padi.common.mvvm.Navigator;
import com.paditech.mvpbase.model.Category;

import java.util.List;

/**
 * Created by nhapcs on 6/10/18.
 */
public interface MainNavigator extends Navigator{

    void updateData(List<Category> categories);
}
