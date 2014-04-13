package se.mah.k3.fragmentdemo;

import android.app.Fragment;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SecondFragment extends Fragment {
	 @Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
		 View v = inflater.inflate(R.layout.fragment_second, container,false);
		 int number = getArguments().getInt("number");
		 //Find a array in values
		 String[] names = getResources().getStringArray(R.array.AllNames);
		 //Get the correct name
		 String name = names[number]; 
		 //Set  the name in a TextView
		 TextView tv = (TextView)v.findViewById(R.id.textview_in_second_fragment);
		 //Format the text nicely with HTML
		 tv.setText(Html.fromHtml("<b>Name: </b><i>"+name+"</i>"));
		 Button b = (Button)v.findViewById(R.id.button_in_second_fragment);
		 b.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Toast.makeText(getActivity(), "Button clicked", Toast.LENGTH_LONG).show(); //Make a toast
			}
		});
		return v;
	}
}
