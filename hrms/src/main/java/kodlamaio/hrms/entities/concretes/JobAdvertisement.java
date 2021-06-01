package kodlamaio.hrms.entities.concretes;

import java.time.ZonedDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "job_advertisements")
public class JobAdvertisement {

	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

//	Taken from another class	
//	@Column(name = "position_id")
//	private int positionId;

//	Taken from another class
//	@Column(name = "employer_id")
//	private int employerId;

//	Taken from another class
//	@Column(name = "city_id")
//	private int cityId;

	@Column(name = "description")
	private String description;

	@Column(name = "quota")
	private int quota;

	@Column(name = "creation_date")
	private ZonedDateTime creationDate;

	@Column(name = "deadline_date")
	private ZonedDateTime deadlineDate;

	@Column(name = "is_active")
	private boolean isActive;

	@ManyToOne()
	@JoinColumn(name = "position_id", referencedColumnName = "id")
	private Position position;

	@ManyToOne()
	@JoinColumn(name = "employer_id", referencedColumnName = "user_id")
	private Employer employer;

	@ManyToOne()
	@JoinColumn(name = "city_id", referencedColumnName = "id")
	private City city;

	@OneToOne(mappedBy = "jobAdvertisement", cascade = CascadeType.ALL)
	private Salary salary;

}
