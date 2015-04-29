package cl.monsoon.s1next.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import cl.monsoon.s1next.R;

public final class HelpFragment extends Fragment {

    public static final String TAG = HelpFragment.class.getSimpleName();

    private static final String mURL = "http://monsoon.cl/S1-Next/HELP.html";

    private WebView mWebView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_help, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mWebView = (WebView) view.findViewById(R.id.webView);
        mWebView.setWebViewClient(new WebViewClient() {

            @Override
            public void onPageFinished(WebView webView, String url) {
                view.findViewById(R.id.progressBar).setVisibility(View.GONE);
                webView.setVisibility(View.VISIBLE);
            }
        });

        if (savedInstanceState == null) {
            mWebView.loadUrl(mURL);
        } else {
            mWebView.restoreState(savedInstanceState);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        mWebView.saveState(outState);
    }

    public WebView getWebView() {
        return mWebView;
    }
}