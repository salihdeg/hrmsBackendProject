package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ResumeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ResumeDao;
import kodlamaio.hrms.entities.concretes.Resume;

@Service
public class ResumeManager implements ResumeService {

	private ResumeDao resumeDao;

	@Autowired
	public ResumeManager(ResumeDao resumeDao) {
		super();
		this.resumeDao = resumeDao;
	}

	@Override
	public Result add(Resume resume) {
		this.checkAndSetFieldsForResume(resume);
		this.resumeDao.save(resume);
		return new SuccessResult("Resume added");
	}

	@Override
	public DataResult<List<Resume>> getAll() {
		var result = this.resumeDao.findAll();
		return new SuccessDataResult<List<Resume>>(result, "All Resumes Listed");
	}

	private void setEductaionInfosIfExist(Resume resume) {
		if (!resume.getEducationInfos().isEmpty()) {
			for (var educationInfos : resume.getEducationInfos()) {
				educationInfos.setResume(resume);
			}
		}
	}

	private void setExperiencesIfExist(Resume resume) {
		if (!resume.getExperiences().isEmpty()) {
			for (var experiences : resume.getExperiences()) {
				experiences.setResume(resume);
			}
		}
	}

	private void setWorkerSkillsIfExist(Resume resume) {
		if (!resume.getWorkerSkills().isEmpty()) {
			for (var workerSkills : resume.getWorkerSkills()) {
				workerSkills.setResume(resume);
			}
		}
	}

	private void setKnownLanguagesIfExist(Resume resume) {
		if (!resume.getKnownLanguages().isEmpty()) {
			for (var knownLanguages : resume.getKnownLanguages()) {
				knownLanguages.setResume(resume);
			}
		}
	}

	private void setSocialAccountsIfExist(Resume resume) {
		if (!resume.getSocialAccounts().isEmpty()) {
			for (var socialAccounts : resume.getSocialAccounts()) {
				socialAccounts.setResume(resume);
			}
		}
	}

	private void setWorkerPicturesIfExist(Resume resume) {
		if (!resume.getWorkerPictures().isEmpty()) {
			for (var workerPictures : resume.getWorkerPictures()) {
				workerPictures.setResume(resume);
			}
		}
	}

	private void setCoverLettersIfExist(Resume resume) {
		if (!resume.getCoverLetters().isEmpty()) {
			for (var coverLetters : resume.getCoverLetters()) {
				coverLetters.setResume(resume);
			}
		}
	}

	private void checkAndSetFieldsForResume(Resume resume) {
		this.setCoverLettersIfExist(resume);
		this.setEductaionInfosIfExist(resume);
		this.setExperiencesIfExist(resume);
		this.setKnownLanguagesIfExist(resume);
		this.setSocialAccountsIfExist(resume);
		this.setWorkerPicturesIfExist(resume);
		this.setWorkerSkillsIfExist(resume);
	}
}
