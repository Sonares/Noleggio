package it.relatech.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Cliente {
	
	@Id
	@GeneratedValue
	private int id;
	
	private String nome;
	
	private String cognome;

	@OneToMany(mappedBy = "cliente")
	private List<Noleggio> listNoleggio;

	
	public Cliente() {
		listNoleggio = new ArrayList<>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public List<Noleggio> getListNoleggio() {
		return listNoleggio;
	}

	public void setListNoleggio(List<Noleggio> listNoleggio) {
		this.listNoleggio = listNoleggio;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", listNoleggio=" + listNoleggio + "]";
	}

	
	
}
