package se.mah.k3.k3lara.assignment4starter;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

public class PlanetAdapter extends ArrayAdapter<PlanetItem> {

	Activity context;
	ArrayList<PlanetItem> items;
	
	public PlanetAdapter(Activity context, int resource,
			List<PlanetItem> objects) {
		super(context, resource, objects);
		this.context = context;
		this.items = (ArrayList<PlanetItem>) objects;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View row = convertView;

		if (row == null) {
			LayoutInflater inflater = context.getLayoutInflater();
			row = inflater.inflate(R.layout.item_planet, null);
		}
		
		// Load the information for the specified list item here
		
		return row;
	}
}
