package kodlamaio.hrms.entities.concretes;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import kodlamaio.hrms.entities.abstracts.BaseEmailVerification;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class WorkerEmailVerification extends BaseEmailVerification {

	@OneToOne()
	@JoinColumn(name = "user_id")
	private Worker worker;
}
