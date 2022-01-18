package com.jiosaavn.web.springselenium.page.home;

import com.jiosaavn.web.springselenium.kelvin.annotations.Page;
import com.jiosaavn.web.springselenium.page.BaseConfig;
import org.springframework.beans.factory.annotation.Autowired;

@Page
public class UpgradePage extends BaseConfig {

    @Autowired
    private UpgradeComponent upgradeComponent;

    public UpgradeComponent getUpgradeComponent(){
        return upgradeComponent;
    }

    @Override
    public boolean isAt() {
        return false;
    }
}
