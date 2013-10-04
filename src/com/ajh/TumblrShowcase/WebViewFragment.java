package com.ajh.TumblrShowcase;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created with IntelliJ IDEA.
 * User: thedirtycalvinist
 * Date: 10/3/13
 * Time: 7:21 PM
 * Copyright 2013 Aaron Haser
 * <p/>
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * <p/>
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * <p/>
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
public class WebViewFragment extends Fragment {

    private WebView webView;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
//        View mainView = inflater.inflate(R.layout.fragment_list, container, false);
//        webView = (WebView) mainView.findViewById(R.id.webView);
//        webView.getSettings().setJavaScriptEnabled(true);
//        // from the android docs
//        webView.setWebViewClient(new WebViewClient() {
//            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
//                Toast.makeText(getActivity(), "Oh no! " + description, Toast.LENGTH_SHORT).show();
//            }
//        });
        webView = new WebView(getActivity());
        return webView;
    }

    public void setURL(String url){
        if(webView != null)
            webView.loadUrl(url);
    }


}
