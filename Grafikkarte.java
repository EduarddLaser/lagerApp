package pk.lager;

public class Grafikkarte implements Ware{
    private int id;
    private int stueckzahl;
    private String modell;
    private String hersteller;

    public Grafikkarte(int stueckzahl, String modell, String hersteller){
        this.stueckzahl = stueckzahl;
        this.modell = modell;
        this.hersteller = hersteller;
        this.generateId();
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public int getStueckzahl() {
        return stueckzahl;
    }

    public void generateId() {
        int zahl = 0;
        for(int j = 0; j < this.modell.length(); j++){
            zahl+= this.modell.charAt(j);
        }
        for(int j = 0; j < this.hersteller.length(); j++){
            zahl+= this.hersteller.charAt(j);
        }
        this.setId(zahl);
    }

    public void setId(int id){
        this.id = id;
    }

    public String getModell() {
        return modell;
    }

    public String getHersteller() {
        return hersteller;
    }

    public void setStueckzahl(int stueckzahl) {
        this.stueckzahl = stueckzahl;
    }

    public void setHersteller(String hersteller) {
        this.hersteller = hersteller;
    }

    public void setModell(String modell) {
        this.modell = modell;
    }
}
