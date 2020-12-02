package com.studio.parseviewpaises;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity implements RecyclerViewOnClickListener {

    private RecyclerView recyclerView;
    private AdpterListaPaises adapter;
    private JSONObject object;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String url ="https://restcountries.eu/rest/v2/lang/pt";

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        Toast.makeText(MainActivity.this,response.toString(),Toast.LENGTH_LONG);
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this,"Erro ",Toast.LENGTH_LONG);

                    }
                });

        // Access the RequestQueue through your singleton class.
        MySingleton.getInstance(this).addToRequestQueue(jsonObjectRequest);


        recyclerView = (RecyclerView) findViewById(R.id.RecyclerPaises);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplication());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);


       /* adapter = new AdpterListaPaises(,getLayoutInflater());
        adapter.setRecyclerOnClickListener(MainActivity.this);
        recyclerView.setAdapter(adapter);*/

    }


    @Override
    public void onClickListener(View view, int position) {

       /* DocumentSnapshot documentSnapshot = doc.get(position);

        Intent intent = new Intent(getContext(), NewPetActivity2.class);
        intent.putExtra("id",documentSnapshot.getId());
        intent.putExtra("pet", (Parcelable) documentSnapshot.toObject(Pet.class));
        startActivity(intent);*/

    }

}