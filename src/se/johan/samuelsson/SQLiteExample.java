package se.johan.samuelsson;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SQLiteExample extends Activity implements OnClickListener {

	Button sqlupdate, sqlview;
	EditText sqlName, sqlHotness;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sqliteexample);
		sqlupdate = (Button) findViewById(R.id.bSQLUpdate);
		sqlName = (EditText) findViewById(R.id.etSQLName);
		sqlHotness = (EditText) findViewById(R.id.etSQLHotness);
		
		sqlview = (Button) findViewById(R.id.bSQLOpenView);
		sqlview.setOnClickListener(this);
		sqlupdate.setOnClickListener(this);	
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()){
		case R.id.bSQLUpdate:
			
			boolean didItWork = true;
			try{
			String name = sqlName.getText().toString();
			String hotness = sqlHotness.getText().toString();
			
			SQLHandler entry = new SQLHandler(SQLiteExample.this);
			entry.open();
			entry.createEntry(name, hotness);
			entry.close();
			
			}catch (Exception e ){
					didItWork = false;
					String error = e.toString();
					Dialog d = new Dialog(this);
					d.setTitle("Dang!");
					TextView tv = new TextView(this);
					tv.setText(error);
					d.setContentView(tv);
					d.show();
			}finally{
				if(didItWork){
					Dialog d = new Dialog(this);
					d.setTitle("Heck Yea!");
					TextView tv = new TextView(this);
					tv.setText("Success");
					d.setContentView(tv);
					d.show();
				}
			}
			
			break;
		case R.id.bSQLOpenView:
			Intent i = new Intent("se.johan.samuelsson.SQLVIEW");
			startActivity(i);
			break;
		}
	}
	
}
