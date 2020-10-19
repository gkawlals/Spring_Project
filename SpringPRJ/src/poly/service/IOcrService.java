package poly.service;

import poly.dto.OcrDto;

public interface IOcrService {
	
	OcrDto getReadforImageText(OcrDto pDTO ) throws Exception;

}
