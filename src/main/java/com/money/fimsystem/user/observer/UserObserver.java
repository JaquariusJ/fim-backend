package com.money.fimsystem.user.observer;

public interface UserObserver<User> {

    void handler(User user);

}
