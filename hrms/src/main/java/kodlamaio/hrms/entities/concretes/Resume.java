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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "resumes")
public class Resume {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@ManyToOne()
	@JoinColumn(name = "worker_id", referencedColumnName = "user_id")
	private Worker worker;
	
	@OneToMany(mappedBy = "resume")
	private List<EducationInfo> educationInfos;
	
	@OneToMany(mappedBy = "resume")
	private List<Experience> experiences;
	
	@OneToMany(mappedBy = "resume")
	private List<KnownLanguage> knownLanguages;
	
	@OneToMany(mappedBy = "resume")
	private List<WorkerSkill> workerSkills;
	
	@OneToMany(mappedBy = "resume")
	private List<SocialAccount> socialAccounts;
	
	@OneToMany(mappedBy = "resume")
	private List<WorkerPicture> workerPictures;
	
	@OneToMany(mappedBy = "resume")
	private List<CoverLetter> coverLetters;
}
