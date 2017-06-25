package learn.basic.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ����ģ��HTTP������GET/POST��ʽ 
 */
public class HttpUtils {
	private static String encoding = "UTF-8";
    /** 
     * ����GET���� 
     *  
     * @param url  Ŀ�ĵ�ַ 
     * @param parameters ���������Map���͡� 
     * @return Զ����Ӧ��� 
     */  
    public static String sendGet(String url, Map<String, String> parameters) { 
        String result="";
        BufferedReader in = null;// ��ȡ��Ӧ������  
        StringBuffer sb = new StringBuffer();// �洢����  
        String params = "";// ����֮��Ĳ���
        try {
            // �����������  
            if(parameters.size()==1){
                for(String name:parameters.keySet()){
                    sb.append(name).append("=").append(
                            java.net.URLEncoder.encode(parameters.get(name),  
                            "UTF-8"));
                }
                params=sb.toString();
            }else{
                for (String name : parameters.keySet()) {  
                    sb.append(name).append("=").append(  
                            java.net.URLEncoder.encode(parameters.get(name),  
                            		encoding)).append("&");  
                }  
                String temp_params = sb.toString();  
                params = temp_params.substring(0, temp_params.length() - 1);  
            }
            String full_url = url + "?" + params; 
            // ����URL����  
            java.net.URL connURL = new java.net.URL(full_url);  
            // ��URL����  
            java.net.HttpURLConnection httpConn = (java.net.HttpURLConnection) connURL  
                    .openConnection();  
            // ����ͨ������  
            httpConn.setRequestProperty("Accept", "*/*");  
            httpConn.setRequestProperty("Connection", "Keep-Alive");  
            httpConn.setRequestProperty("User-Agent",  
                    "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.1)");  
            // ����ʵ�ʵ�����  
            httpConn.connect();  
            // ��Ӧͷ����ȡ  
            Map<String, List<String>> headers = httpConn.getHeaderFields();  
            // �������е���Ӧͷ�ֶ�  
//            for (String key : headers.keySet()) {  
//                System.out.println(key + "\t��\t" + headers.get(key));  
//            }  
            // ����BufferedReader����������ȡURL����Ӧ,�����ñ��뷽ʽ  
            in = new BufferedReader(new InputStreamReader(httpConn  
                    .getInputStream(), encoding));  
            String line;  
            // ��ȡ���ص�����  
            while ((line = in.readLine()) != null) {  
                result += line;  
            }  
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {  
                if (in != null) {  
                    in.close();  
                }  
            } catch (IOException ex) {  
                ex.printStackTrace();  
            }  
        }
        return result ;
    }  
  
    /** 
     * ����POST���� 
     *  
     * @param url 
     *            Ŀ�ĵ�ַ 
     * @param parameters 
     *            ���������Map���͡� 
     * @return Զ����Ӧ��� 
     */  
    public static String sendPost(String url, Map<String, String> parameters) {  
        String result = "";// ���صĽ��  
        BufferedReader in = null;// ��ȡ��Ӧ������  
        PrintWriter out = null;  
        StringBuffer sb = new StringBuffer();// �����������  
        String params = "";// ����֮��Ĳ���  
        try {  
            // �����������  
            if (parameters.size() == 1) {  
                for (String name : parameters.keySet()) {  
                    sb.append(name).append("=").append(  
                            java.net.URLEncoder.encode(parameters.get(name),  
                            		encoding));  
                }  
                params = sb.toString();  
            } else {  
                for (String name : parameters.keySet()) {  
                    sb.append(name).append("=").append(  
                            java.net.URLEncoder.encode(parameters.get(name),  
                            		encoding)).append("&");  
                }  
                String temp_params = sb.toString();  
                params = temp_params.substring(0, temp_params.length() - 1);  
            }  
            // ����URL����  
            java.net.URL connURL = new java.net.URL(url);  
            // ��URL����  
            java.net.HttpURLConnection httpConn = (java.net.HttpURLConnection) connURL  
                    .openConnection();  
            // ����ͨ������  
            httpConn.setRequestProperty("Accept", "*/*");  
            httpConn.setRequestProperty("Connection", "Keep-Alive");  
            httpConn.setRequestProperty("User-Agent",  
                    "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.1)");  
            // ����POST��ʽ  
            httpConn.setDoInput(true);  
            httpConn.setDoOutput(true);  
            // ��ȡHttpURLConnection�����Ӧ�������  
            out = new PrintWriter(httpConn.getOutputStream());  
            // �����������  
            out.write(params);  
            // flush������Ļ���  
            out.flush();  
            // ����BufferedReader����������ȡURL����Ӧ�����ñ��뷽ʽ  
            in = new BufferedReader(new InputStreamReader(httpConn  
                    .getInputStream(), encoding));  
            String line;  
            // ��ȡ���ص�����  
            while ((line = in.readLine()) != null) {  
                result += line;  
            }  
        } catch (Exception e) {  
            e.printStackTrace();  
        } finally {  
            try {  
                if (out != null) {  
                    out.close();  
                }  
                if (in != null) {  
                    in.close();  
                }  
            } catch (IOException ex) {  
                ex.printStackTrace();  
            }  
        }  
        return result;  
    }  

	public static void setEncoding(String encoding) {
		HttpUtils.encoding = encoding;
	}

	/** 
     * ���������������� 
     *  
     * @param args 
     */  
    public static void main(String[] args) {  
        Map<String, String> parameters = new HashMap<String, String>();  
        parameters.put("m", "201703");  
        //String result =sendGet("http://www.easybots.cn/api/holiday.php", parameters);
        String result = "fda{201703:{\"04\":\"1\",\"05\":\"1\",\"11\":\"1\",\"12\":\"1\",\"18\":\"1\",\"19\":\"1\",\"25\":\"1\",\"26\":\"1\"}}def";
        String reg = "\\{.*\\}";
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(result);
        matcher.find();//��Ҫ�������ִ��
        System.out.println(matcher.group());
    }  
}