package br.com.exemplo.ekan.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.exemplo.ekan.model.Beneficiario;
import br.com.exemplo.ekan.model.Documento;
import br.com.exemplo.ekan.repository.BeneficiarioRepository;
import br.com.exemplo.ekan.repository.DocumentoRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BeneficiarioService {
	
	private final BeneficiarioRepository beneficiarioRepository;
	
	private final DocumentoRepository documentoRepository;

	String BENEFICIARIO_NAO_ENCONTRADO = "Beneficiário não encontrado!";
	
	public Beneficiario findById(Long Id){
		return beneficiarioRepository.findById(Id).orElseThrow(() -> new RuntimeException(BENEFICIARIO_NAO_ENCONTRADO));
	
	}
	
	public Beneficiario addBeneficiario(Beneficiario beneficiario) {
		return beneficiarioRepository.save(beneficiario);
	}

	public Beneficiario addDocumento(Long id, Documento documento) {
		Beneficiario beneficiario = beneficiarioRepository.findById(id).orElseThrow(() -> new RuntimeException(BENEFICIARIO_NAO_ENCONTRADO));
		documento.setBeneficiario(beneficiario);
		Documento documentoSalvar = documentoRepository.save(documento);
		beneficiario.getDocumentos().add(documentoSalvar);
		beneficiarioRepository.save(beneficiario);

		return beneficiario;
	}
	 
    public Beneficiario updateBeneficiario(Long id, Beneficiario beneficiario){
    	Beneficiario existeBeneficiario = beneficiarioRepository.findById(id).orElseThrow(() -> new RuntimeException(BENEFICIARIO_NAO_ENCONTRADO));

    	existeBeneficiario.setNome(beneficiario.getNome());
    	existeBeneficiario.setTelefone(beneficiario.getTelefone());
    	existeBeneficiario.setDataNascimento(beneficiario.getDataNascimento());

        return beneficiarioRepository.save(existeBeneficiario);
    }


	public void deleteBeneficiario(Long id) {
		beneficiarioRepository.findById(id).orElseThrow(() -> new RuntimeException(BENEFICIARIO_NAO_ENCONTRADO));
		beneficiarioRepository.deleteById(id);
	}

	public List<Beneficiario> getAllBeneficiarios() {
        return beneficiarioRepository.findAll();
    }
	
}
