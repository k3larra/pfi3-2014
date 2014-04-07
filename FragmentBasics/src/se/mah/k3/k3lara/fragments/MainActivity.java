package se.mah.k3.k3lara.fragments;


import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;


public class MainActivity extends Activity  {

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity_container);  //Add the layout
        if (savedInstanceState == null) {
        	FragmentManager fm = getFragmentManager();
        	FragmentTransaction ft = fm.beginTransaction(); //Start adding the fragment by getting the manager for handling this
        	HeadlinesFragment hf = new HeadlinesFragment(); //Create the fragment 
			ft.add(R.id.main_activity_container, hf); //And add it to the manager
			ft.commit(); //OK go ahead do your transaction nothing really happens until here
		}
    }
    
    //Here the meny is created
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    	MenuInflater inflater = getMenuInflater();
    	inflater.inflate(R.menu.main_menu, menu);  //This is the menu xml
    	return super.onCreateOptionsMenu(menu);
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	// TODO Auto-generated method stub
    	if (item.getItemId()==R.id.menu_share){
    		Log.i("k3larra","share");
    		return true;
    	} else if (item.getItemId()==R.id.menu_paste){
    		Log.i("k3larra","paste");
    		return true;
    	}
    	return super.onOptionsItemSelected(item);
    }
    
}