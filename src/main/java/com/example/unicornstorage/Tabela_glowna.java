package com.example.unicornstorage;

public class Tabela_glowna
{
    private String id;
    private String ilosc;
    private String ilosc_ostrzezenie;
    private String nazwa;
    private String producent;
    private String kategoria;
    private String podkategoria;
    private String opis;

    public Tabela_glowna(String id, String ilosc, String ilosc_ostrzezenie, String nazwa,
                         String producent, String kategoria,
                         String podkategoria, String opis)
    {
        this.id = id;
        this.ilosc = ilosc;
        this.ilosc_ostrzezenie = ilosc_ostrzezenie;
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
        return ilosc+" ("+ilosc_ostrzezenie+")";
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
