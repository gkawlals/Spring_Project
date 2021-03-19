package WordCount;

import java.io.IOException;

import javax.naming.Context;
import javax.xml.soap.Text;

import org.apache.catalina.mapper.Mapper;

public class WordMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

	@Override
	public void map(LongWritable key, Text value, Context context) 
			throws IOException, InterruptedException{
		String line = value.toString();
		// 공백을 기준(단어 띄어쓰기 ) 나누기 
		for (String word : line.split("\\W+")) {
			
			// 단어의 유무 판단 
			if(word.length() > 0) {
				// 단어가 선택되었을 때, 단어옆에 1을 같이 넣어줌 
				context.write(new Text(word), new IntWritable(1));
			}
		}
	}

}
