package se.mah.k3.k3lara.fragments;


import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;


public class PlanetActivity extends Activity  {

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity_container);  //Add the layout
        if (savedInstanceState == null) {  //If savedInstanceState not is null then we already have the activity fx if we were interupted by a phonecall and  b
        	FragmentManager fm = getFragmentManager();
        	FragmentTransaction ft = fm.beginTransaction(); //Start adding the fragment by getting the manager for handling this
        	PlanetListFragment hf = new PlanetListFragment(); //Create the fragment 
			ft.add(R.id.main_activity_container, hf); //And add it to the manager
			ft.commit(); //OK go ahead do your transaction nothing really happens until here
		}
    }
    
    //Here the meny is created
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    	MenuInflater inflater = getMenuInflater();
    	inflater.inflate(R.menu.main_menu, menu);  //This is the menu xml and this packs it up
    	return true; //true means that the menu will be shown
    }
    
    //If you select a meny item this method is called
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	if (item.getItemId()==R.id.about){
    		return true; //Returning true indicates to the system that we handled the meny selection here
    	}
    	return false;//If we didn't handle the selection we return false
    }
    
}