package m2i.formation.daoFile;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

import m2i.formation.dao.IMatiereDao;
import m2i.formation.model.Difficulte;
import m2i.formation.model.Matiere;

public class MatiereDaoFile implements IMatiereDao {

	@Override
	public List<Matiere> findAll() {
		List<Matiere> matieres = read();
		return matieres;
	}
	
	@Override
	public Matiere findById(Long id) {
		List<Matiere> matieres = read();

		for (Matiere matiere : matieres) {
			if (matiere.getId() == id) {
				return matiere;
			}
		}
		return null;
	}
	
	@Override
	public void create(Matiere obj) {
		List<Matiere> matieres = read();
		long max = 0;
		for (Matiere matiere : matieres) {
			if (matiere.getId() > max) {
				max = matiere.getId();
			}
		}
		max++;
		obj.setId(max);
		matieres.add(obj);
		write(matieres);
	}
	
	@Override
	public void update(Matiere obj) {
		List<Matiere> matieres = read();
		int index = 0;
		boolean find = false;
		for (; index < matieres.size(); index++) {
			if (obj.getId() == matieres.get(index).getId()) {
				find = true;
				break;
			}
		}
		if (find) {
			matieres.set(index, obj);
			write(matieres);
		} else {
			throw new RuntimeException("Matière n° " + obj.getId() + " non trouvée.");
		}
	}

	@Override
	public void delete(Long id) {
		List<Matiere> matieres = read();
		int index = 0;
		boolean find = false;
		for (; index < matieres.size(); index++) {
			if (id == matieres.get(index).getId()) {
				find = true;
				break;
			}
		}
		if (find) {
			matieres.remove(index);
			write(matieres);
		} else {
			throw new RuntimeException("Matière n° " + id + " non trouvée.");
		}
	}

	@Override
	public List<Matiere> findAllByDifficulte(Difficulte difficulte) {
		List<Matiere> matieres = new ArrayList<Matiere>();
		for (Matiere matiere : read()) {
			if (matiere.getDifficulte().equals(difficulte)) {
				matieres.add(matiere);
			}
		}
		return matieres;
	}

	private List<Matiere> read() {
		List<Matiere> matieres = new ArrayList<Matiere>();
		Path path = Paths.get("matieres.csv");
		if (path.toFile().exists()) {
			try {
				List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
				for (String line : lines) {
					String[] items = line.split(";");
					String csvId = items[0];
					String csvNom = items[1];
					String csvDuree = items[2];
					String csvDifficulte = items[3];
					Long id = Long.valueOf(csvId);
					String nom = csvNom;
					int duree = Integer.valueOf(csvDuree);
					Difficulte difficulte = Difficulte.valueOf(csvDifficulte);
					Matiere matiere = new Matiere(id, nom, duree, difficulte);
					matieres.add(matiere);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return matieres;
	}
	
	private void write(List<Matiere> matieres) {
		List<String> lines = new ArrayList<String>();
		for (Matiere matiere : matieres) {
			StringBuilder sb = new StringBuilder();
			sb.append(matiere.getId()).append(";");
			sb.append(matiere.getNom()).append(";");
			sb.append(matiere.getDuree()).append(";");
			sb.append(matiere.getDifficulte());
			String line = sb.toString();
			lines.add(line);
		}
		Path path = Paths.get("matieres.csv");
		try {
			Files.write(path, lines, StandardCharsets.UTF_8, StandardOpenOption.CREATE,
					StandardOpenOption.TRUNCATE_EXISTING);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}