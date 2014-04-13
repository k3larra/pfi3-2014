package se.mah.k3.fragmentdemo;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class MainFragment extends Fragment implements OnClickListener{
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
		//Find the view and inflate it
		View v = inflater.inflate(R.layout.fragment_main,container,false);
		//Get a string from values
		String s = getResources().getString(R.string.new_string_value);
		//Look up a View for example a TextArea in v and set text in it
		TextView tv = (TextView)v.findViewById(R.id.hello_world);
		//Set some new text in this case i 
		tv.setText(s);
		//Return the view now with extra text so the activity can draw it
		//Find the button
		Button b = (Button)v.findViewById(R.id.button1);
		//Tell the button that we are listening to it (it is possible because
		//we implemented OnClickListener so we are both a MainFragment and a OnClicklistener
		b.setOnClickListener(this);
		return v;
	}
	
	@Override
	public void onClick(View v) { //From the button and we want to tell the Activity
		//Start a second fragment and send message in for of the int i;
		//First create a packet to send with the transaction
		Bundle packet = new Bundle(); //A small packet to the Fragment
		packet.putInt("number", 3);  //Set the number in a name valuepair fx number 3
		SecondFragment secondFragment = new SecondFragment(); //Create the fragment
		secondFragment.setArguments(packet);//Load the Fragment with some extras
		FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
		fragmentTransaction.replace(R.id.container,secondFragment);
		//So we can use back button to get back here add the fragmen shown to the backstack
		fragmentTransaction.addToBackStack(null); 
		//Start the transaction
		fragmentTransaction.commit();
	}
}
