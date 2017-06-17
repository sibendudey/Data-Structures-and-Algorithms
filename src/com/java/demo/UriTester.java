package com.java.demo;

import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by deysi on 5/29/2017.
 */
public class UriTester {

    public static void main(String args[]) throws URISyntaxException {
        URI uri = new URI("http://192.168.1.76:8080/hpe/xcap/simservs.ngn.etsi.org/users/sip:sibendu.dey@sip.com/simservs.xml/~~/a:simservs/a:communication-diversion/%40active?namespace=xmlns%28a=http://uri.etsi.org/ngn/params/xml/simservs/xcap%29");

    }
}
