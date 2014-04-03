package lab2.Question2.MarketPlace;

public class MarketPlaceProxy implements lab2.Question2.MarketPlace.MarketPlace {
  private String _endpoint = null;
  private lab2.Question2.MarketPlace.MarketPlace marketPlace = null;
  
  public MarketPlaceProxy() {
    _initMarketPlaceProxy();
  }
  
  public MarketPlaceProxy(String endpoint) {
    _endpoint = endpoint;
    _initMarketPlaceProxy();
  }
  
  private void _initMarketPlaceProxy() {
    try {
      marketPlace = (new lab2.Question2.MarketPlace.MarketPlaceServiceLocator()).getMarketPlace();
      if (marketPlace != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)marketPlace)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)marketPlace)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (marketPlace != null)
      ((javax.xml.rpc.Stub)marketPlace)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public lab2.Question2.MarketPlace.MarketPlace getMarketPlace() {
    if (marketPlace == null)
      _initMarketPlaceProxy();
    return marketPlace;
  }
  
  public boolean updateShoppingCart(java.lang.String buyerID, java.lang.String sellerID, int itemID, int quantity, boolean addToCart) throws java.rmi.RemoteException{
    if (marketPlace == null)
      _initMarketPlaceProxy();
    return marketPlace.updateShoppingCart(buyerID, sellerID, itemID, quantity, addToCart);
  }
  
  public java.lang.String[] displayAdvertisement(java.lang.String buyerID) throws java.rmi.RemoteException{
    if (marketPlace == null)
      _initMarketPlaceProxy();
    return marketPlace.displayAdvertisement(buyerID);
  }
  
  public boolean storeAdvertisement(java.lang.String itemName, java.lang.String itemDesc, float price, int quantity, java.lang.String userID) throws java.rmi.RemoteException{
    if (marketPlace == null)
      _initMarketPlaceProxy();
    return marketPlace.storeAdvertisement(itemName, itemDesc, price, quantity, userID);
  }
  
  public void signOut(java.lang.String userID) throws java.rmi.RemoteException{
    if (marketPlace == null)
      _initMarketPlaceProxy();
    marketPlace.signOut(userID);
  }
  
  public boolean buyProduct(java.lang.String buyerID) throws java.rmi.RemoteException{
    if (marketPlace == null)
      _initMarketPlaceProxy();
    return marketPlace.buyProduct(buyerID);
  }
  
  public java.lang.String[] buy(java.lang.String buyerID) throws java.rmi.RemoteException{
    if (marketPlace == null)
      _initMarketPlaceProxy();
    return marketPlace.buy(buyerID);
  }
  
  public java.lang.String[] sell(java.lang.String sellerID) throws java.rmi.RemoteException{
    if (marketPlace == null)
      _initMarketPlaceProxy();
    return marketPlace.sell(sellerID);
  }
  
  public java.lang.String[] viewCart(java.lang.String buyerID) throws java.rmi.RemoteException{
    if (marketPlace == null)
      _initMarketPlaceProxy();
    return marketPlace.viewCart(buyerID);
  }
  
  public boolean signUp(java.lang.String first_name, java.lang.String last_name, java.lang.String emailID, java.lang.String password, java.lang.String userID) throws java.rmi.RemoteException{
    if (marketPlace == null)
      _initMarketPlaceProxy();
    return marketPlace.signUp(first_name, last_name, emailID, password, userID);
  }
  
  public java.lang.String signIn(java.lang.String userID, java.lang.String password) throws java.rmi.RemoteException{
    if (marketPlace == null)
      _initMarketPlaceProxy();
    return marketPlace.signIn(userID, password);
  }
  
  
}