/*
 * Copyright (C) 2012 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package se.mah.k3.k3lara.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
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
		//First find the view for the Button in the view for the Fragment and cast it to a Button.
		Button changeColorButton = (Button)v.findViewById(R.id.button_change_textcolor);
		//add a listener as an anonymous inner class
		changeColorButton.setOnClickListener(new OnClickListener() {
			//Here is the method that will be called when the button is clicked.
			@Override
			public void onClick(View v) {
				//The View above in on click is the button 
			}
		});
		//Return the view that we prepared so it can be drawn on the fragment.
        return v;
    }
	
	

}