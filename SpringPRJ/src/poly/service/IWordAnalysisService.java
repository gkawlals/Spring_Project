package poly.service;

import java.util.List;
import java.util.Map;

import poly.dto.WordAnalysisDTO;

public interface IWordAnalysisService {
	
	/**
	 * 자연어 차리 - 형태소 분석 ( 명사만 추가하기 )
	 * 
	 * @pram 분석할 문장
	 * @return 분석된 결과 
	 */
	
	List<String>doWordNouns(String text) throws Exception;
	
	/**
	 * 	빈도수 분석 ( 단어별 출현 빈도수 )
	 * 
	 * @pram 명사만 추출된 단어 모음 ( 리스트 )
	 * @return 분석된 결과 
	 */
	
	Map<String, Integer>doWordCount(List<String> pList) throws Exception;
	
	/**
	 * 	분석할 문장의 자연어 처리 및 빈도수 분석 실행 
	 * 
	 * @pram 분석할 문장
	 * @return 분석된 결과
	 */
	
	Map<String, Integer> doWordAnalysis(String text) throws Exception;

	/*
	 * 받아온 행시의 문장 저장할때 데이터 사전 저장하기
	 * @pram 분석할 문장
	 * @return 데이터 사전 저장
	 * */
	
	int insertData(WordAnalysisDTO pDTO);

}
