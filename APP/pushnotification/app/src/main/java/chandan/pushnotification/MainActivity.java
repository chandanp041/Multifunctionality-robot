package chandan.pushnotification;

import android.app.DownloadManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    Button button;
    String app_server_url="http://10.0.2.2/pushnotification/insert.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=(Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences=getApplicationContext().getSharedPreferences(getString(R.string.PUSH_PREF), Context.MODE_PRIVATE);
                final String token=sharedPreferences.getString(getString(R.string.PUSH_TOKEN),"");
                StringRequest stringRequest=new StringRequest(Request.Method.POST, app_server_url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {

                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                })
                {
                    @Override
                    protected Map<String,String> getParams() throws AuthFailureError{
                        Map<String,String> params=new HashMap<String, String>();
                        params.put("push_token",token);
                        return params;
                    }
                };
                MySingleton.getmInstances(MainActivity.this).addToRequestque(stringRequest);
            }
        });
    }
}
