package br.com.mfelipesp.desafioglobo.model;

import java.util.Date;

import lombok.*;
import lombok.experimental.Accessors;


/**
 * Created by marcos.pinto on 17/08/2017.
 */

@AllArgsConstructor
@NoArgsConstructor
@Accessors(fluent = false) // sem a palavra set
@Getter @Setter
@ToString
public class Noticia {
    private String foto;
    private String titulo;
    private String editora;
    private String subtitulo;
    private String autor;
    private Date dataHoraPublicacao;
    private String legendaFoto;
    private String texto;
}
