package br.com.mfelipesp.desafioglobo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import br.com.mfelipesp.desafioglobo.adapters.MyAdapter;
import br.com.mfelipesp.desafioglobo.constants.NoticiaConstants;
import br.com.mfelipesp.desafioglobo.model.Noticia;
import br.com.mfelipesp.desafioglobo.services.NoticiasService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addItemOnView();
        setSupportActionBar(toolbar);

        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)

        String[] myDataset = new String[]{"Marcos", "Nyelson", "Diogo"};
        mAdapter = new MyAdapter(myDataset);
        mRecyclerView.setAdapter(mAdapter);

        getServiceNoticias();
    }

    private void getServiceNoticias(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(NoticiaConstants.URL_API)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        NoticiasService service = retrofit.create(NoticiasService.class);
        service.getNoticias().enqueue(new Callback<Noticia>() {
            @Override
            public void onResponse(Call<Noticia> call, Response<Noticia> response) {

            }

            @Override
            public void onFailure(Call<Noticia> call, Throwable t) {

            }
        });
    }

    private void addItemOnView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.card_view);
        this.toolbar = (Toolbar) findViewById(R.id.toolbar);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
