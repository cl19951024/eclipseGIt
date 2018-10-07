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
//		//-------����Ҫ��ѯ������д�����ڴ�֮�У�������---------
//		
//		/*һ������һ���ʷ�������������һ�仰�����Ұ����ǵ��й���������ζ�����֣��۵�ͣ�ٴʡ��ġ�
//		 * ��ȡ�ؼ��֡��ҡ������ǡ����й����ȵȡ����Ҫ�����Ĵʷ�������Analyzer��ʵ�֡���
//		*/
//		Analyzer analyzer =new StandardAnalyzer();
//		//�����洢��ʽ������
//		//1���������ļ��洢��path���ļ���·��
//		//Directory directory = FSDirectory.open(new File("F:\\luceneIndex"));
//		//2)�ڴ�洢
//		Directory directory = new RAMDirectory();
//		//�������������ļ�д��
//		/*
//		 * new IndexWriterConfig�Ƕ�IndexWriter�������ã�
//		 * ��������������һ�������ǵ�ǰ�İ汾�ţ�
//		 *         �ڶ��������Ǵʷ�������
//		 * */
//		IndexWriterConfig config = new IndexWriterConfig(Version.LUCENE_CURRENT, analyzer);
//		try {
//			//new IndexWriter������������
//			//��һ���������ڴ�Ĵ��棬�ڶ�����IndexWriterConfig��IndexWriter�����á�
//			IndexWriter iwriter = new IndexWriter(directory, config);
//			//����document�ĵ��������������ݿ��е�һ�б����øö���Ҫ��ѯ�����ݱ������ڴ��У�
//			 Document doc = new Document();
//			 //����Ҫ��ѯ�����ݣ���������ж���������ƴ�ӳ�һ���ַ�������ȥ��
//			   String text1="��ã����ǳ���";
//			   String text2="index";
//			   String text3 = "��ã����ǳ¾�";
//			  /*�������ַ���ӵ��ĵ��У� 
//			   * fieldname:���ݵ����ƣ������ڱ���
//			   * TextField.TYPE_STORED��
//			   */
//			   doc.add(new TextField("text", text1, Store.YES));
//			   doc.add(new TextField("text", text2, Store.YES));
//			   doc.add(new TextField("text", text3, Store.YES));
//			  //���ĵ��������ڴ��С�
//			  iwriter.addDocument(doc);
//			  iwriter.close();
//			  
//			  //-----------�����ѯ--------------
//			  //һ���򿪴���λ��
//			  DirectoryReader ireader = DirectoryReader.open(directory);
//			  //��������������
//			  IndexSearcher isearcher = new IndexSearcher(ireader);
//			  //����������sql��䣬���йؼ��ʲ�ѯ
//			  /*
//			   * new QueryParser������ѯ��������������
//			   * ��һ����������ǰ�汾��
//			   * �ڶ�����������ѯ���ļ������ƣ������ڲ�ѯ�ı�����
//			   * ���������������ôʷ�������
//			   * */
//			  QueryParser parser = new QueryParser(Version.LUCENE_CURRENT, "text", analyzer);
//			 //��Ҫ��������ݱ�����Query�У���text�ǽ�Ҫ��ѯ�Ĺؼ��ʡ���
//			  Query query = parser.parse("index");
//			  //����Searcher��������TopDocsȻ���ȡScoreDoc�������������query�Ĳ�ѯ�ؼ��ʣ���  
//	          ScoreDoc[] hits = isearcher.search(query, null, 1000).scoreDocs;
		 
//			  //ѭ��ȡ��Searcher�����е�ֵ������ʱ��ѯ�����Ľ������
//			  for (int i = 0; i < hits.length; i++) {
//				    //����ScoreDoc��ȡ����Document���󲢵õ�����Ҫ��ֵ  
//	                Document hitDoc = isearcher.doc(hits[i].doc);
//	             System.out.println("��ѯ������ֵ��:  "+hitDoc.get("text"));
//	            }
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//   }


	 
	
	        // TODO Auto-generated method stub  
	  
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
	          
	              
	            writer.addDocument(doc1);  
	            writer.addDocument(doc2);  
	            writer.addDocument(doc3);  
	            writer.addDocument(doc4);  
	            writer.addDocument(doc5);  
	       
	            writer.close();  
	            System.out.println("������sdf��ɹ�");  
	            System.out.println("���������ɹ�");  
	            //һ���򿪴���λ��
	            Analyzer analyzer=new StandardAnalyzer();
				  DirectoryReader ireader = DirectoryReader.open(directory);
//				  //��������������
				  IndexSearcher isearcher = new IndexSearcher(ireader);
				  QueryParser parser = new QueryParser(Version.LUCENE_CURRENT, "bookname", analyzer);
//					 //��Ҫ��������ݱ�����Query�У���text�ǽ�Ҫ��ѯ�Ĺؼ��ʡ���
				  Query query = parser.parse("��");
				  //����Searcher��������TopDocsȻ���ȡScoreDoc�������������query�Ĳ�ѯ�ؼ��ʣ���  
		          ScoreDoc[] hits = isearcher.search(query, null, 1000).scoreDocs;			 
				
				  for (int i = 0; i < hits.length; i++) {
					    //����ScoreDoc��ȡ����Document���󲢵õ�����Ҫ��ֵ  
		                Document hitDoc = isearcher.doc(hits[i].doc);
		             System.out.println("��ѯ������ֵ��:  "+hitDoc.get("bookname"));
		            }
				
	        }catch(Exception e){  
	            System.out.println(e.getStackTrace());  
	        }  
	
	  
		
		
	}
	public void add(){
	System.out.println("khsjdfkhj");
		 
	}
}
