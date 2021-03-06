package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "schools")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "faculties", "educationInfos", "departments" })
public class School {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "school_name")
	private String schoolName;
	
	@ManyToOne()
	@JoinColumn(name = "city_id", referencedColumnName = "id")
	private City city;
	
	@OneToMany(mappedBy = "school")
	private List<Faculty> faculties;
	
	@OneToMany(mappedBy = "school")
	private List<Department> departments;
	
	@OneToMany(mappedBy = "school")
	private List<EducationInfo> educationInfos;
	
}
