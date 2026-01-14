package com.example.unicornstorage;

public class Tabela_glowna
{
    private String id;
    private String ilosc;
    private String iloscOstrzezenie;
    private String ilosc_ostrzezenie;
    private String nazwa;
    private String producent;
    private String kategoria;
    private String podkategoria;
    private String opis;

    public Tabela_glowna(String id, String ilosc, String iloscOstrzezenie, String nazwa,
                         String producent, String kategoria,
                         String podkategoria, String opis)
    {
        this.id = id;
        this.ilosc = ilosc;
        this.iloscOstrzezenie = iloscOstrzezenie;
        this.nazwa = nazwa;
        this.producent = producent;
        this.kategoria = kategoria;
        this.podkategoria = podkategoria;
        this.opis = opis;
    }

    public String getId()
    {
        return id;
    }

    public String getIlosc()
    {
        return ilosc;
    }
    public String getIloscOstrzezenie(){
        return iloscOstrzezenie;
    }

    public String getNazwa()
    {
        return nazwa;
    }

    public String getProducent()
    {
        return producent;
    }

    public String getKategoria()
    {
        return kategoria;
    }

    public String getPodkategoria()
    {
        return podkategoria;
    }

    public String getOpis()
    {
        return opis;
    }
}
