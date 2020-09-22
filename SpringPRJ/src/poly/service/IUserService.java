package poly.service;

import poly.dto.UserDto;


public interface IUserService {

	UserDto getLoginInfo(UserDto uDto);

	int newUser(UserDto uDto) throws Exception;

}
