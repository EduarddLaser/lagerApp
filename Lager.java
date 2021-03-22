package pk.lager;


public class Lager {
    private final int id;
    private final String bezeichnung;
    private int kapazitaet;
    private Ware[] gelagerteWaren;
    int index = 0;

    public Lager(int id, String bezeichnung, int kapazitaet) {
        this.id = id;
        this.bezeichnung = bezeichnung;
        this.kapazitaet = kapazitaet;
        this.gelagerteWaren = new Ware[kapazitaet - 1];
    }

    public void addWare(Ware wareToAdd) throws Exception {

        if (this.getKapazitaet() - wareToAdd.getStueckzahl() < 0) {
            throw new Exception("Fehler: Die Stückzahl überschreitet die verfügbare Lagerkapazität.");
        } else {
            for (int j = 0; j < this.getGelagerteWaren().length; j++) {
                if (this.getGelagerteWaren()[j] == null) {
                    j++;
                } else if (this.getGelagerteWaren()[j].getId()==(wareToAdd.getId())) {
                    throw new Exception("Fehler: Der Artikel befindet sich bereits im Bestand");
                }
            }
            for (int j = 0; j < this.getGelagerteWaren().length; j++)
                if (this.getGelagerteWaren()[j] != null) {
                    j++;
                } else {
                    this.getGelagerteWaren()[j] = wareToAdd;
                    this.kapazitaet -= wareToAdd.getStueckzahl();
                    j = this.getGelagerteWaren().length;
                }
        }
    }

    public void removeWare(Ware wareToRemove) {
        for (int j = 0; j < this.getGelagerteWaren().length; j++) {
            if (this.getGelagerteWaren()[j] == null) {
                j++;
            } else if (this.gelagerteWaren[j].getId()==(wareToRemove.getId())) {
                this.kapazitaet += this.gelagerteWaren[j].getStueckzahl();
                this.gelagerteWaren[j] = null;
                j = this.getGelagerteWaren().length;
            }
        }
    }

    public Ware[] getGelagerteWaren() {
        return gelagerteWaren;
    }

    public String getBestandsliste() {
        String bestand = "";
        for (int j = 0; j < this.getGelagerteWaren().length; j++) {
            if (this.getGelagerteWaren()[j] == null) {
                j++;
            } else {
                bestand = bestand + (Integer.toString(this.getGelagerteWaren()[j].getStueckzahl()) + "x "
                        + Integer.toString(this.getGelagerteWaren()[j].getId()) + " "
                        + this.getGelagerteWaren()[j].getHersteller() + " "
                        + this.getGelagerteWaren()[j].getModell()) + " ";
            }
        }
        return bestand;
    }

    public int getKapazitaet() {
        return this.kapazitaet;
    }

    public void test() throws Exception {
        Ware grafikkarte = new Grafikkarte(5, "RTX3080", "MSI");
        Ware grafikkarte2 = new Grafikkarte(5, "RTX3080", "Asus");
        Ware Cpu = new Cpu(3, "Ryzen5900X", "AMD");
        addWare(grafikkarte);
        addWare(grafikkarte2);
        removeWare(grafikkarte2);
        addWare(Cpu);
    }

}
