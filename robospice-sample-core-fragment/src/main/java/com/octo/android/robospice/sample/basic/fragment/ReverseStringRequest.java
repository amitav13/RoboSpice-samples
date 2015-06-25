package com.octo.android.robospice.sample.basic.fragment;

import android.net.Uri;

import com.octo.android.robospice.request.SpiceRequest;

import org.apache.commons.io.IOUtils;

import java.net.HttpURLConnection;
import java.net.URL;

public class ReverseStringRequest extends SpiceRequest<String> {

    private String word;

    public ReverseStringRequest(String word) {
        super(String.class);
        this.word = word;
    }

    @Override
    public String loadDataFromNetwork() throws Exception {

        // With Uri.Builder class we can build our url is a safe manner
        Uri.Builder uriBuilder = Uri.parse(
            "http://robospice-sample.appspot.com/reverse").buildUpon();
        uriBuilder.appendQueryParameter("word", word);

        String url = uriBuilder.build().toString();
        
        HttpURLConnection urlConnection = (HttpURLConnection) new URL(url)
            .openConnection();
        String result = IOUtils.toString(urlConnection.getInputStream());
        urlConnection.disconnect();

        return result;
    }
}
