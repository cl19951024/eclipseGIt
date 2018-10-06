package com.Test;

import java.io.File;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.apache.lucene.document.TextField;

public class LuceneDemo {
	
	public static void main(String[] args) {
		   try{  
	        	Directory directory=FSDirectory.open(new File("C:/index3"));
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
	            doc5.add(new TextField("bookname", "文333",Store.YES));  
	          
	              
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
	/**
	 * 
     //生成Document对象  
    Document doc1 = new Document();  
     //添加“name”字段的内容  
    doc1.add(Field.Text("name", "word1 word2 word3"));  
     //添加“title”字段的内容  
    doc1.add(Field.Keyword("title", "doc1"));  
     //生成索引书写器  
    IndexWriter writer = new IndexWriter("c://index", new StandardAnalyzer(), true);  
       
    //将文档添加到索引中  
    writer.addDocument(doc1);  
     //关闭索引  
    writer.close();  
   
     //生成查询对象query  
    Query query = null;  
       
    //生成hits结果对象，保存返回的检索结果  
    Hits hits = null;  
      
     //生成检索器  
    IndexSearcher searcher = new IndexSearcher("c://index");  
      
     // 构造一个TermQuery对象  
    query = new TermQuery(new Term("name","word1"));  
     //开始检索，并返回检索结果到hits中  
    hits = searcher.search(query);  
     //输出检索结果中的相关信息  
    printResult(hits, "word1");  
   
     // 再次构造一个TermQuery对象，只不过查询的字段变成了"title"  
    query = new TermQuery(new Term("title","doc1"));  
     //开始第二次检索，并返回检索结果到hits中  
    hits = searcher.search(query);  
     //输出检索结果中的相关信息  
    printResult(hits, "doc1");  
   
  }  
   
  public static void printResult(Hits hits, String key) throws Exception  
  {  
    System.out.println("查找 /"" + key + "/" :");  
    if (hits != null)  
    {  
      if (hits.length() == 0)  
      {  
        System.out.println("没有找到任何结果");  
      }  
      else  
      {  
        System.out.println("找到" + hits.length() + "个结果");  
        for (int i = 0; i < hits.length(); i++)  
        {  
          Document d = hits.doc(i);  
          String dname = d.get("title");  
          System.out.print(dname + "   ");  
        }  
        System.out.println();  
        System.out.println();  
      }  
    }  
  }  
}  
	 * @param args
	 */
	

}
