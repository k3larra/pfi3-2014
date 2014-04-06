package se.mah.k3.k3lara.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ArticleFragment extends Fragment {
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, 
        Bundle savedInstanceState) {
        // Inflate the layout for this fragment
		View v =  inflater.inflate(R.layout.fragment_article_view, container, false);
		//Get the TextView from the View
		TextView tv = (TextView)v.findViewById(R.id.header);
		//Change the headline
		tv.setText("Min rubrik");
		//Add listener to the change color button
		//Return the view that we prepared so it can be drawn on the fragment.
        return v;
    }
	
	

}