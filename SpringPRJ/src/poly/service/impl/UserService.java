package poly.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import poly.dto.UserDto;
import poly.persistance.mapper.IUserMapper;
import poly.service.IUserService;
import poly.util.CmmUtil;

@Service("UserService")
public class UserService implements IUserService{
	
	@Resource(name="UserMapper")
	IUserMapper UserMapper;

	@Override
	public UserDto getLoginInfo(UserDto uDto) {
		// TODO Auto-generated method stub
		return UserMapper.getLoginInfo(uDto);
	}
	
	@Override
	public int newUser(UserDto uDto) {
		// TODO Auto-generated method stub
		int res = 0;
		
		// 들어오는 결과값이 없을때 새로운것을 메모리로 올린다. 
		if(uDto == null) {
			uDto = new UserDto();
		}
		
		//회원가입 중복 방지를 위한 DB조회
		UserDto rDTO = UserMapper.getUserExists(uDto);
		
		//mapper에서 값이 정상적으로 못 넘어오는 경우 대비하기위해 사용
		if(rDTO == null) {
			rDTO = new UserDto();
		}
		
		// 중복된 회원가입이 있는겨우 결과값을 2로 변경하고 더이상 진행되지 않게 한다
		if(CmmUtil.nvl(rDTO.getExists_yn()).equals("Y")) {
			res = 2;
		}else { 
			int success = UserMapper.newUser(uDto);
			
			if(success > 0) {
				res = 1;
			}else {
				res = 0;
			}
		}
		return res;
	}

}
