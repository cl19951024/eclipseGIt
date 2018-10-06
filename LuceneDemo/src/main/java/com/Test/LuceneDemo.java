package com.Test;

import java.io.File;
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
	
	public static void main(String[] args) {
		   try{  
			   //全文搜索水电费
	        	Directory directory=FSDirectory.open(new File("C:/index3"));  
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
	            doc5.add(new TextField("bookname", "��333",Store.YES));  
	          
	              
	            writer.addDocument(doc1);  
	            writer.addDocument(doc2);  
	            writer.addDocument(doc3);  
	            writer.addDocument(doc4);  
	            writer.addDocument(doc5);  
	       
	            writer.close();  
	              
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
			   if(hits!=null){
				  //ѭ��ȡ��Searcher�����е�ֵ������ʱ��ѯ�����Ľ������
				  for (int i = 0; i < hits.length; i++) {
					    //����ScoreDoc��ȡ����Document���󲢵õ�����Ҫ��ֵ  
		                Document hitDoc = isearcher.doc(hits[i].doc);
		             System.out.println("��ѯ������ֵ��:  "+hitDoc.get("bookname"));
		            }
			   }
	        }catch(Exception e){  
	            System.out.println(e.getStackTrace());  
	        }  
	
	  
		
	}
	/**
	 * 
     //����Document����  
    Document doc1 = new Document();  
     //��ӡ�name���ֶε�����  
    doc1.add(Field.Text("name", "word1 word2 word3"));  
     //��ӡ�title���ֶε�����  
    doc1.add(Field.Keyword("title", "doc1"));  
     //����������д��  
    IndexWriter writer = new IndexWriter("c://index", new StandardAnalyzer(), true);  
       
    //���ĵ���ӵ�������  
    writer.addDocument(doc1);  
     //�ر�����  
    writer.close();  
   
     //���ɲ�ѯ����query  
    Query query = null;  
       
    //����hits������󣬱��淵�صļ������  
    Hits hits = null;  
      
     //���ɼ�����  
    IndexSearcher searcher = new IndexSearcher("c://index");  
      
     // ����һ��TermQuery����  
    query = new TermQuery(new Term("name","word1"));  
     //��ʼ�����������ؼ��������hits��  
    hits = searcher.search(query);  
     //�����������е������Ϣ  
    printResult(hits, "word1");  
   
     // �ٴι���һ��TermQuery����ֻ������ѯ���ֶα����"title"  
    query = new TermQuery(new Term("title","doc1"));  
     //��ʼ�ڶ��μ����������ؼ��������hits��  
    hits = searcher.search(query);  
     //�����������е������Ϣ  
    printResult(hits, "doc1");  
   
  }  
   
  public static void printResult(Hits hits, String key) throws Exception  
  {  
    System.out.println("���� /"" + key + "/" :");  
    if (hits != null)  
    {  
      if (hits.length() == 0)  
      {  
        System.out.println("û���ҵ��κν��");  
      }  
      else  
      {  
        System.out.println("�ҵ�" + hits.length() + "�����");  
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
