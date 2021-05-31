package kodlamaio.hrms.entities.dtos;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployerRegisterDto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "email")
	@NotBlank(message = "Email Cannot Be Empty or Blank")
	@Email(message = "This Is Not An Email")
	private String email;
	
	@Column(name = "password")
	@NotBlank(message = "Password Cannot Be Empty or Blank")
	private String password;
	
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
}
