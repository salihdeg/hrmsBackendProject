package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.KnownLanguage;

public interface KnownLanguageService {
	Result add(KnownLanguage knownLanguage);
	DataResult<List<KnownLanguage>> getAll();
}
