package WordCount;

import java.io.IOException;

import javax.naming.Context;
import javax.xml.soap.Text;

public class SumReducer extends Reducer<Text, IntWritable, Text, IntWritable>{
	
	@Override
	public void reduce (Text key, Iterable<IntWritable> values, Context context)
		throws IOException, IntterruptedException{
		// 시작전 wordCount 초기화 
		int wordCount = 0; 
		// iterater 작업시작 ( 맵에서 받아온 배열기준 )
		for(IntWritable value : values) {
			wordCount += value.get();
		}
		// Final Output을 1문장 기준으로 생성 
		context.write(key, new IntWritable(wordCount));
		
	}

}
