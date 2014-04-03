/**
 * MarketPlace.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package lab2.Question2.MarketPlace;

public interface MarketPlace extends java.rmi.Remote {
    public boolean updateShoppingCart(java.lang.String buyerID, java.lang.String sellerID, int itemID, int quantity, boolean addToCart) throws java.rmi.RemoteException;
    public java.lang.String[] displayAdvertisement(java.lang.String buyerID) throws java.rmi.RemoteException;
    public boolean storeAdvertisement(java.lang.String itemName, java.lang.String itemDesc, float price, int quantity, java.lang.String userID) throws java.rmi.RemoteException;
    public void signOut(java.lang.String userID) throws java.rmi.RemoteException;
    public boolean buyProduct(java.lang.String buyerID) throws java.rmi.RemoteException;
    public java.lang.String[] buy(java.lang.String buyerID) throws java.rmi.RemoteException;
    public java.lang.String[] sell(java.lang.String sellerID) throws java.rmi.RemoteException;
    public java.lang.String[] viewCart(java.lang.String buyerID) throws java.rmi.RemoteException;
    public boolean signUp(java.lang.String first_name, java.lang.String last_name, java.lang.String emailID, java.lang.String password, java.lang.String userID) throws java.rmi.RemoteException;
    public java.lang.String signIn(java.lang.String userID, java.lang.String password) throws java.rmi.RemoteException;
}
