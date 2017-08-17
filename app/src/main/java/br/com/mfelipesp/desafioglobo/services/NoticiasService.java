package br.com.mfelipesp.desafioglobo.services;

import br.com.mfelipesp.desafioglobo.constants.NoticiaConstants;
import br.com.mfelipesp.desafioglobo.model.Noticia;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by marcos.pinto on 17/08/2017.
 */

public interface NoticiasService {

    // asynchronously with a callback
    @GET(NoticiaConstants.CAPA)
    Call<Noticia> getNoticias();

    // synchronously
    @POST("/api/Noticia/register")
    Noticia registerNoticia(@Body Noticia Noticia);
}
