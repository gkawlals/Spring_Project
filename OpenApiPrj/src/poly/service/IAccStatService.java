package poly.service;

import java.util.List;

import poly.dto.AccStatDTO;

public interface IAccStatService {
	
	List<AccStatDTO> getAccStatInfo(AccStatDTO pDTO) throws Exception;

}
