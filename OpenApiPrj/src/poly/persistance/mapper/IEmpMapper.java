package poly.persistance.mapper;

import java.util.List;

import config.Mapper;
import poly.dto.EmpDto;

@Mapper("EmpMapper")
public interface IEmpMapper {

	List<EmpDto> getEmpList();
	
	List<EmpDto> getEmpMgrList();

}
