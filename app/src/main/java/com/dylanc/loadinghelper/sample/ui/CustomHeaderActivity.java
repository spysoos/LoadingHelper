/*
 * Copyright (c) 2019. Dylan Cai
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.dylanc.loadinghelper.sample.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.dylanc.loadinghelper.sample.R;
import com.dylanc.loadinghelper.sample.adapter.TabPagerAdapter;
import com.dylanc.loadinghelper.sample.utils.ToolbarUtils;
import com.google.android.material.tabs.TabLayout;

/**
 * @author Dylan Cai
 */
public class CustomHeaderActivity extends AppCompatActivity {

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_view_pager);
    ToolbarUtils.setCustomToolbar(this, this::onMessageClick,
        R.drawable.ic_baseline_photo_camera_24, this::onFirstBtnClick,
        R.drawable.ic_baseline_favorite_24, this::onSecondBtnClick);

    // This TabLayout is in the custom toolbar.
    TabLayout tabLayout = findViewById(R.id.tab_layout);
    ViewPager viewPager = findViewById(R.id.view_pager);
    viewPager.setAdapter(new TabPagerAdapter(getSupportFragmentManager()));
    tabLayout.setupWithViewPager(viewPager);
  }

  private void onMessageClick(View view) {
    Toast.makeText(this, "click message button", Toast.LENGTH_SHORT).show();
  }

  private void onFirstBtnClick(View view) {
    Toast.makeText(this, "click camera button", Toast.LENGTH_SHORT).show();
  }

  private void onSecondBtnClick(View view) {
    Toast.makeText(this, "click favorite button", Toast.LENGTH_SHORT).show();
  }
}
