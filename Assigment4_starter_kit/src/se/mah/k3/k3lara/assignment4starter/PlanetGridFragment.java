package se.mah.k3.k3lara.assignment4starter;

import java.util.ArrayList;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

public class PlanetGridFragment extends Fragment {

	GridView list;
	PlanetAdapter adapter;
	ArrayList<PlanetItem> planets = new ArrayList<PlanetItem>();
	PlanetClickListener onItemClickListener = new PlanetClickListener();
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View root = inflater.inflate(R.layout.fragment_planet_grid, container,
				false);
		
		// Add all planets to data set
		getPlanets();
		
		// inflate the layout for this fragment
		
		return root;
	}

	private void getPlanets() {
		// Add all planets here...
		//planets.add(new PlanetItem("Merkurius", R.drawable.merkurius));
	}
	
	private class PlanetClickListener implements OnItemClickListener{
		@Override
		public void onItemClick(AdapterView<?> av, View v, int position,
				long id) {
    		//Here we know that an item is clicked at position p so lets move to that Fragment
		}
	}
}