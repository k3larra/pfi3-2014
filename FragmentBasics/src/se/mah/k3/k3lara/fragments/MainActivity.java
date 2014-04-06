package se.mah.k3.k3lara.fragments;


import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;


public class MainActivity extends Activity  {

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity_container);  //Add the layout
        if (savedInstanceState == null) {
        	FragmentTransaction ft = getFragmentManager().beginTransaction(); //Start adding the fragment by getting the manager for handling this
        	HeadlinesFragment hf = new HeadlinesFragment(); //Create the fragment 
			ft.add(R.id.main_activity_container, hf); //And add it to the manager
			ft.commit(); //OK go ahed do your transaction nothing realy happends untill here
		}
    }
    
    //Here the meny is created
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    	MenuInflater inflater = getMenuInflater();
    	inflater.inflate(R.menu.main_menu, menu);  //This is the menu xml
    	return super.onCreateOptionsMenu(menu);
    }
    
}