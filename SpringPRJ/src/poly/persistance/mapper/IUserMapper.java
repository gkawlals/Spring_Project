package poly.persistance.mapper;

import config.Mapper;
import poly.dto.UserDto;

@Mapper("UserMapper")
public interface IUserMapper {
	
	UserDto getLoginInfo(UserDto uDto);
	//회원가입 
	int newUser(UserDto uDto);
	
	UserDto getUserExists(UserDto uDto);

}
