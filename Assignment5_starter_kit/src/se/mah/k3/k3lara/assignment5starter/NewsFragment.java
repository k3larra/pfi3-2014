package se.mah.k3.k3lara.assignment5starter;

import java.util.ArrayList;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class NewsFragment extends Fragment {

	ButtonClickListener listener;
	
	ArrayList<NewsItem> news = new ArrayList<NewsItem>();
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_main, container,
				false);
		
		Button btn = (Button) rootView.findViewById(R.id.launchNewsNotification);
		btn.setOnClickListener(listener);
		
		createNewsItems();
		
		return rootView;
	}

	private void createNewsItems() {
		// TODO: Fill your news items array with at least 10 imaginary news
//		news.add( new NewsItem("2014-01-01", "My noms title", "Nom nom nom nom nom...", R.drawable.ic_launcher));
	}

	private class ButtonClickListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			buildNewsNotification();
		}
	}

	private void buildNewsNotification() {
		// TODO: Build your news notification here using remote views
		// 0. Select a random news item from your news item list
		// 1. Create the custom layout file for your notification
		// 2. Create a RemoteViews object selecting your layout file
		// 3. Assign each ID in your layout the correct value using remote views methods
		// 4. Build the notification
		// 5. Show the notification using manager
	}
}
