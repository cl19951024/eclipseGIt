package com.Test;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.IndexableField;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.store.RAMDirectory;
import org.apache.lucene.util.Version;
import org.apache.lucene.analysis.standard.StandardAnalyzer;  
import org.apache.lucene.document.Document;  
import org.apache.lucene.document.Field;  
import org.apache.lucene.index.IndexWriter;  
import org.apache.lucene.index.Term;  
import org.apache.lucene.search.BooleanClause;  
import org.apache.lucene.search.BooleanQuery;  

import org.apache.lucene.search.IndexSearcher;  
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.TopDocs;  
public class LuceneTest {
	
	public static void main(String[] args) {
//		//-------将需要查询的数据写入在内存之中（索引）---------
//		
//		/*一，定义一个词法分析器（比如一句话，“我爱我们的中国！”，如何对他拆分，扣掉停顿词“的”
//		 * 提取关键字“我”“我们”“中国”等等。这就要借助的词法分析器Analyzer来实现。）
//		*/
//		Analyzer analyzer =new StandardAnalyzer();
//		//二、存储方式有两种
//		//1）、本地文件存储：path：文件的路径
//		//Directory directory = FSDirectory.open(new File("F:\\luceneIndex"));
//		//2)内存存储
//		Directory directory = new RAMDirectory();
//		//三、创建索引文件写入
//		/*
//		 * new IndexWriterConfig是对IndexWriter进行配置，
//		 * 有两个参数，第一个参数是当前的版本号，
//		 *         第二个参数是词法分析器
//		 * */
//		IndexWriterConfig config = new IndexWriterConfig(Version.LUCENE_CURRENT, analyzer);
//		try {
//			//new IndexWriter有两个参数，
//			//第一个参数是内存的储存，第二个是IndexWriterConfig对IndexWriter的配置。
//			IndexWriter iwriter = new IndexWriter(directory, config);
//			//创建document文档对象，类似于数据库中的一行表。利用该对象将要查询的数据保存在内存中，
//			 Document doc = new Document();
//			 //定义要查询的数据，如果数据有多条将数据拼接成一个字符串传过去。
//			   String text1="你好，我是陈琳";
//			   String text2="index";
//			   String text3 = "你好，我是陈军";
//			  /*将数据字符添加到文档中， 
//			   * fieldname:数据的名称，类似于表名
//			   * TextField.TYPE_STORED：
//			   */
//			   doc.add(new TextField("text", text1, Store.YES));
//			   doc.add(new TextField("text", text2, Store.YES));
//			   doc.add(new TextField("text", text3, Store.YES));
//			  //将文档保存在内存中。
//			  iwriter.addDocument(doc);
//			  iwriter.close();
//			  
//			  //-----------进入查询--------------
//			  //一、打开储存位置
//			  DirectoryReader ireader = DirectoryReader.open(directory);
//			  //二、创建搜素器
//			  IndexSearcher isearcher = new IndexSearcher(ireader);
//			  //三、类似于sql语句，进行关键词查询
//			  /*
//			   * new QueryParser创建查询对象有三个参数
//			   * 第一个参数，当前版本号
//			   * 第二个参数：查询的文件的名称（类似于查询的表名）
//			   * 第三个参数：设置词法分析器
//			   * */
//			  QueryParser parser = new QueryParser(Version.LUCENE_CURRENT, "text", analyzer);
//			 //将要输入的内容保存在Query中，（text是将要查询的关键词。）
//			  Query query = parser.parse("index");
//			  //根据Searcher搜索返回TopDocs然后获取ScoreDoc（里面参数传入query的查询关键词，）  
//	          ScoreDoc[] hits = isearcher.search(query, null, 1000).scoreDocs;
		 
//			  //循环取出Searcher数组中的值，（及时查询出来的结果。）
//			  for (int i = 0; i < hits.length; i++) {
//				    //根据ScoreDoc获取具体Document对象并得到所需要的值  
//	                Document hitDoc = isearcher.doc(hits[i].doc);
//	             System.out.println("查询出来的值是:  "+hitDoc.get("text"));
//	            }
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//   }


	 
	
	        // TODO Auto-generated method stub  
	  
	        try{  
	        	Directory directory=FSDirectory.open(new File("D:\\index3"));
	              IndexWriterConfig config=new IndexWriterConfig(Version.LUCENE_CURRENT,new StandardAnalyzer());
	            		  IndexWriter writer = new IndexWriter(directory,config);
	              
	            //创建8个文档  
	            Document doc1 = new Document();  
	            Document doc2 = new Document();  
	            Document doc3 = new Document();  
	            Document doc4 = new Document();  
	            Document doc5 = new Document();  
	     
	            doc1.add(new TextField("bookname", "钢铁是怎样炼成的",Store.YES));  
	            doc2.add(new TextField("bookname", "英雄儿女",Store.YES));  
	            doc3.add(new TextField("bookname", "浮生六记",Store.YES));  
	            doc4.add(new TextField("bookname", "太平广记",Store.YES));  
	            doc5.add(new TextField("bookname", "文化苦旅",Store.YES));  
	          
	              
	            writer.addDocument(doc1);  
	            writer.addDocument(doc2);  
	            writer.addDocument(doc3);  
	            writer.addDocument(doc4);  
	            writer.addDocument(doc5);  
	       
	            writer.close();  
	              
	            System.out.println("创建索引成功");  
	            //一、打开储存位置
	            Analyzer analyzer=new StandardAnalyzer();
				  DirectoryReader ireader = DirectoryReader.open(directory);
//				  //二、创建搜素器
				  IndexSearcher isearcher = new IndexSearcher(ireader);
				  QueryParser parser = new QueryParser(Version.LUCENE_CURRENT, "bookname", analyzer);
//					 //将要输入的内容保存在Query中，（text是将要查询的关键词。）
				  Query query = parser.parse("文");
				  //根据Searcher搜索返回TopDocs然后获取ScoreDoc（里面参数传入query的查询关键词，）  
		          ScoreDoc[] hits = isearcher.search(query, null, 1000).scoreDocs;			 
				  //循环取出Searcher数组中的值，（及时查询出来的结果。）
				  for (int i = 0; i < hits.length; i++) {
					    //根据ScoreDoc获取具体Document对象并得到所需要的值  
		                Document hitDoc = isearcher.doc(hits[i].doc);
		             System.out.println("查询出来的值是:  "+hitDoc.get("bookname"));
		            }
	        }catch(Exception e){  
	            System.out.println(e.getStackTrace());  
	        }  
	
	  
		
		
	}
}
