package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "experiences")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "resume" })
public class Experience {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@ManyToOne()
	@JoinColumn(name = "resume_id", referencedColumnName = "id")
	private Resume resume;
	
	@Column(name = "company_name")
	@NotBlank
	private String companyName;
	
	@Column(name = "position_name")
	@NotBlank
	private String position;
	
	@Column(name = "start_date")
	@NotBlank
	private LocalDate startDate;
	
	@Column(name = "end_date")
	private LocalDate endDate;
}
