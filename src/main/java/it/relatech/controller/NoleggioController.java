package it.relatech.controller;

import java.util.List;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.relatech.model.Cliente;
import it.relatech.model.Veicolo;
import it.relatech.services.ClienteService;

@RestController
@RequestMapping("/noleggio")
public class NoleggioController {
	
	private final Logger logger = Logger.getLogger(NoleggioController.class.getName());
	
	@Autowired
	private NoleggioService noleggioService;
	
	@GetMapping("/getModel")
	public Cliente getNoleggioModel() {
		return new Noleggio();
	}
	
	@PostMapping("/save")
	public ResponseEntity<Noleggio> saveNoleggio(@RequestBody Noleggio noleggio){
		try {
			Noleggio savedNoleggio = noleggioService.saveNoleggio(noleggio);
			logger.info("Noleggio inserito: \n" + noleggio);
			return new ResponseEntity<Noleggio>(savedNoleggio, HttpStatus.CREATED);
		} catch (Exception e) {
			logger.info("Errore: " + e);
			return new ResponseEntity<Noleggio>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	

	@PutMapping("/restituisci")
	public ResponseEntity<Noleggio> restituisci(@RequestBody Noleggio noleggio){
		try {
			Noleggio savedNoleggio = noleggioService.restituisci(noleggio);
			logger.info(" restituito: \n" + noleggio);
			return new ResponseEntity<Noleggio>(noleggio, HttpStatus.OK);
		} catch (Exception e) {
			logger.info("Errore: " + e);
			return new ResponseEntity<Veicolo>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	

}