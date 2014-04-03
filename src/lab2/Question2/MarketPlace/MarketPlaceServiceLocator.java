/**
 * MarketPlaceServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package lab2.Question2.MarketPlace;

public class MarketPlaceServiceLocator extends org.apache.axis.client.Service implements lab2.Question2.MarketPlace.MarketPlaceService {

    public MarketPlaceServiceLocator() {
    }


    public MarketPlaceServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public MarketPlaceServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for MarketPlace
    private java.lang.String MarketPlace_address = "http://localhost:8080/SimpleMarketPlace/services/MarketPlace";

    public java.lang.String getMarketPlaceAddress() {
        return MarketPlace_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String MarketPlaceWSDDServiceName = "MarketPlace";

    public java.lang.String getMarketPlaceWSDDServiceName() {
        return MarketPlaceWSDDServiceName;
    }

    public void setMarketPlaceWSDDServiceName(java.lang.String name) {
        MarketPlaceWSDDServiceName = name;
    }

    public lab2.Question2.MarketPlace.MarketPlace getMarketPlace() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(MarketPlace_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getMarketPlace(endpoint);
    }

    public lab2.Question2.MarketPlace.MarketPlace getMarketPlace(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            lab2.Question2.MarketPlace.MarketPlaceSoapBindingStub _stub = new lab2.Question2.MarketPlace.MarketPlaceSoapBindingStub(portAddress, this);
            _stub.setPortName(getMarketPlaceWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setMarketPlaceEndpointAddress(java.lang.String address) {
        MarketPlace_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (lab2.Question2.MarketPlace.MarketPlace.class.isAssignableFrom(serviceEndpointInterface)) {
                lab2.Question2.MarketPlace.MarketPlaceSoapBindingStub _stub = new lab2.Question2.MarketPlace.MarketPlaceSoapBindingStub(new java.net.URL(MarketPlace_address), this);
                _stub.setPortName(getMarketPlaceWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("MarketPlace".equals(inputPortName)) {
            return getMarketPlace();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://MarketPlace.Question2.lab2", "MarketPlaceService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://MarketPlace.Question2.lab2", "MarketPlace"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("MarketPlace".equals(portName)) {
            setMarketPlaceEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
