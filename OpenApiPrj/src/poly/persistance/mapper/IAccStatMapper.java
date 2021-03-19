package poly.persistance.mapper;

import java.util.List;

import config.Mapper;
import poly.dto.AccStatDTO;

@Mapper("AccStatMapper")
public interface IAccStatMapper {

	List<AccStatDTO> getAccStatInfo(AccStatDTO pDTO) throws Exception;
	
}
