package com.example;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

class aula {
    String nome;
    String numeroDiBanchi;

    public String getNome() {
        return nome;
    }

    public String getNumeroDiBanchi() {
        return numeroDiBanchi;
    }
}


class element {

    String annoDiNascita;
    String cognome;
    String nome;

    public String getAnnoDiNascita() {
        return annoDiNascita;
    }

    public String getCognome() {
        return cognome;
    }

    public String getNome() {
        return nome;
    }

}


class root {
    private String annoDiInizio;
    aula aula;
    String classe;
    String numeroFinestre;
    String specializzazione;
    ArrayList<element> studenti;

    public String getAnnoDiInizio() {
        return annoDiInizio;
    }

    public aula getAula() {
        return aula;
    }

    public String getClasse() {
        return classe;
    }

    public String getNumeroFinestre() {
        return numeroFinestre;
    }

    public String getSpecializzazione() {
        return specializzazione;
    }

    public ArrayList<element> getStudenti() {
        return studenti;
    }
}


public class SerializeAndDeserialize
{
    public static void main( String[] args ) throws JsonParseException, JsonMappingException, IOException
    {

          /* Deserialize */
        
        File file = new File("src/main/resources/classe.xml");
        XmlMapper xmlMapper = new XmlMapper();
        root value = xmlMapper.readValue(file, root.class);
        System.out.println("La classe " + value.getClasse() + " " + value.getSpecializzazione() + " si trova nell'aula "
                + value.getAula().getNome() + " ed è composta dai seguenti studenti: ");

        for (int i = 0; i < value.getStudenti().size(); i++) {
            System.out.println("- " + value.getStudenti().get(i).getCognome());

        }

          /* Fine Deserialize */

         
          /* Inizio Serialize */

          xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);
          xmlMapper.writeValue(new File("src/main/ClasseSerializzata.xml"), value);

          /* Fine Serialize */

    }
}
