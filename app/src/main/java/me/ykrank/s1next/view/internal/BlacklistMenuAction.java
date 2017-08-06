package me.ykrank.s1next.view.internal;

import android.support.annotation.MainThread;
import android.support.v4.app.FragmentActivity;

import me.ykrank.s1next.App;
import me.ykrank.s1next.data.db.BlackListDbWrapper;
import me.ykrank.s1next.util.RxJavaUtil;
import me.ykrank.s1next.view.dialog.BlackListRemarkDialogFragment;
import me.ykrank.s1next.view.event.BlackListChangeEvent;
import me.ykrank.s1next.widget.RxBus;
import me.ykrank.s1next.widget.track.event.BlackListTrackEvent;

/**
 * Action when click black add/remove in menu
 * Created by ykrank on 2017/3/19.
 */

public class BlacklistMenuAction {

    @MainThread
    public static void addBlacklist(FragmentActivity activity, int uid, String name) {
        BlackListRemarkDialogFragment.newInstance(uid, name)
                .show(activity.getSupportFragmentManager(), BlackListRemarkDialogFragment.TAG);
    }

    @MainThread
    public static void removeBlacklist(RxBus rxBus, int uid, String name) {
        App.get().getTrackAgent().post(new BlackListTrackEvent(false, String.valueOf(uid), name));
        RxJavaUtil.workWithUiThread(() -> BlackListDbWrapper.getInstance().delDefaultBlackList(uid, name),
                () -> rxBus.post(new BlackListChangeEvent(uid, name, null, false)));
    }
}
