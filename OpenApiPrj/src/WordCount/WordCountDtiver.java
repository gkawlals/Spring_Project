package WordCount;

import javax.xml.soap.Text;

public class WordCountDtiver {

	public static void main(String[] args) {
		if (args.length != 2) {
			System.out.printf("Usage : WordCount <input dir> <output> \n");
			System.exit(-1);
		}
		// 맵리듀스 실행을 위한 Job
		Job job = new Job();
		// 드라이버 선택 
		job.setJarByClass(WordCountDriver.class);
		// 이름 설정 
		job.setJobName("Word Count");
		// 읽는 방식을 결정 (Recode Reader) 
		FileInputFormat.setInputPaths(job, new Path(args[0]));
		FileOutputFormay.setOutputPath(job, new Path(args[1]));
		// 사용할 맵퍼, 리듀서 설정( 선탟? )
		job.setMapperClass(WordMapper.class);
		job.setReducerClass(SumReducer.class);
		// 하둡은 Map의 형태로 받는다 즉, key와 value타입이 필요 = key와 value을 지정함 
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);
		
		boolean success = job.waitForCompletion(true);
		System.exit(success ? 0 : 1);

	}

}
