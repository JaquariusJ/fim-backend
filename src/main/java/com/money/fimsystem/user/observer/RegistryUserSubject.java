package com.money.fimsystem.user.observer;

import com.money.fimsystem.common.utils.SpringUtils;
import com.money.fimsystem.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class RegistryUserSubject implements Subject<User> {
    private List<UserObserver> registryUserUserObservers = new ArrayList<>();

    @Autowired
    private InitAccountLogoUserObserver initAccountLogoUserObserver;

    @PostConstruct
    public void init(){
        registryUserUserObservers.add(initAccountLogoUserObserver);
    }

    @Override
    public void appendObserver(UserObserver userObserver) {
        registryUserUserObservers.add(userObserver);
    }

    @Override
    public void removeObserver(UserObserver userObserver) {
        registryUserUserObservers.remove(userObserver);

    }

    @Override
    public void notifyObservers(User user) {
        for (UserObserver registryUserUserObserver : registryUserUserObservers) {
            registryUserUserObserver.handler(user);
        }
    }
}
