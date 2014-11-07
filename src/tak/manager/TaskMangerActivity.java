package tak.manager;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import android.app.Activity;  

import android.app.ActivityManager;  

import android.app.ActivityManager.*;  
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.drawable.Drawable;


import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;  

import android.widget.TextView;  

import java.util.*;  

import android.os.Bundle;  
   


@SuppressWarnings("unused")
public class TaskMangerActivity extends Activity {
    /** Called when the activity is first created. */
	Button free;
	ActivityManager acti;
	List<RunningAppProcessInfo> proc;
	TextView tv,tv1;
	String[] ad=new String[10];
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        free=(Button)findViewById(R.id.button1);
        tv=(TextView)findViewById(R.id.textView1);
        tv1=(TextView)findViewById(R.id.textView2);
        free.setOnClickListener(new OnClickListener() {
			
        	public void onClick(View v) {
				
				
				// TODO Auto-generated method stub
				/*RunningTaskInfo rinfo=new RunningTaskInfo();
				int procInfos=rinfo.numRunning;
				int i;
				
				proc=acti.getRunningAppProcesses();
				for (RunningAppProcessInfo ti : proc)
				{
					listdp=ti;
				}
				Toast.makeText(TaskMangerActivity.this, "Number of Running Process : "+procInfos, 5).show();
				//ad=proc.toString();
				//tv.setText(ad);*/
				Context context = null;
				ActivityManager am = (ActivityManager)getSystemService(Context.ACTIVITY_SERVICE);
				

	List<RunningTaskInfo> a=am.getRunningTasks(Integer.MAX_VALUE);
	for(int i=0;i<a.size();i++){
		
        String packageName = a.get(i).topActivity.getPackageName();
        //tv.setText("Package"+ packageName);
        tv.setText( "Application executed : " +a.get(i).baseActivity.toShortString()+ "\t\t ID: "+a.get(i).id+""); 
        
    }
	 List<RunningAppProcessInfo> list2 = am.getRunningAppProcesses();
    
     for (RunningAppProcessInfo ti : list2) {
    	 String runin;
    	 	runin=ti.processName;
    	 	tv1.setText("Running \n"+runin);
	    	}
     
        	}
					
		});
	

	
    }
}