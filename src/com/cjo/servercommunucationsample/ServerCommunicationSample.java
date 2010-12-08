package com.cjo.servercommunucationsample;

import java.util.StringTokenizer;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class ServerCommunicationSample extends Activity {
	
	private ServerCommunicationSample mainActivity = null;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
         
        
       final Button serverTest =(Button)findViewById(R.id.Server_Test);
        serverTest.setOnClickListener(mApplyListener);
        
   //     (new GetListTask()).execute((Object)null);
        
    }
    
    private OnClickListener mApplyListener = new OnClickListener()
    {
        public void onClick(View v)
        {
             //    finish();
        	 (new GetServerResponse()).execute((Object)null);

        }
     
    };

    private class GetListTask extends AsyncTask
	{
		/*
		 * Makes the http request and returns the result as a String
		 */
		protected String doInBackground(Object... args) 
		{
			return ServerCommunicate.getSongList();
		}
		
		/*
		 * Parse the String result, and create a new array
		 * adapter for the list view.
		 */
		protected void onPostExecute(Object objResult)
		{
			// Check if objResult is a string
			if(objResult != null && objResult instanceof String)
			{
				String result = (String) objResult;
				Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
				
			}
		}
	}
	
    private class GetServerResponse extends AsyncTask
    {

		@Override
		protected String doInBackground(Object... args) {
			return ServerCommunicate.getTest();
		}
		
		protected void onPostExecute(Object objResult)
		{
			if(objResult != null && objResult instanceof String)
			{
				String result = (String) objResult;
				Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
				
			}
		}
    	
    };
    
    
}