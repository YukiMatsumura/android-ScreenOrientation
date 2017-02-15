package com.yuki312.orientationsample.setting;

import com.yuki312.orientationsample.core.di.ActivityComponent;
import com.yuki312.orientationsample.core.di.ActivityComponentBuilder;
import com.yuki312.orientationsample.core.di.ActivityModule;
import com.yuki312.orientationsample.core.di.ScenarioScope;
import com.yuki312.orientationsample.core.flux.Dispatcher;
import com.yuki312.orientationsample.main.MainActivity;
import dagger.Module;
import dagger.Provides;
import dagger.Subcomponent;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by YukiMatsumura on 2017/02/15.
 */

@ScenarioScope
@Subcomponent(modules = SettingComponent.SettingModule.class)
public interface SettingComponent extends ActivityComponent<SettingActivity> {

  @Subcomponent.Builder
  interface Builder extends ActivityComponentBuilder<SettingModule, SettingComponent> {
  }

  @Module
  class SettingModule extends ActivityModule {

    private List<String> scenarioLog;

    public SettingModule() {
      scenarioLog = new ArrayList<>();
    }

    @ScenarioScope @Provides
    public SettingActionCreator provideSettingActionCreator(Dispatcher dispatcher) {
      return new SettingActionCreator(dispatcher);
    }

    @ScenarioScope @Provides public List<String> provideScenarioLog() {
      return scenarioLog;
    }
  }
}
