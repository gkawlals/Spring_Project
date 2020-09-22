package poly.service;

import java.util.List;

import poly.dto.EmpDto;

public interface IEmpService {

	List<EmpDto> getEmpList();

	List<EmpDto> getEmpMgrList();


}
