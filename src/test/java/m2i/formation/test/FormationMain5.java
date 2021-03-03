package m2i.formation.test;

import m2i.formation.Application;
import m2i.formation.dao.IAdresseDao;
import m2i.formation.model.Adresse;

public class FormationMain5 {

	public static void testAdresseDao() {
		IAdresseDao adresseDao = Application.getInstance().getAdresseDao();
		Adresse ericAdresse = new Adresse("1 rue de la Paix", "", "75008", "Paris", "France");
		Adresse benoitAdresse = new Adresse("1 place du centre", "", "59000", "Lille", "France");
		Adresse romainAdresse = new Adresse("1 rue Sainte Catherine", "", "33000", "Bordeaux", "France");
		Adresse alexandreAdresse = new Adresse("1 place du Capitole", "", "86000", "Poitiers", "France");
		Adresse cyrilAdresse = new Adresse("1 plaza de milano", "", "445211", "Parme", "Italie");
		adresseDao.create(ericAdresse);
		adresseDao.create(benoitAdresse);
		adresseDao.create(romainAdresse);
		adresseDao.create(alexandreAdresse);
		adresseDao.create(cyrilAdresse);
		for (Adresse adresse : adresseDao.findAll()) {
			System.out.println(adresse.getId());
		}
		Adresse findAdresse = adresseDao.findById(2L);
		findAdresse.setComplement("labas");
		adresseDao.update(findAdresse);
		adresseDao.delete(2L);
		for (Adresse adresse : adresseDao.findAll()) {
			System.out.println(adresse.getId());
		}
	}

	public static void main(String[] args) {
		testAdresseDao();
	}

}