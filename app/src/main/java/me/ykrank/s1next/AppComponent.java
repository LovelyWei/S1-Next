package me.ykrank.s1next;

import android.content.Context;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.inject.Singleton;

import dagger.Component;
import me.ykrank.s1next.data.User;
import me.ykrank.s1next.data.Wifi;
import me.ykrank.s1next.data.api.S1Service;
import me.ykrank.s1next.data.api.UserValidator;
import me.ykrank.s1next.view.adapter.delegate.FavouriteAdapterDelegate;
import me.ykrank.s1next.view.adapter.delegate.PmGroupsAdapterDelegate;
import me.ykrank.s1next.view.adapter.delegate.PmLeftAdapterDelegate;
import me.ykrank.s1next.view.adapter.delegate.PmRightAdapterDelegate;
import me.ykrank.s1next.view.dialog.BlackListRemarkDialogFragment;
import me.ykrank.s1next.view.dialog.LogoutDialogFragment;
import me.ykrank.s1next.view.fragment.FavouriteListFragment;
import me.ykrank.s1next.view.fragment.PmFragment;
import me.ykrank.s1next.view.fragment.PostListPagerFragment;
import me.ykrank.s1next.view.fragment.WebLoginFragment;
import me.ykrank.s1next.viewmodel.UserViewModel;
import me.ykrank.s1next.widget.EventBus;
import okhttp3.OkHttpClient;

/**
 * Indicates the class where this module is going to inject dependencies
 * or the dependencies we want to get.
 */
@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {

    Context getContext();

    OkHttpClient getOkHttpClient();

    S1Service getS1Service();

    EventBus getEventBus();

    User getUser();

    UserValidator getUserValidator();

    UserViewModel getUserViewModel();

    Wifi getWifi();

    ObjectMapper getJsonMapper();

    void inject(LogoutDialogFragment fragment);

    void inject(WebLoginFragment fragment);

    void inject(FavouriteListFragment favouriteListFragment);

    void inject(FavouriteAdapterDelegate favouriteAdapterDelegate);

    void inject(PmGroupsAdapterDelegate pmGroupsAdapterDelegate);

    void inject(PmFragment pmFragment);

    void inject(PmLeftAdapterDelegate pmLeftAdapterDelegate);

    void inject(PmRightAdapterDelegate pmRightAdapterDelegate);

    void inject(PostListPagerFragment postListPagerFragment);

    void inject(BlackListRemarkDialogFragment blackListRemarkDialogFragment);
}
