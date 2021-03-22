package pk.lager;

	public class Lagerdaten {
	    public static void main(String[] args) throws Exception {
	        Lager lager = new Lager(1, "Dortmund", 100);
	        Lager lager2 = new Lager(2, "Schwerte", 10);
	        Lager lager3 = new Lager(3, "Witten", 5);	
	        lager.test();
	        System.out.println(lager.getBestandsliste());

	    }

}
