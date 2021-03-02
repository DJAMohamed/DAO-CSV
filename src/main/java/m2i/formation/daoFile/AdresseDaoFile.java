package m2i.formation.daoFile;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

import m2i.formation.dao.IAdresseDao;
import m2i.formation.model.Adresse;

public class AdresseDaoFile implements IAdresseDao {

	@Override
	public List<Adresse> findAll() {
		List<Adresse> adresses = read();
		return adresses;
	}

	@Override
	public Adresse findById(Long id) {
		List<Adresse> adresses = read();
		for (Adresse adresse : adresses) {
			if (adresse.getId() == id) {
				return adresse;
			}
		}
		return null;
	}

	public void create(Adresse obj) {
		List<Adresse> adresses = read();
		long max = 0;
		for (Adresse adresse : adresses) {
			if (adresse.getId() > max) {
				max = adresse.getId();
			}
		}
		max++;
		obj.setId(max);
		adresses.add(obj);
		write(adresses);
	}

	@Override
	public void update(Adresse obj) {
		List<Adresse> adresses = read();
		int index = 0;
		boolean find = false;
		for (; index < adresses.size(); index++) {
			if (obj.getId() == adresses.get(index).getId()) {
				find = true;
				break;
			}
		}
		if (find) {
			adresses.set(index, obj);
			write(adresses);
		} else {
			throw new RuntimeException("Asresse n° " + obj.getId() + " non trouvée.");
		}
	}

	@Override
	public void delete(Long id) {
		List<Adresse> adresses = read();
		int index = 0;
		boolean find = false;
		for (; index < adresses.size(); index++) {
			if (id == adresses.get(index).getId()) {
				find = true;
				break;
			}
		}
		if (find) {
			adresses.remove(index);
			write(adresses);
		} else {
			throw new RuntimeException("Adresse n° " + id + " non trouvée.");
		}
	}

	private List<Adresse> read() {
		List<Adresse> adresses = new ArrayList<Adresse>();
		Path path = Paths.get("adresses.csv");
		File file = path.toFile(); // Les propriétés du fichier.
		if (file.exists()) {
			try {
				List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
				for (String line : lines) {
					String[] items = line.split(";");
					Long id = Long.valueOf(items[0]);
					String rue = items[1];
					String complement = items[2];
					String codePostal = items[3];
					String ville = items[4];
					String pays = items[5];
					Adresse adresse = new Adresse(id, rue, complement, codePostal, ville, pays);
					adresses.add(adresse);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return adresses;
	}

	private void write(List<Adresse> adresses) {
		List<String> lines = new ArrayList<String>();
		for (Adresse adresse : adresses) {
			StringBuilder sb = new StringBuilder();
			sb.append(adresse.getId()).append(";");
			sb.append(adresse.getRue()).append(";");
			sb.append(adresse.getComplement()).append(";");
			sb.append(adresse.getCodePostal()).append(";");
			sb.append(adresse.getVille()).append(";");
			sb.append(adresse.getPays()).append(";");
			String line = sb.toString();
			lines.add(line);
		}

		Path path = Paths.get("adresses.csv");
		try {
			Files.write(path, lines, StandardCharsets.UTF_8, StandardOpenOption.CREATE,
					StandardOpenOption.TRUNCATE_EXISTING);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}