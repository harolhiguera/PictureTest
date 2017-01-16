package com.lazada.picturetest.Bus;

import rx.Observable;
import rx.subjects.PublishSubject;

/**
 * Created by Harol Higuera on 1/16/17.
 */

public class PhotoBus {

    public static final PublishSubject<String> showBackBtn = PublishSubject.create();
    public static final Observable<String> showBackBtnM = showBackBtn.asObservable();

}
