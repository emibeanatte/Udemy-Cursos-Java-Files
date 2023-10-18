

package section_16.objects;

import java.io.Serializable;
import java.util.Map;




public class HTTPRequest implements Serializable {
    
    private String body;
    private Map<String,String> headers;

    public HTTPRequest(String body, Map<String, String> headers) {
        this.body = body;
        this.headers = headers;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }
    
    

}
