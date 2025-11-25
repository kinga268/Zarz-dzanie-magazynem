package com.example.unicornstorage;

public class MagazynItem
{
    private int id;
    private int ilosc;
    private String nazwa;
    private String producent;
    private String kategoria;
    private String podkategoria;
    private String opis;

    public MagazynItem(int id, int ilosc, String nazwa,
                       String producent, String kategoria,
                       String podkategoria, String opis)
    {
        this.id = id;
        this.ilosc = ilosc;
        this.nazwa = nazwa;
        this.producent = producent;
        this.kategoria = kategoria;
        this.podkategoria = podkategoria;
        this.opis = opis;
    }

    public int getId()
    {
        return id;
    }

    public int getIlosc()
    {
        return ilosc;
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
