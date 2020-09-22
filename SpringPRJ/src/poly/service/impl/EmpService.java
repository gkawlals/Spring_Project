package poly.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import poly.dto.EmpDto;
import poly.persistance.mapper.IEmpMapper;
import poly.service.IEmpService;

@Service("EmpService")
public class EmpService implements IEmpService{

	@Resource(name="EmpMapper")
	IEmpMapper EmpMapper;
	
	@Override
	public List<EmpDto> getEmpList() {
		
		return EmpMapper.getEmpList();
	}
	
	@Override
	public List<EmpDto> getEmpMgrList() {
		
		return EmpMapper.getEmpMgrList();
	}


	
}
