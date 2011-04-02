
package org.jboss.spring.examples.primrose.wstest;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.jboss.spring.examples.primrose.wstest package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _NotifyWatering_QNAME = new QName("http://ws.primrose.examples.spring.jboss.org/", "notifyWatering");
    private final static QName _NotifyWateringResponse_QNAME = new QName("http://ws.primrose.examples.spring.jboss.org/", "notifyWateringResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.jboss.spring.examples.primrose.wstest
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link NotifyWateringResponse }
     * 
     */
    public NotifyWateringResponse createNotifyWateringResponse() {
        return new NotifyWateringResponse();
    }

    /**
     * Create an instance of {@link NotifyWatering }
     * 
     */
    public NotifyWatering createNotifyWatering() {
        return new NotifyWatering();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NotifyWatering }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.primrose.examples.spring.jboss.org/", name = "notifyWatering")
    public JAXBElement<NotifyWatering> createNotifyWatering(NotifyWatering value) {
        return new JAXBElement<NotifyWatering>(_NotifyWatering_QNAME, NotifyWatering.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NotifyWateringResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.primrose.examples.spring.jboss.org/", name = "notifyWateringResponse")
    public JAXBElement<NotifyWateringResponse> createNotifyWateringResponse(NotifyWateringResponse value) {
        return new JAXBElement<NotifyWateringResponse>(_NotifyWateringResponse_QNAME, NotifyWateringResponse.class, null, value);
    }

}
