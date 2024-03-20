package br.com.exemplo.ekan.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "documento")
public class Documento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="tipo_documento", length=20, nullable=false)
	private String tipoDocumento;
	
	@Column(length=60, nullable=false)
	private String descricao;
	
	@JsonFormat(pattern="dd/MM/yyyy HH:mm:ss")
	@Column(name = "data_inclusao")
	private LocalDateTime dataInclusao;
	
	@JsonFormat(pattern="dd/MM/yyyy HH:mm:ss")
	@Column(name = "data_alteracao")
	private LocalDateTime dataAlteracao;
		
	@ManyToOne
	@JoinColumn(name = "beneficiario_id", nullable = false)
	@JsonIgnore
	private Beneficiario beneficiario;
		
	@PrePersist
	public void onPrePersist() {
		this.setDataInclusao(LocalDateTime.now());	        
	}

	@PreUpdate
	public void onPreUpdate() {
		this.setDataAlteracao(LocalDateTime.now());
	}

}
