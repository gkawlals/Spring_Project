package poly.persistance.mapper;

import config.Mapper;
import poly.dto.FoodDto;

@Mapper("FoodMapper")
public interface IFoodMapper {

	int InsertFoodInfo(FoodDto pDTO) throws Exception;
	
}
