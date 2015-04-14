package com.makeramen.nowdothis.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import com.makeramen.nowdothis.NowDoThisApp;
import com.makeramen.nowdothis.data.NowDoThisPreferences;
import javax.inject.Inject;

public class NowDoThisActivity extends FragmentActivity {
  @Inject NowDoThisPreferences nowDoThisPreferences;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    NowDoThisApp.getComponent(this).inject(this);

    if (getSupportFragmentManager().findFragmentById(android.R.id.content) == null) {
      Fragment fragment = nowDoThisPreferences.getTodos().length > 0
          ? new TodoFragment()
          : new EditListFragment();
      getSupportFragmentManager().beginTransaction()
          .replace(android.R.id.content, fragment)
          .commit();
    }
  }
}
