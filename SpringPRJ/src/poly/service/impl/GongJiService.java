package poly.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import poly.dto.GongDto;
import poly.persistance.mapper.IGongJiMapper;
import poly.service.IGongJiService;

@Service("GongJiService")
public class GongJiService implements IGongJiService {
	
	@Resource(name ="GongJiMapper")
	IGongJiMapper GongJiMapper;

	@Override
	public List<GongDto> getGongJiList() {
		// TODO Auto-generated method stub
		return GongJiMapper.getGongJiList();
	}

	@Override
	public List<GongDto> searchGongji(GongDto pDTO) {
		// TODO Auto-generated method stub
		return null;
	}

}
