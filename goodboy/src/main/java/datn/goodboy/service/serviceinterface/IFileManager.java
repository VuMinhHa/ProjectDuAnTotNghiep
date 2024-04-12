package datn.goodboy.service.serviceinterface;

import java.io.File;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public interface IFileManager {
  String saveImage(MultipartFile multipartFile) throws IOException;

  File getFile(String name);

  boolean deletedFile(String name);
}
