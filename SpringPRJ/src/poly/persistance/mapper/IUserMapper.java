package poly.persistance.mapper;

import java.util.List;

import config.Mapper;
import poly.dto.UserDto;

@Mapper("UserMapper")
public interface IUserMapper {
	
	UserDto getLoginInfo(UserDto pDTO);
	//회원가입 
	int newUser(UserDto uDto);
	
	UserDto getUserExists(UserDto uDto);
	
	List<UserDto> UserList();
	
	//List<UserDto> getUserlist();

}
