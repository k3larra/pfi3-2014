package se.mah.k3lara.assigment2_starter.model;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

import android.content.Context;
import android.util.Log;

public class Safe {
     private ArrayList<ItemInSafe> items;
     private Context context;
     private static String safeFileName = "safe";
    
     public Safe(Context context) {
		this.items = new ArrayList<ItemInSafe>();
		this.context = context;
	}
     
    public ArrayList<ItemInSafe> getAllItems(){
    	return items;
    }
    
    public void addItem(ItemInSafe item){
    	items.add(item);
    }
    
    public void deleteItem(int i){
    	if (i<=items.size()){
    	 items.remove(i-1);
    	}
    }
    //Saves all items to file 
    public void restoreItems(){
    	File file = new File(context.getFilesDir(), safeFileName);
		if (file.exists()){
			items.clear();
			items.addAll(Parser.getSavedSafeItemsFromLocalStorage(file));
			Log.i("PassSafe","Found file restored: " + items.size());
		}else{ //Nothing is saved first time we run the thing
			items.add(new ItemInSafe("LinkedIn","h4x0r","1337"));
			items.add(new ItemInSafe("Gmail","h4x0r","KattOMat"));
			items.add(new ItemInSafe("Hotmail","pwned","Hund&Mat"));
			items.add(new ItemInSafe("GitHub","xPat","1337"));
			items.add(new ItemInSafe("Blocket","sorken","tr&5862_li3k"));
			Log.i("PassSafe","Restored:" + items.size());
		}
    }
    
    //Restores all items from file
    public void saveItems(){ 
    	String xml = Parser.serializeAsXml(items);
		Log.i("PassSafe","Saving::" + xml);
		FileOutputStream outputStream;
		File file = new File(context.getFilesDir(), safeFileName);
		try {
			outputStream = new FileOutputStream(file);
			outputStream.write(xml.getBytes());
		  outputStream.close();
		} catch (Exception e) {
		  e.printStackTrace();
		}
    
    }
}
    
