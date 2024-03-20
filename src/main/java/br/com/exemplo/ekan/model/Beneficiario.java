package br.com.exemplo.ekan.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "beneficiario")
public class Beneficiario  implements Serializable {
		
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length=50, nullable=false)
	private String nome;
	
	@Column(length=15, nullable=false)
	private String telefone;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss") 
	@Column(name = "data_nascimento")
	private LocalDateTime dataNascimento;
	
	@JsonFormat(pattern="dd/MM/yyyy HH:mm:ss") 
	@Column(name = "data_inclusao")
	private LocalDateTime dataInclusao;
	
	@JsonFormat(pattern="dd/MM/yyyy HH:mm:ss") 
	@Column(name = "data_alteracao")
	private LocalDateTime dataAlteracao;
		
	@OneToMany(mappedBy = "beneficiario", cascade = CascadeType.ALL, orphanRemoval = true )
	//@JsonIgnore
	private List<Documento> documentos;	
	
	@PrePersist
	public void onPrePersist() {
		this.setDataInclusao(LocalDateTime.now());	        
	}

	@PreUpdate
	public void onPreUpdate() {
		this.setDataAlteracao(LocalDateTime.now());
	}
	
	/*
	public static Beneficiario convert(BeneficiarioDTO beneficiarioDTO) {
		Beneficiario beneficiario = new Beneficiario();
		beneficiario.setNome(beneficiarioDTO.getNome());
		beneficiario.setTelefone(beneficiarioDTO.getTelefone());
		beneficiario.setDataNascimento(beneficiarioDTO.getDataNascimento());
		beneficiario.setDataInclusao(beneficiarioDTO.getDataInclusao());
		beneficiario.setDataAlteracao(beneficiarioDTO.getDataAlteracao());
			
		if (beneficiarioDTO.getDocumentoDTO() != null) {
			beneficiario.setDocumentos(Documento.convert(beneficiarioDTO.getDocumentoDTO()));
		}
		
		return beneficiario;
	}
	*/
}
