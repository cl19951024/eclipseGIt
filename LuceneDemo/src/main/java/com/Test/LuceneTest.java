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

	        try{  
	        	Directory directory=FSDirectory.open(new File("D:\\index5444"));
	              IndexWriterConfig config=new IndexWriterConfig(Version.LUCENE_CURRENT,new StandardAnalyzer());
	            		  IndexWriter writer = new IndexWriter(directory,config);
	              
	            //����8���ĵ�  
	            Document doc1 = new Document();  
	            Document doc2 = new Document();  
	            Document doc3 = new Document();  
	            Document doc4 = new Document();  
	            Document doc5 = new Document();  
	     
	            doc1.add(new TextField("bookname", "�������������ɵ�",Store.YES));  
	            doc2.add(new TextField("bookname", "Ӣ�۶�Ů",Store.YES));  
	            doc3.add(new TextField("bookname", "��������",Store.YES));  
	            doc4.add(new TextField("bookname", "̫ƽ���",Store.YES));  
	            doc5.add(new TextField("bookname", "�Ļ�����",Store.YES));  
	          //ghjkl
	              
	            writer.addDocument(doc1);  
	            writer.addDocument(doc2);  
	            writer.addDocument(doc3);  
	            writer.addDocument(doc4);  
	            writer.addDocument(doc5);  
	       
	            writer.close();  
	     
	            Analyzer analyzer=new StandardAnalyzer();
				  DirectoryReader ireader = DirectoryReader.open(directory);
				  IndexSearcher isearcher = new IndexSearcher(ireader);
				  QueryParser parser = new QueryParser(Version.LUCENE_CURRENT, "bookname", analyzer);
				  Query query = parser.parse("��");
		          ScoreDoc[] hits = isearcher.search(query, null, 1000).scoreDocs;			 
		          System.out.println("12345"); 
				  for (int i = 0; i < hits.length; i++) {
		                Document hitDoc = isearcher.doc(hits[i].doc);
		            }
	        }catch(Exception e){  
	            System.out.println(e.getStackTrace());  
	        }  
	
	  
		
		
	}

	public void del(){
		System.out.println("删除");
	}
}
