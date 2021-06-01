package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Positive;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "salaries")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "jobAdvertisement" })
public class Salary {

	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
//	Taken from another class
//	@Column(name = "job_advertisement_id")
//	private int jobAdvertisementId;
	
	@Column(name = "min_salary")
	@Positive
	private Double minSalary;
	
	@Column(name = "max_salary")
	@Positive
	private Double maxSalary;
	
	@OneToOne()
    @JoinColumn(name = "job_advertisement_id", referencedColumnName = "id", nullable = true)
	private JobAdvertisement jobAdvertisement;
}
