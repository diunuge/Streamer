package com.glasscube.streamer.authenticator;

import java.util.ArrayList;
import java.util.List;
 
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import com.glasscube.streamer.R;
 
//import android.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
 
public class Authenticator extends Activity {
    Button loginButton;
    EditText etUsername,etPassword;
    TextView tvResponse;
    HttpPost httppost;
    StringBuffer buffer;
    HttpResponse httpResponse;
    HttpClient httpclient;
    List<NameValuePair> nameValuePairs;
    ProgressDialog dialog = null;
     
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
         
        loginButton = (Button)findViewById(R.id.bLogin);  
        etUsername = (EditText)findViewById(R.id.username);
        etPassword= (EditText)findViewById(R.id.password);
        tvResponse = (TextView)findViewById(R.id.tvResponse);
         
        loginButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                 dialog = ProgressDialog.show(Authenticator.this, "", "Validating user...", true);
                 new Thread(new Runnable() {
                        public void run() {
                            login();                          
                        }
                 }).start();               
            }
        });
    }
     
    void login(){
        try{            
              
            httpclient=new DefaultHttpClient();
            httppost= new HttpPost("http://localhost/glasscube/streamer/login.php"); // url of login.php
            
            nameValuePairs = new ArrayList<NameValuePair>(2); // same name value pair for posting method. it is similar to the login.php variables
            nameValuePairs.add(new BasicNameValuePair("username",etUsername.getText().toString().trim()));
            nameValuePairs.add(new BasicNameValuePair("password",etPassword.getText().toString().trim())); 
            
            httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
            httpResponse=httpclient.execute(httppost);

            ResponseHandler<String> responseHandler = new BasicResponseHandler();
            final String response = httpclient.execute(httppost, responseHandler);
            //System.out.println("Response : " + response); 
            
            runOnUiThread(new Runnable() {
                public void run() {
                    tvResponse.setText("Response from PHP : " + response);
                    dialog.dismiss();
                }
            });
             
            if(response.equalsIgnoreCase("User Found")){
                runOnUiThread(new Runnable() {
                    public void run() {
                        Toast.makeText(Authenticator.this,"Login Success", Toast.LENGTH_SHORT).show();
                    }
                });
                Class ourClass = Class.forName("com.glasscube.streamer.MainActivity");
                startActivity(new Intent(Authenticator.this, ourClass));
            }else{
            	//for debug
            	//Class ourClass = Class.forName("com.glasscube.streamer.MainActivity");
                //startActivity(new Intent(Authenticator.this, ourClass));
                showAlert();                
            }
             
        }catch(Exception e){
            dialog.dismiss();
            System.out.println("Exception : " + e.getMessage());
        }
    }
    public void showAlert(){
    	Authenticator.this.runOnUiThread(new Runnable() {
            public void run() {
                Builder builder = new AlertDialog.Builder(Authenticator.this);
                builder.setTitle("Login Error.");
                builder.setMessage("User not Found.")  
                       .setCancelable(false)
                       .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                           public void onClick(DialogInterface dialog, int id) {
                           }
                       });                     
                AlertDialog alert = builder.create();
                alert.show();               
            }
        });
    }
}
