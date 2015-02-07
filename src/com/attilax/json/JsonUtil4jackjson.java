package com.attilax.json;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

    public class JsonUtil4jackjson {  
    	
    	public static void main(String[] args) {
			Map  m=new HashMap();
			m.put("a", "va");
			m.put("b",new HashMap(){{
				this.put("m2k1", "m2v1");
			}});
			String s=  JsonUtil4jackjson.buildNormalBinder().toJson(m);
			System.out.println(s);
		}
      
     //   private static Logger logger = LoggerFactory.getLogger(JsonBinder.class);  
      
        private ObjectMapper mapper;  
      
        public JsonUtil4jackjson(Inclusion inclusion) {  
            mapper = new ObjectMapper();  
            //�����������������  
            mapper.getSerializationConfig().setSerializationInclusion(inclusion);  
            //��������ʱ����JSON�ַ����д��ڶ�Java����ʵ��û�е�����  
            mapper.getDeserializationConfig().set(  
                    org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);  
        }  
      
        /** 
         * �������ȫ�����Ե�Json�ַ�����Binder. 
         */  
        public static JsonUtil4jackjson buildNormalBinder() {  
            return new JsonUtil4jackjson(Inclusion.ALWAYS);  
        }  
      
        /** 
         * ����ֻ����ǿ����Ե�Json�ַ�����Binder. 
         */  
        public static JsonUtil4jackjson buildNonNullBinder() {  
            return new JsonUtil4jackjson(Inclusion.NON_NULL);  
        }  
      
        /** 
         * ����ֻ�����ʼֵ���ı�����Ե�Json�ַ�����Binder. 
         */  
        public static JsonUtil4jackjson buildNonDefaultBinder() {  
            return new JsonUtil4jackjson(Inclusion.NON_DEFAULT);  
        }  
      
        /** 
         * ���JSON�ַ���ΪNull��"null"�ַ���,����Null. 
         * ���JSON�ַ���Ϊ"[]",���ؿռ���. 
         *  
         * �����ȡ������List/Map,�Ҳ���List<String>���ּ�����ʱʹ���������: 
         * List<MyBean> beanList = binder.getMapper().readValue(listString, new TypeReference<List<MyBean>>() {}); 
         */  
//        public <T> T fromJson(String jsonString, Class<T> clazz) {  
//            if (StringUtils.isEmpty(jsonString)) {  
//                return null;  
//            }  
//      
//            try {  
//                return mapper.readValue(jsonString, clazz);  
//            } catch (IOException e) {  
//                logger.warn("parse json string error:" + jsonString, e);  
//                return null;  
//            }  
//        }  
      
        /** 
         * �������ΪNull,����"null". 
         * �������Ϊ�ռ���,����"[]". 
         */  
        public String toJson(Object object) {  
      
            try {  
            //	SerializationConfig.Feature.FAIL_ON_EMPTY_BEANS
            //	SerializationConfig.Feature.
             	mapper.configure(SerializationConfig.Feature.INDENT_OUTPUT, Boolean.TRUE);
            	//���Ǹ������ã����Ƹ�ʽ�������
            //	mapper.writeValueAsString(value)
            	//format output
            	return	mapper.defaultPrettyPrintingWriter().writeValueAsString(object);
             //   return mapper.writeValueAsString(object);  
            } catch (IOException e) {  
             //   logger.warn("write to json string error:" + object, e);  
            	e.printStackTrace();
                return "";  
            }  
        }  
      
        /** 
         * ����ת���������͵�format pattern,���������Ĭ�ϴ�ӡTimestamp������. 
         */  
        public void setDateFormat(String pattern) {  
//            if (StringUtils.isNotBlank(pattern)) {  
//                DateFormat df = new SimpleDateFormat(pattern);  
//                mapper.getSerializationConfig().setDateFormat(df);  
//                mapper.getDeserializationConfig().setDateFormat(df);  
//            }  
        }  
      
        /** 
         * ȡ��Mapper����һ�������û�ʹ���������л�API. 
         */  
        public ObjectMapper getMapper() {  
            return mapper;  
        }  
    }  