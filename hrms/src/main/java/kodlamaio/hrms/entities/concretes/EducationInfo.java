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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "education_infos")
public class EducationInfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@ManyToOne()
	@JoinColumn(name = "resume_id", referencedColumnName = "id")
	private Resume resume;
	
	@ManyToOne()
	@JoinColumn(name = "school_id", referencedColumnName = "id")
	private School school;
	
	@ManyToOne()
	@JoinColumn(name = "faculty_id", referencedColumnName = "id")
	private Faculty faculty;
	
	@ManyToOne()
	@JoinColumn(name = "department_id", referencedColumnName = "id")
	private Department department;
	
	@Column(name = "start_date")
	@NotBlank()
	private LocalDate startDate;
	
	@Column(name = "end_date")
	private LocalDate endDate;

}
