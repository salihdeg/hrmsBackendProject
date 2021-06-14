package kodlamaio.hrms.core.adapters.concretes;

import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.*;
import com.cloudinary.utils.ObjectUtils;

import kodlamaio.hrms.core.adapters.abstracts.ImageService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;

@Service
public class CloudinaryAdapter implements ImageService {

	private Cloudinary cloudinary;

	public CloudinaryAdapter() {
		cloudinary = new Cloudinary(ObjectUtils.asMap(
				"cloud_name", "dbui4frse",
				"api_key", "265856145877154",
				"api_secret", "na88dXypyVpcXEenqYtj8HeMKVc"));
	}

	@Override
	public DataResult<String> uploadImage(MultipartFile file) throws IOException {
		var result = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.asMap("folder", "hrms/"));

		return new SuccessDataResult<String>(result.get("secure_url").toString());
	}

}
