package com.priyashi.volleyapiexample;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request.Method;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.StringRequest;
import com.priyashi.model.GSonmodel;
import com.priyashi.volleyapiexample.volley.utils.Const;
import com.priyashi.volleycontroler.GsonRequest;
import com.priyashi.volleycontroler.VolleyManager;

public class StringRequestActivity extends Activity {

	private String TAG = StringRequestActivity.class.getSimpleName();
	private Button btnStringReq;
	private TextView msgResponse;
	private ProgressDialog pDialog;

	// This tag will be used to cancel the request
	private String tag_string_req = "string_req";
	private GsonRequest<GSonmodel> strReqs;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_string);

		btnStringReq = (Button) findViewById(R.id.btnStringReq);
		msgResponse = (TextView) findViewById(R.id.msgResponse);

		pDialog = new ProgressDialog(this);
		pDialog.setMessage("Loading...");
		pDialog.setCancelable(false);

		btnStringReq.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				makeStringReq();
			}
		});
	}

	private void showProgressDialog() {
		if (!pDialog.isShowing())
			pDialog.show();
	}

	private void hideProgressDialog() {
		if (pDialog.isShowing())
			pDialog.hide();
	}

	/**
	 * Making json object request
	 * */
	private void makeStringReq() {
		showProgressDialog();
		
		
		

		StringRequest strReq = new StringRequest(Method.GET,
				Const.URL_STRING_REQ, new Response.Listener<String>() {

					@Override
					public void onResponse(final String response) {
						Log.d(TAG, response.toString());
						msgResponse.setText(response.toString());
						hideProgressDialog();

					}
				}, new Response.ErrorListener() {

					@Override
					public void onErrorResponse(final VolleyError error) {
						VolleyLog.d(TAG, "Error: " + error.getMessage());
						hideProgressDialog();
					}
				});

		// Adding request to request queue using Application Class 
				/* 
				  AppController.getInstance().addToRequestQueue(strReq,tag_json_arry);
				 */
				
				
				// Adding request to request queue using Single pattrn static method technique without tag
		           /*
		            VolleyManager.getInstance(getApplicationContext()).addToRequestQueue(strReq);
		            */
				
		        
				
				// Adding request to request queue using Single pattrn static method technique with tag
		           
		          
		          VolleyManager.getInstance(getApplicationContext()).addToRequestQueue(strReq,"jsonrequest");
		      

	}
}