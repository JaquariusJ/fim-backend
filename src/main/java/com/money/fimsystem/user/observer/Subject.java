package com.money.fimsystem.user.observer;

public interface Subject<T> {

    void appendObserver(UserObserver userObserver);

    void removeObserver(UserObserver userObserver);

    void notifyObservers(T t);
}
