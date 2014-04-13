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

public class PlanetListFragment extends ListFragment{ //This is a special fragment that creates a list
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		//Move this to values in a string array
		String[] planets = {"Merkurius","Venus","Jorden","Mars","Jupiter","Saturnus","Uranus","Neptunus"};
	    // Create an ArrayAdapter for the list view, using a string Array
	    // An ArrayAdapter is the magic rolls up all the items in a list using a pre-constructed
	    ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, planets);
	    //Ok tell the fragment that we are serious want to load the list with help from the adapter
	    setListAdapter(myAdapter);
	    //return whatever it will not really be used since the adapter will roll up the "android.R.layout.simple_list_item_1" with the planets instead
		return super.onCreateView(inflater, container, savedInstanceState);
	}
   
    @Override
    	public void onListItemClick(ListView l, View v, int position, long id) {
    		super.onListItemClick(l, v, position, id);
    		//Here we know that an item is cliced at position p so lets move to that Fragment
    	}
	
    
    
    
    
    
    
    
    
    
    
    
    
    
}