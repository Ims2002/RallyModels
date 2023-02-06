package com.ims.rallyModels;

import com.ims.rallyModels.modelo.MaquetaEntity;
import com.ims.rallyModels.repositorio.IMaquetasRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RallyModelsApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(RallyModelsApplication.class, args);
	}

	@Autowired
	private IMaquetasRepositorio repositorio;

	@Override
	public void run(String... args) throws Exception {
		/*
		MaquetaEntity ds = new MaquetaEntity(10,"Hyundai I20 Dani Sordo",14.99,5,2);
		repositorio.save(ds);

		MaquetaEntity kr = new MaquetaEntity(9,"Toyota Yaris Kalle Rovanperä",14.99,6,1);
		repositorio.save(kr);
		
		MaquetaEntity sl = new MaquetaEntity(11,"Ford Puma Sebastien Loeb",17.99,6,3);
		repositorio.save(sl);
		*/
	}
}

