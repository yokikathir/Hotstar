package com.hotstar.player.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.daimajia.slider.library.Indicators.PagerIndicator;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.DefaultSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.hotstar.player.R;

import java.util.HashMap;

public class SportsFragment extends Fragment {
    private Activity mActivity = null;
    private SliderLayout sportsSection = null;
    private SliderLayout kabaddiSection = null;

    private Button browseSportsButton = null;
    private TextView browseSportsTextView = null;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mActivity = activity;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mActivity = null;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_sports, container, false);

        // load sports section
        sportsSection = (SliderLayout)v.findViewById(R.id.sports_main_slider);
        loadSportsSection(sportsSection);

        // load kabaddi section
        kabaddiSection = (SliderLayout)v.findViewById(R.id.sports_kabaddi_slider);
        loadKabaddiSection(kabaddiSection);

        browseSportsButton = (Button) v.findViewById(R.id.sports_kabaddi_browse_button);
        browseSportsButton.setOnClickListener(browseSportButtonClickListener);
        browseSportsTextView = (TextView) v.findViewById(R.id.sports_kabaddi_browse_textview);
        browseSportsTextView.setText("Browse Sports");

        return v;
    }


    protected void loadSportsSection(SliderLayout sliderLayout) {
        HashMap<String,String> url_maps = new HashMap<String, String>();
        url_maps.put("Hannibal", "http://static2.hypable.com/wp-content/uploads/2013/12/hannibal-season-2-release-date.jpg");
        url_maps.put("Big Bang Theory", "http://tvfiles.alphacoders.com/100/hdclearart-10.png");
        url_maps.put("House of Cards", "http://cdn3.nflximg.net/images/3093/2043093.jpg");
        url_maps.put("Game of Thrones", "http://images.boomsbeat.com/data/images/full/19640/game-of-thrones-season-4-jpg.jpg");

        for(String name : url_maps.keySet())
        {
            DefaultSliderView defaultSliderView = new DefaultSliderView(mActivity.getBaseContext());
            defaultSliderView.description(name)
                    .image(url_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(sportClickListener);

            //add your extra information
            defaultSliderView.bundle(new Bundle());
            defaultSliderView.getBundle().putString("extra", name);

            sliderLayout.addSlider(defaultSliderView);
            sliderLayout.setIndicatorVisibility(PagerIndicator.IndicatorVisibility.Invisible);
            sliderLayout.setDuration(4000);
        }
    }

    protected void loadKabaddiSection(SliderLayout sliderLayout) {
        HashMap<String,String> url_maps = new HashMap<String, String>();
        url_maps.put("Hannibal", "http://static2.hypable.com/wp-content/uploads/2013/12/hannibal-season-2-release-date.jpg");
        url_maps.put("Big Bang Theory", "http://tvfiles.alphacoders.com/100/hdclearart-10.png");
        url_maps.put("House of Cards", "http://cdn3.nflximg.net/images/3093/2043093.jpg");
        url_maps.put("Game of Thrones", "http://images.boomsbeat.com/data/images/full/19640/game-of-thrones-season-4-jpg.jpg");

        for(String name : url_maps.keySet())
        {
            DefaultSliderView defaultSliderView = new DefaultSliderView(mActivity.getBaseContext());
            defaultSliderView.description(name)
                    .image(url_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(kabaddiClickListener);

            //add your extra information
            defaultSliderView.bundle(new Bundle());
            defaultSliderView.getBundle().putString("extra", name);

            sliderLayout.addSlider(defaultSliderView);
            sliderLayout.setIndicatorVisibility(PagerIndicator.IndicatorVisibility.Invisible);
            sliderLayout.setDuration(4000);
        }
    }

    private BaseSliderView.OnSliderClickListener kabaddiClickListener = new BaseSliderView.OnSliderClickListener() {
        @Override
        public void onSliderClick(BaseSliderView baseSliderView) {

        }
    };

    private BaseSliderView.OnSliderClickListener sportClickListener = new BaseSliderView.OnSliderClickListener() {
        @Override
        public void onSliderClick(BaseSliderView baseSliderView) {

        }
    };

    private View.OnClickListener browseSportButtonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
        }
    };

}