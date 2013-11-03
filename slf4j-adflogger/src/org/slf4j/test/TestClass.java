package org.slf4j.test;

import java.util.ArrayList;
import java.util.List;

import oracle.adf.share.logging.ADFLogger;

import org.junit.Before;

import org.junit.Test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class TestClass {

    
    private static final ADFLogger adfLogger= ADFLogger.createADFLogger(TestClass.class);
    private static final Logger slfLogger = LoggerFactory.getLogger(TestClass.class);
    
    private List<String> dummyList1=null;
    private List<Integer> dummyList2=null;
    
    private Exception dummyException=null;
    
    @Before
    public void setUp(){
    	
    	dummyList1=new ArrayList<String>();
    	dummyList1.add("Rock");
    	dummyList1.add("Paper");
    	dummyList1.add("Scissors");
    	
    	dummyList2=new ArrayList<Integer>();
    	dummyList2.add(21);
    	dummyList2.add(22);
    	dummyList2.add(23);
    	
    	dummyException=new Exception("Mind blowing Exception");
    	
    }

        @Test
	public void testLoggerLevels(){
		
        adfLogger.finest("finest Message from ADF Logger");
        slfLogger.trace("finest Message from SLF Logger");
        
        adfLogger.fine("fine Message from ADF Logger");
        slfLogger.debug("fine Message from SLF Logger");
        
        adfLogger.info("info Message from ADF Logger");
        slfLogger.info("info Message from SLF Logger");
        
        adfLogger.warning("warning Message from ADF Logger");
        slfLogger.warn("warning Message from SLF Logger");
        
        adfLogger.severe("severe Message from ADF Logger");
        slfLogger.error("severe Message from SLF Logger");
	}
    
    
    //@Test
  	public void testException(){
  		
          adfLogger.severe("severe Message from ADF Logger", dummyException);
          slfLogger.error("severe Message from SLF Logger", dummyException);
          
  	}
    
    //@Test
  	public void testParameters(){
  		 
          adfLogger.severe("severe Message from ADF Logger Param :{0}", dummyList1 );
          slfLogger.error("severe Message from SLF Logger Param :{}", dummyList1);
          
          adfLogger.severe("severe Message from ADF Logger Param 1 :[{0}] \n [{1}]", new Object[]{dummyList1, dummyList2} );
          slfLogger.error("severe Message from SLF Logger Param :{} \n {} ", dummyList1, dummyList2);
          slfLogger.error("severe Message from SLF Logger Param :[{}] \n [{}] ", new Object[]{dummyList1, dummyList2});
          
  	}

	
}
