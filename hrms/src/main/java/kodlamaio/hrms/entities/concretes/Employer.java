package kodlamaio.hrms.entities.concretes;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employers")
@PrimaryKeyJoinColumn(name = "user_id", referencedColumnName = "id")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "adminVerification", "employerEmailVerification" })
public class Employer extends User {

	@Column(name = "company_name")
	@NotBlank(message = "Company Name Cannot Be Empty or Blank")
	private String companyName;

	@Column(name = "web_site")
	@NotBlank(message = "Web Site Cannot Be Empty or Blank")
	private String webSite;

	@Column(name = "phone_number")
	@Size(min = 10, max= 11)
	@NotBlank(message = "Phone Number Cannot Be Empty or Blank")
	private String phoneNumber;
	
	@OneToOne(mappedBy = "employer")
	private AdminVerification adminVerification;
	
	@OneToOne(mappedBy = "employer")
	private EmployerEmailVerification employerEmailVerification;
	
	
}
