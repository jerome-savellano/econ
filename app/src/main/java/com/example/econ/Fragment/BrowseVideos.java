package com.example.econ.Fragment;

import android.app.Fragment;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.econ.Adapter.JSONParser;
import com.example.econ.R;
import com.example.econ.Videos;
import com.google.android.youtube.player.YouTubePlayerFragment;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by jerome on 8/8/2016.
 */
public class BrowseVideos extends Fragment {

    private TextView text;
    private Button button;

    private static String url = "https://www.googleapis.com/youtube/v3/search?key=AIzaSyCiDUMpGQLXONZchVUpDyfl_H6he87VC20&channelId=UCdlxWNzGGPKzQLMXkkyZkUQ&part=snippet,id&order=date&maxResults=50";

    //JSON Node Names
    private static final String TAG_USER = "items";
    private static final String TAG_ID = "id";
    private static final String TAG_NAME = "kind";
    private static final String TAG_EMAIL = "videoId";

    JSONArray user = null;

    String videoId;

    public BrowseVideos(){
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_videos, container, false);

        text = (TextView)rootView.findViewById(R.id.text);

        json();

        setFont();

        button = (Button)rootView.findViewById(R.id.btnPlay);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Videos.class);
                getActivity().startActivity(intent);
            }
        });

        return rootView;
    }

    private void setFont(){
        Typeface tp = Typeface.createFromAsset(getActivity().getAssets(), "fonts/Roboto-Black.ttf");
        text.setTypeface(tp);
    }

    private void json(){
        JSONParser jParser = new JSONParser();

        JSONArray object = jParser.getJSONFromUrl(url);

        try{

            //user = object.getJSONArray(TAG_USER);
            JSONObject c = object.getJSONObject(0);
            videoId = c.getString(TAG_NAME);
            text.setText(c.getString("kind"));

            System.out.print("hello world");
        }catch (JSONException e){
            Log.e("AAAAAAA", e.getMessage());
            Log.e("AAAAAAA", e.getMessage());
            Log.e("AAAAAAA", e.getMessage());
            Log.e("AAAAAAA", e.getMessage());
            Log.e("AAAAAAA", e.getMessage());
            Log.e("AAAAAAA", e.getMessage());
            Log.e("AAAAAAA", e.getMessage());
            Log.e("AAAAAAA", e.getMessage());
            Log.e("AAAAAAA", e.getMessage());
            Log.e("AAAAAAA", e.getMessage());
            Log.e("AAAAAAA", e.getMessage());
            Log.e("AAAAAAA", e.getMessage());
            Log.e("AAAAAAA", e.getMessage());
            Log.e("AAAAAAA", e.getMessage());
            Log.e("AAAAAAA", e.getMessage());
            Log.e("AAAAAAA", e.getMessage());
            Log.e("AAAAAAA", e.getMessage());
        }
    }

}
