package chandan.pushnotification;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by CHANDAN on 08-Mar-18.
 */

public class MySingleton {
private static MySingleton mInstances;
private static Context mCtx;
private RequestQueue requestQueue;

private MySingleton(Context context)
{
    mCtx=context;
    requestQueue=getRequestQueue();
}
private RequestQueue getRequestQueue()
{
    if (requestQueue==null){
        requestQueue= Volley.newRequestQueue(mCtx.getApplicationContext());
    }
    return requestQueue;
}

public static synchronized MySingleton getmInstances(Context context){
    if (mInstances==null){
        mInstances=new MySingleton(context);
    }
    return mInstances;
}

public<T> void addToRequestque(Request<T> request){
    getRequestQueue().add(request);
}
}

