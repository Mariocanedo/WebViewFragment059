package com.example.webviewfragment059;

import static android.webkit.ConsoleMessage.MessageLevel.LOG;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.webviewfragment059.databinding.ActivityMainBinding;
import com.example.webviewfragment059.databinding.FragmentBlankBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BlankFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BlankFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String urlActivity;
    private String mParam2;
    private WebView web;


    private FragmentBlankBinding binding;
    public BlankFragment() {
        // Required empty public constructor
    }


    public static BlankFragment newInstance(String urlActivity , String param2) {
        BlankFragment fragment = new BlankFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, urlActivity);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            urlActivity = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentBlankBinding.inflate(inflater, container, false);
     View view = binding.getRoot();

        WebView webView = binding.webView1;
        webView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
        // configurar el webView
        webView.getSettings().setJavaScriptEnabled(true);
        // configurar un webbiewClien para cargar el contenido dentro del webVIew

        webView.setWebViewClient(new WebViewClient());
        // obtener la url
        String url = urlActivity.trim();
        webView.loadUrl(url);
         return  view;

    }}