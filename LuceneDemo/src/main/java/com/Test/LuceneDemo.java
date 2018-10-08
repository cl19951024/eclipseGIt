package com.Test;

import java.io.File;

import javax.sound.midi.Synthesizer;

//hello word
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
	
	public static   void main(String[] args) {
		   try{  
			    
			   //全文搜索水电费
	        	Directory directory=FSDirectory.open(new File("C:/index3"));  
	              IndexWriterConfig config=new IndexWriterConfig(Version.LUCENE_CURRENT,new StandardAnalyzer());
	            		  IndexWriter writer = new IndexWriter(directory,config);
	              
	            //����8���ĵ�  
	            		  //创建文档对象 
	            Document doc1 = new Document();  
	            Document doc2 = new Document();  
	            Document doc3 = new Document();  
	            Document doc4 = new Document();  
	            Document doc5 = new Document();  
	     
	            doc1.add(new TextField("bookname", "�������������ɵ�",Store.YES));  
	            doc2.add(new TextField("bookname", "Ӣ�۶�Ů",Store.YES));  
	            doc3.add(new TextField("bookname", "��������",Store.YES));  
	            doc4.add(new TextField("bookname", "̫ƽ���",Store.YES));  
	            doc5.add(new TextField("bookname", "��333",Store.YES));  
	          
	              
	            writer.addDocument(doc1);  
	            writer.addDocument(doc2);  
	            writer.addDocument(doc3);  
	            writer.addDocument(doc4);  
	            writer.addDocument(doc5);  
	       
	            writer.close();  
	              
	            System.out.println("���������ɹ�");  
	            Analyzer analyzer=new StandardAnalyzer();
				  DirectoryReader ireader = DirectoryReader.open(directory);
				  IndexSearcher isearcher = new IndexSearcher(ireader);
				  QueryParser parser = new QueryParser(Version.LUCENE_CURRENT, "bookname", analyzer);
				  Query query = parser.parse("��");
		          ScoreDoc[] hits = isearcher.search(query, null, 1000).scoreDocs;		
		
				  for (int i = 0; i < hits.length; i++) {
		                Document hitDoc = isearcher.doc(hits[i].doc);
		             System.out.println("��ѯ������ֵ��:  "+hitDoc.get("bookname"));
		            }
		
	        }catch(Exception e){  
	            System.out.println(e.getStackTrace());  
	        }  
	
	}
public void add(){
int i=10;
}

}
