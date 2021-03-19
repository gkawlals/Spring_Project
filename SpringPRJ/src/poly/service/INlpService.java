package poly.service;

import poly.dto.NlpDTO;

public interface INlpService {

	void getWord() throws Exception;

	int preProcessWordAnalysisForMind(NlpDTO pDTO) throws Exception;
	
	int WordAnalysisForMind(String firstWord, String text) throws Exception;

}
