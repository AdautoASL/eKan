package br.com.exemplo.ekan.controller;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.exemplo.ekan.model.Beneficiario;
import br.com.exemplo.ekan.model.Documento;
import br.com.exemplo.ekan.service.BeneficiarioService;

@RestController
@RequestMapping("/beneficiarios")
public class BeneficiarioController {
	
	@Autowired
	private BeneficiarioService beneficiarioService;
		
	@GetMapping("/{id}")
	public Beneficiario findById(@PathVariable Long id){
		return beneficiarioService.findById(id);
	}
		
	@PostMapping
	public ResponseEntity<Beneficiario> addBeneficiario(@RequestBody Beneficiario beneficiario) {
		Beneficiario createdBeneficiario = beneficiarioService.addBeneficiario(beneficiario);
		return new ResponseEntity<>(createdBeneficiario, HttpStatus.CREATED);
	}
	
	@PostMapping({"/{id}/documento"})
	public ResponseEntity<Beneficiario> addDocumento(@PathVariable Long id, @RequestBody Documento documento) {
		return new ResponseEntity<>(beneficiarioService.addDocumento(id, documento), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Beneficiario> updateBeneficiario(@PathVariable Long id, @RequestBody Beneficiario beneficiario){
		return new ResponseEntity<>(beneficiarioService.updateBeneficiario(id, beneficiario), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBeneficiarioById(@PathVariable Long id) {
        beneficiarioService.deleteBeneficiario(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

	@GetMapping
	public List<Beneficiario> getAll(){
		return beneficiarioService.getAllBeneficiarios();
	}

}
