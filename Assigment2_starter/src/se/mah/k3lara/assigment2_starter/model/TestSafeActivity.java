package se.mah.k3lara.assigment2_starter.model;


import se.mah.k3lara.assigment2_starter.R;
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

public class TestSafeActivity extends Activity {
	public static Safe safe;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_test_safe);
		if (savedInstanceState == null) {
			getFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
		safe = new Safe(this);
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		safe.restoreItems();
		showItemsInSafe();
		for (ItemInSafe item : safe.getAllItems()) {
			Log.i("PassSafe","In OnResume read from storage:" + item.getCompany());
		}
	}

	@Override
	protected void onPause() {
		super.onPause();
		safe.saveItems();
		for (ItemInSafe item : safe.getAllItems()) {
			Log.i("PassSafe","In onPause saved:" + item.getCompany());
		}
	}
	
	
	public void add(View v){
		EditText companyView = (EditText)findViewById(R.id.company);
		EditText logiIdView = (EditText)findViewById(R.id.loginId);
		EditText passWordView = (EditText)findViewById(R.id.password);
		String company = companyView.getText().toString();
		String loginID = logiIdView.getText().toString();
		String password = passWordView.getText().toString();
		ItemInSafe InSafe = new ItemInSafe(company);
		InSafe.setLoginID(loginID);
		InSafe.setPassword(password);
		safe.addItem(InSafe);
		showItemsInSafe();
		hideKeyBoard();
		//Check saved items
		for (ItemInSafe item1 : safe.getAllItems()) {
			Log.i("PassSafe","In add:" + item1.getCompany());
		}
	}
	
	public void showItemsInSafe(){
		TextView textView = (TextView)findViewById(R.id.safeItems);
		textView.setText("");
		for (int i = 0; i< safe.getAllItems().size(); i++) {
			textView.append("item nbr: "+i+": "+safe.getAllItems().get(i).getCompany()+":"+safe.getAllItems().get(i).getLoginID()+":"+ safe.getAllItems().get(i).getPassword()+"\n");
		}
	}
	
	public void removeItem(View v){
		EditText editText = (EditText)findViewById(R.id.nbrToRemove);
		String s = editText.getText().toString();
		try {
			int i = Integer.parseInt(s);
			safe.deleteItem(i);
			showItemsInSafe();
			editText.setText("1");
			hideKeyBoard();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Log.i("PassSafe","Not a number");
		}
	}
	
	//on click in textfield
	public void update(View v){
		showItemsInSafe();
	}
	
	private void hideKeyBoard(){
		InputMethodManager inputManager = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE); 
		inputManager.hideSoftInputFromWindow(this.getCurrentFocus().getWindowToken(),InputMethodManager.HIDE_NOT_ALWAYS);
	}


	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_test_safe,
					container, false);
			return rootView;
		}
	}

}
