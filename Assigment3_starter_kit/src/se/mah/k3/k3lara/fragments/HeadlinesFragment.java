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

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class HeadlinesFragment extends ListFragment{ //This is a special fragment that creates a list
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
	    String[] planets = {"Merkurius","Venus","Jorden","Mars","Jupiter","Saturnus","Uranus","Neptunus"};
	    // Create an ArrayAdapter for the list view, using a string Array
	    // An ArrayAdapter is the magic rolls up all the items in a list using the supplied layout, there are pre-constructed
	    //layouts also named android.R.layout.simple_list_item_1, 
	    ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, planets);
	    //Ok tell the fragment that we are serious want to load the list with help from the adapter
	    setListAdapter(myAdapter);
	    //return whatever it will not really be used since the adapter will roll up the "android.R.layout.simple_list_item_1" with the planets instead
		return super.onCreateView(inflater, container, savedInstanceState);
	}
   
    @Override
    	public void onListItemClick(ListView l, View v, int position, long id) {
    		// TODO Auto-generated method stub
    		super.onListItemClick(l, v, position, id);
    		Log.i("k3larra","Position:"+position);
    		FragmentManager fm = getFragmentManager();
    		FragmentTransaction ft =fm.beginTransaction();
    		PlanetInfoFragment af = new PlanetInfoFragment();
    		ft.addToBackStack(null);
    		ft.add(R.id.main_activity_container, af);
    		ft.commit();	
    	}
	
    
    
    
    
    
    
    
    
    
    
    
    
    
}