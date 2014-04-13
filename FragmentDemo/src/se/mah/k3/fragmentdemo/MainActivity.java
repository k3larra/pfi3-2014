package se.mah.k3.fragmentdemo;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		if (savedInstanceState == null) { //First time so fragment not created already
			//Prepare for the transaction
			FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
			//Create the fragment to be loaded int this case named MainFragment
			MainFragment mainFragment = new MainFragment(); 
			//Tell the fragmentTransaction that we wan't to add this fragment (We can do more here)
			fragmentTransaction.add(R.id.container,mainFragment);
			//Start the transaction
			fragmentTransaction.commit();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
